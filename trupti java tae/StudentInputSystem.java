/*Create a class StudentInputSystem. Accept student age from

user. Handle invalid input using multiple catch blocks such as
InputMismatchException and ArithmeticException.

Output: If valid: 'Student age is: <age>' Else: 'Invalid input' */
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInputSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter student age: ");
            int age = sc.nextInt();

            // Check for negative age
            if (age < 0) {
                throw new Exception("Invalid Input");
            }

            // simulate arithmetic exception (for learning)
            int check = 10 / age;

            System.out.println("Student age is: " + age);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");

        } catch (ArithmeticException e) {
            System.out.println("Invalid input");

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}