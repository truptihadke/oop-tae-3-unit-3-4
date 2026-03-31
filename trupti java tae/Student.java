/* Define a class Student with attributes id and name.

 Override toString() method.
 Create object of class.
 Display object details using toString().*/

import java.util.Scanner;

public class Student {
    int id;
    String name;

    // Constructor
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override toString() method
    public String toString() {
        return "Student ID: " + id + "\nStudent Name: " + name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        // Create object
        Student s = new Student(id, name);

        // Display using toString()
        System.out.println("\nStudent Details:");
        System.out.println(s);
    }
}
