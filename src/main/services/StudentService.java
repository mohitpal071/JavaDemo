package JavaApp.src.main.services;

import JavaApp.src.main.exceptions.StudentNotFoundException;
import JavaApp.src.main.models.Student;
import JavaApp.src.main.utils.InputValidator;

public class StudentService {
    private DatabaseService dbService;

    public StudentService(DatabaseService dbService) {
        this.dbService = dbService;
    }

    public void createStudent(int id, String name, int age, String email)
            throws IllegalArgumentException {
        if (!InputValidator.isValidName(name)) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (!InputValidator.isValidAge(age)) {
            throw new IllegalArgumentException("Invalid age");
        }
        if (!InputValidator.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }

        Student student = new Student(id, name, age, email);
        dbService.saveStudent(student);
    }

    public Student getStudent(int id) throws StudentNotFoundException {
        Student student = dbService.getStudent(id);
        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
        return student;
    }
}