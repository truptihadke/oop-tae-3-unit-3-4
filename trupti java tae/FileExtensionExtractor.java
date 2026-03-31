/*5. Define a class FileExtensionExtractor.
 Accept a file name (example: &quot;report.pdf&quot;).
 Extract file extension using substring() method.
 Display extracted extension. */
import java.util.Scanner;

public class FileExtensionExtractor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept file name
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        // Find position of last dot
        int index = fileName.lastIndexOf('.');

        // Check if dot exists
        if (index != -1 && index != fileName.length() - 1) {
            // Extract extension using substring
            String extension = fileName.substring(index + 1);
            System.out.println("File Extension: " + extension);
        } else {
            System.out.println("No valid extension found");
        }
    }
}
