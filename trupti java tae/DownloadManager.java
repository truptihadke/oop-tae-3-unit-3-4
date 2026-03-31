/*Download Manager
Create a class DownloadManager. Create multiple threads using
Runnable interface. Each thread represents file download.
Output: Downloading messages. */
import java.util.Scanner;

// Runnable class
class DownloadTask implements Runnable {
    String fileName;

    DownloadTask(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        System.out.println("Downloading: " + fileName);

        try {
            Thread.sleep(1000); // simulate download time
        } catch (Exception e) {}

        System.out.println(fileName + " download completed");
        System.out.println("-----------------------------------");
    }
}

// Main class (same as file name)
public class DownloadManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files to download: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Thread[] threads = new Thread[n];

        // Taking file names dynamically
        for (int i = 0; i < n; i++) {
            System.out.print("Enter file name " + (i + 1) + ": ");
            String name = sc.nextLine();

            DownloadTask task = new DownloadTask(name);
            threads[i] = new Thread(task);
        }

        // Start all threads
        for (int i = 0; i < n; i++) {
            threads[i].start();
        }
    }
}
