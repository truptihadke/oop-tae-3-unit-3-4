/*4. Create a class MessageFormatter.
 Accept first name and last name.
 Concatenate both names with space.
 Display full name in proper format. */
import java.util.Scanner;

public class MessageFormatter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept first name
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();

        // Accept last name
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();

        // Concatenate names with space
        String fullName = firstName + " " + lastName;

        // Display result
        System.out.println("Full Name: " + fullName);
    }
}
