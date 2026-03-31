/*Design a program EmailChecker.
 Accept an email address from the user.
 Check whether the email contains &quot;@gmail.com&quot;.
Display Valid Gmail Address or Invalid Email*/
import java.util.Scanner;

public class EmailChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept email
        System.out.print("Enter email address: ");
        String email = sc.nextLine();

        // Check if email contains "@gmail.com"
        if (email.contains("@gmail.com")) {
            System.out.println("Valid Gmail Address");
        } else {
            System.out.println("Invalid Email");
        }
    }
}