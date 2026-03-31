public class BankingSystem {
    int balance = 1000;

    void withdraw(String name, int amount) {
        synchronized (this) {
            System.out.println(name + " wants to withdraw " + amount);

            if (balance >= amount) {
                System.out.println(name + " is withdrawing...");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}

                balance -= amount;
                System.out.println(name + " completed withdrawal.");
                System.out.println("Remaining Balance: " + balance);
            } else {
                System.out.println("Not enough balance for " + name);
            }
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        Thread t1 = new Thread(() -> bank.withdraw("Alice", 700));
        Thread t2 = new Thread(() -> bank.withdraw("Bob", 500));

        t1.start();
        t2.start();
    }
}