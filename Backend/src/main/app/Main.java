package JavaApp.src.main.app;

import JavaApp.src.main.exceptions.*;
import JavaApp.src.main.models.*;
import JavaApp.src.main.services.*;
import JavaApp.src.main.utils.InputValidator;

public class Main {
    public static void main(String[] args) {
        DatabaseService dbService = new DatabaseService();
        StudentService studentService = new StudentService(dbService);
        CourseService courseService = new CourseService(dbService);

        try {
            // Create students
            studentService.createStudent(1, "John Doe", 20, "john.doe@university.com");
            studentService.createStudent(2, "Jane Smith", 19, "jane.smith@university.com");

            // Create courses
            courseService.createCourse(101, "Mathematics", "Dr. Brown", 4);
            courseService.createCourse(102, "Physics", "Dr. Green", 3);

            // Enroll students in courses
            Student john = studentService.getStudent(1);
            Course math = courseService.getCourse(101);
            Course physics = courseService.getCourse(102);
            john.enrollCourse(math);
            john.enrollCourse(physics);

            // Display information
            System.out.println("Student Information:");
            System.out.println(john);
            System.out.println("\nEnrolled Courses:");
            for (Course course : john.getEnrolledCourses()) {
                System.out.println(course);
            }

            // Test exception handling
            try {
                studentService.getStudent(999);
            } catch (StudentNotFoundException e) {
                System.out.println("\nException caught: " + e.getMessage());
            }

            // Test validation
            try {
                studentService.createStudent(3, "", 15, "invalid-email");
            } catch (IllegalArgumentException e) {
                System.out.println("Validation error: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
