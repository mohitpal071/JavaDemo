package JavaApp.src.main.models;

public class Course {
    private int id;
    private String name;
    private String instructor;
    private int credits;

    public Course(int id, String name, String instructor, int credits) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        System.out.println("Hello");
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course{id=" + id + ", name='" + name + "', instructor='" + instructor +
                "', credits=" + credits + "}";
    }
}
