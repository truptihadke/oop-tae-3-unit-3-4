/* Create a class PasswordMaskingSystem.
 Accept password from the user.
 Replace all characters except last two using replace()
method.
 Display masked password.*/

import java.util.Scanner;

public class PasswordMaskingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Check if password length is less than 2
        if (password.length() <= 2) {
            System.out.println("Masked Password: " + password);
        } else {
            // Extract last 2 characters
            String lastTwo = password.substring(password.length() - 2);

            // Replace all characters with *
            String masked = password.substring(0, password.length() - 2).replaceAll(".", "*");

            // Combine
            String result = masked + lastTwo;

            System.out.println("Masked Password: " + result);
        }
    }
}
