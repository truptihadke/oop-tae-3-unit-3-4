/*Railway Reservation System

Create a class RailwayReservation. Use synchronization to
avoid double booking.
Output: 'Ticket booked successfully' or 'No tickets available' */
import java.util.Scanner;

class Reservation {
    int tickets;

    Reservation(int tickets) {
        this.tickets = tickets;
    }

    // synchronized method
    synchronized void bookTicket(String name, int seats) {
        System.out.println(name + " is trying to book " + seats + " ticket(s)");

        if (tickets >= seats) {
            System.out.println("Ticket booked successfully for " + name);
            tickets -= seats;
            System.out.println("Remaining tickets: " + tickets);
        } else {
            System.out.println("No tickets available for " + name);
        }

        System.out.println("-----------------------------------");
    }
}

// Thread class
class User extends Thread {
    Reservation r;
    String name;
    int seats;

    User(Reservation r, String name, int seats) {
        this.r = r;
        this.name = name;
        this.seats = seats;
    }

    public void run() {
        r.bookTicket(name, seats);
    }
}

// Main class (MUST match file name)
public class RailwayReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total tickets available: ");
        int total = sc.nextInt();

        Reservation r = new Reservation(total);

        System.out.print("Enter seats for User1: ");
        int s1 = sc.nextInt();

        System.out.print("Enter seats for User2: ");
        int s2 = sc.nextInt();

        User u1 = new User(r, "User1", s1);
        User u2 = new User(r, "User2", s2);

        u1.start();
        u2.start();
    }
}
