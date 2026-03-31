/* File Processing System
Create a class FileProcessingSystem. Simulate file reading using
try-catch. Use finally block to display cleanup message.
Output: 'Reading file...' and 'Closing file resources'*/
import java.util.Scanner;

public class FileProcessingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        try {
            // Simulating file reading
            System.out.println("Reading file: " + fileName);

            // Simulate error if file name is empty
            if (fileName.isEmpty()) {
                throw new Exception("File not found");
            }

            System.out.println("File read successfully");

        } catch (Exception e) {
            System.out.println("Error while reading file");

        } finally {
            // Always executes
            System.out.println("Closing file resources");
        }
    }
}