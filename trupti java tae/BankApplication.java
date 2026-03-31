/* Bank Application
Create a class BankApplication. Define method that throws
exception using throws. Call method in main and handle
exception.
Output: 'Transaction processed' or 'Exception handled in main'*/
import java.util.Scanner;

public class BankApplication {

    // Method that throws exception
    static void processTransaction(int amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid amount");
        }
        System.out.println("Transaction processed");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction amount: ");
        int amount = sc.nextInt();

        try {
            processTransaction(amount); // calling method
        } catch (Exception e) {
            System.out.println("Exception handled in main");
        }
    }
}
