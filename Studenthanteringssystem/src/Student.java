public class Student {
    private String id;
    private String name;
    private String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String toFileString() {
        return id + "," + name + "," + grade;
    }

    @Override
    public String toString() {
        return "Student-ID: " + id + ", Namn: " + name + ", Betyg: " + grade;
    }
}
