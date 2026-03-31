/*Online Shopping System
Create a class OnlineShoppingSystem. Create threads for
payment and order processing.
Output: 'Processing payment...' and 'Order confirmed...' */
// Payment Thread
class Payment extends Thread {
    public void run() {
        System.out.println("Processing payment...");
    }
}

// Order Thread
class Order extends Thread {
    public void run() {
        System.out.println("Order confirmed...");
    }
}

// Main class (same as file name)
public class OnlineShoppingSystem {
    public static void main(String[] args) {

        // Create threads
        Payment p = new Payment();
        Order o = new Order();

        // Start threads
        p.start();
        o.start();
    }
}
