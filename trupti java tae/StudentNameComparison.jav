/*Define a class StudentNameComparison.
 Accept two student names.
 Compare them using case-sensitive comparison.

 Compare them using case-insensitive comparison.
 Display appropriate message. */
import java.util.Scanner;

public class StudentNameComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept two names
        System.out.print("Enter first student name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter second student name: ");
        String name2 = sc.nextLine();

        // Case-sensitive comparison
        if (name1.equals(name2)) {
            System.out.println("Case-Sensitive: Names are equal");
        } else {
            System.out.println("Case-Sensitive: Names are NOT equal");
        }

        // Case-insensitive comparison
        if (name1.equalsIgnoreCase(name2)) {
            System.out.println("Case-Insensitive: Names are equal");
        } else {
            System.out.println("Case-Insensitive: Names are NOT equal");
        }
    }
}