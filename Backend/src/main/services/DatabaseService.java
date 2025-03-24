package JavaApp.src.main.services;

import JavaApp.src.main.models.Student;
import JavaApp.src.main.models.Course;
import java.util.HashMap;
import java.util.Map;

public class DatabaseService {
    private Map<Integer, Student> students;
    private Map<Integer, Course> courses;

    public DatabaseService() {
        students = new HashMap<>();
        courses = new HashMap<>();
    }

    public void saveStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void saveCourse(Course course) {
        courses.put(course.getId(), course);
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public Course getCourse(int id) {
        return courses.get(id);
    }

    public Map<Integer, Student> getAllStudents() {
        return new HashMap<>(students);
    }
}