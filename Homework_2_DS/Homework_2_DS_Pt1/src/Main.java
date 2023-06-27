import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String file_old = "C:\\Users\\amina\\Downloads\\Homework_2_DS\\Global_University_Students.csv";
        // Load the unsorted file into an array
        Student[] students;
        try {
            students = FileUtils.readFile(file_old);
        } catch (IOException e) {
            System.out.println("Error: Failed to load the file.");
            return;
        }
        // Sort the array using merge sort
        MergeSort.sort(students);
        // Save the sorted array to a new CSV file


        try {
            FileUtils.writeToFile(students, "sorted_file.csv");
        } catch (IOException e) {
            System.out.println("Error: Failed to save the sorted file.");
            return;
        }

        // Start the search process
        System.out.println("Welcome to the Student Search System!");
        while (true) {
            System.out.print("Enter a student ID to search (or -1 to exit): ");
            int searchId = scanner.nextInt();

            if (searchId == -1) {
                System.out.println("Thank you for using the Student Search System. Goodbye!");
                break;
            }

            // Perform binary search on the sorted student array
            int index = BinarySearch.search(students, searchId);

            if (index != -1) {
                // Student found
                Student student = students[index];
                System.out.println("Student Found:");
                System.out.println("Global ID: " + student.getGlobalId());
                System.out.println("Name: " + student.getName());
                System.out.println("Date of Birth: " + student.getDateOfBirth());
                System.out.println("University: " + student.getUniversityName());
                System.out.println("Department Code: " + student.getDepartmentCode());
                System.out.println("Department Name: " + student.getDepartmentName());
                System.out.println("Year of Enrollment: " + student.getYearOfEnrollment());
                System.out.println("Number of Steps: " + BinarySearch.numSteps);
            } else {
                // Student not found
                System.out.println("Error: Student with ID " + searchId + " not found.");
                System.out.println("Number of Steps: " + BinarySearch.numSteps);
            }
        }
    }
}