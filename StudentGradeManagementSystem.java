import java.util.Scanner;

public class StudentGradeManagementSystem {

    static final int MAX_STUDENTS = 50;

    static String[] studentNames = new String[MAX_STUDENTS];
    static int[] studentGrades = new int[MAX_STUDENTS];
    static int studentCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            // Menu
            System.out.println("\nWelcome to Student Grade Management System");
            System.out.println("1. Add Student and Grade");
            System.out.println("2. Display All Students and Grades");
            System.out.println("3. Find a Student's Grade");
            System.out.println("4. Calculate Class Average");
            System.out.println("5. Find Highest and Lowest Grades");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
choice = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addStudent(input);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    findStudentGrade(input);
                    break;

                case 4:
                    calculateAverage();
                    break;

                case 5:
                    findHighestAndLowest();
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 6.");
            }

        } while (choice != 6);

        input.close();
