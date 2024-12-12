import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = StudentManagementSystem.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMeny:");
            System.out.println("1. Lägg till student");
            System.out.println("2. Visa alla studenter");
            System.out.println("3. Sök student via ID");
            System.out.println("4. Spara till fil");
            System.out.println("5. Läs från fil");
            System.out.println("6. Avsluta");
            System.out.print("Välj ett alternativ: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ange Student-ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Ange namn: ");
                    String name = scanner.nextLine();
                    System.out.print("Ange betyg: ");
                    String grade = scanner.nextLine();
                    system.addStudent(id, name, grade);
                    break;
                case 2:
                    system.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Ange Student-ID: ");
                    id = scanner.nextLine();
                    system.searchStudentById(id);
                    break;
                case 4:
                    system.saveToFile();
                    break;
                case 5:
                    system.loadFromFile();
                    break;
                case 6:
                    running = false;
                    System.out.println("Avslutar programmet...");
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }

        scanner.close();
    }
}
