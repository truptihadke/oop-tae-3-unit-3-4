/*Thread Priority System
Create a class ThreadPrioritySystem. Create multiple threads
and assign different priorities and observe execution order.
Output: Thread execution messages. */

class MyThread extends Thread {
    public void run() {
        System.out.println("Running Thread: " + Thread.currentThread().getName() +
                           " | Priority: " + Thread.currentThread().getPriority());
    }
}

public class ThreadPrioritySystem {
    public static void main(String[] args) {

        // Create threads
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        // Set names
        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        // Set priorities (1 to 10)
        t1.setPriority(Thread.MIN_PRIORITY);   // 1
        t2.setPriority(Thread.NORM_PRIORITY);  // 5
        t3.setPriority(Thread.MAX_PRIORITY);   // 10

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}
