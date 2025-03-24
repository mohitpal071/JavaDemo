package JavaApp.src.main.services;

import JavaApp.src.main.exceptions.CourseNotFoundException;
import JavaApp.src.main.models.Course;

public class CourseService {
    private DatabaseService dbService;

    public CourseService(DatabaseService dbService) {
        this.dbService = dbService;
    }

    public void createCourse(int id, String name, String instructor, int credits) {
        Course course = new Course(id, name, instructor, credits);
        dbService.saveCourse(course);
    }

    public Course getCourse(int id) throws CourseNotFoundException {
        Course course = dbService.getCourse(id);
        if (course == null) {
            throw new CourseNotFoundException("Course with ID " + id + " not found");
        }
        return course;
    }
}