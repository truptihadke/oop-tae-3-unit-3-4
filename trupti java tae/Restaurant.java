/* Producer Consumer System

Create a class Restaurant. Chef prepares food and waiter serves
it using wait() and notify().
Output: 'Chef prepared food' and 'Waiter served food'*/
class Restaurant {
    boolean foodReady = false;

    // Chef prepares food
    synchronized void prepareFood() {
        try {
            if (foodReady) {
                wait();
            }

            System.out.println("Chef prepared food");
            foodReady = true;

            notify();
        } catch (Exception e) {}
    }

    // Waiter serves food
    synchronized void serveFood() {
        try {
            if (!foodReady) {
                wait();
            }

            System.out.println("Waiter served food");
            foodReady = false;

            notify();
        } catch (Exception e) {}
    }

    // Main method (IMPORTANT)
    public static void main(String[] args) {
        Restaurant r = new Restaurant();

        Chef chef = new Chef(r);
        Waiter waiter = new Waiter(r);

        chef.start();
        waiter.start();
    }
}

// Chef Thread
class Chef extends Thread {
    Restaurant r;

    Chef(Restaurant r) {
        this.r = r;
    }

    public void run() {
        r.prepareFood();
    }
}

// Waiter Thread
class Waiter extends Thread {
    Restaurant r;

    Waiter(Restaurant r) {
        this.r = r;
    }

    public void run() {
        r.serveFood();
    }
}
