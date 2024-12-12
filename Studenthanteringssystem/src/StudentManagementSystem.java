import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private static StudentManagementSystem instance;
    private Map<String, Student> studentRecords = new HashMap<>();
    private final String fileName = "students.txt";

    private StudentManagementSystem() {}

    public static StudentManagementSystem getInstance() {
        if (instance == null) {
            instance = new StudentManagementSystem();
        }
        return instance;
    }

    public void addStudent(String id, String name, String grade) {
        if (studentRecords.containsKey(id)) {
            System.out.println("Student-ID finns redan.");
            return;
        }
        studentRecords.put(id, new Student(id, name, grade));
        System.out.println("Student tillagd!");
    }

    public void displayAllStudents() {
        if (studentRecords.isEmpty()) {
            System.out.println("Inga studenter att visa.");
            return;
        }
        for (Student student : studentRecords.values()) {
            System.out.println(student);
        }
    }

    public void searchStudentById(String id) {
        Student student = studentRecords.get(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student med ID " + id + " hittades inte.");
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : studentRecords.values()) {
                writer.write(student.toFileString());
                writer.newLine();
            }
            System.out.println("Studentposter sparade till fil.");
        } catch (IOException e) {
            System.err.println("Fel vid skrivning till fil: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            studentRecords.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    addStudent(parts[0], parts[1], parts[2]);
                }
            }
            System.out.println("Studentposter lästa från fil.");
        } catch (IOException e) {
            System.err.println("Fel vid läsning från fil: " + e.getMessage());
        }
    }
}
