/*Create a class ATMWithdrawal. Accept account balance and

withdrawal amount from the user. If withdrawal amount is
greater than balance, throw an exception manually using throw.
Otherwise deduct amount and display updated balance.
Output: If sufficient balance: 'Withdrawal successful.
Remaining balance: <balance>' Else: 'Insufficient Balance' */
import java.util.Scanner;

public class ATMWithdrawal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account balance: ");
            int balance = sc.nextInt();

            System.out.print("Enter withdrawal amount: ");
            int amount = sc.nextInt();

            // Check condition
            if (amount > balance) {
                throw new Exception("Insufficient Balance");
            }

            balance = balance - amount;

            System.out.println("Withdrawal successful.");
            System.out.println("Remaining balance: " + balance);

        } catch (Exception e) {
            System.out.println("Insufficient Balance");
        }
    }
}
