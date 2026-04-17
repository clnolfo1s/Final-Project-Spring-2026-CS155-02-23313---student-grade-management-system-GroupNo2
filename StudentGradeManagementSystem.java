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
    }

    // 1. Add Student and Grade
    static void addStudent(Scanner input) {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student limit reached!");
            return;
        }

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student grade (0 - 100): ");
        int grade = input.nextInt();
        input.nextLine(); // Clear buffer

        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade! Please enter a value between 0 and 100.");
            return;
        }

        studentNames[studentCount] = name;
        studentGrades[studentCount] = grade;
        studentCount++;

        System.out.println("Student added successfully.");
    }

    // 2. Display All Students and Grades
    static void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\nList of Students and Grades:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(studentNames[i] + " - " + studentGrades[i]);
        }
    }

    // 3. Find a Student’s Grade
    static void findStudentGrade(Scanner input) {
        System.out.print("Enter student name to search: ");
        String searchName = input.nextLine();

        for (int i = 0; i < studentCount; i++) {
            if (studentNames[i].equalsIgnoreCase(searchName)) {
                System.out.println(searchName + "'s Grade: " + studentGrades[i]);
                return;
            }
        }

        System.out.println("Student not found.");
    }
    // 4. Calculate Class Average
    static void calculateAverage() {
        if (studentCount == 0) {
            System.out.println("No grades available to calculate average.");
            return;
        }

        int total = 0;
        for (int i = 0; i < studentCount; i++) {
            total += studentGrades[i];
        }

        double average = (double) total / studentCount;
        System.out.println("Class Average: " + average);
    }

    // 5. Find Highest and Lowest Grades
    static void findHighestAndLowest() {
        if (studentCount == 0) {
            System.out.println("No student records available.");
            return;
        }

        int highest = studentGrades[0];
        int lowest = studentGrades[0];
        int highIndex = 0;
        int lowIndex = 0;

        for (int i = 1; i < studentCount; i++) {
            if (studentGrades[i] > highest) {
                highest = studentGrades[i];
                highIndex = i;
            }
            if (studentGrades[i] < lowest) {
                lowest = studentGrades[i];
                lowIndex = i;
            }
        }

        System.out.println("Highest Grade: " + studentNames[highIndex] + " - " + highest);
        System.out.println("Lowest Grade: " + studentNames[lowIndex] + " - " + lowest);
    }
}
