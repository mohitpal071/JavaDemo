package JavaApp.src.main.utils;

public class InputValidator {
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidAge(int age) {
        return age >= 16 && age <= 100;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 50;
    }
}
