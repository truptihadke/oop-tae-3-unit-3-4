/*Create a class called UsernameValidator.
 Accept a username from the user.
 Remove leading and trailing spaces.
 Convert the username to lowercase.
 Display the cleaned username. */
import java.util.Scanner;

public class UsernameValidator {

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Ask user for username
        System.out.print("Enter your username: ");
        String username = sc.nextLine();

        // Remove leading and trailing spaces
        username = username.trim();

        // Convert to lowercase
        username = username.toLowerCase();

        // Display cleaned username
        System.out.println("Cleaned Username: " + username);

        // Close scanner
        sc.close();
    }
}