/*Music Player Application
Create a class MusicPlayer. Create thread using Thread class.
Display song progress using sleep.
Output: Playing song...
Progress 1
Progress 2
Progress 3. */
import java.util.Scanner;

// Thread class
class Song extends Thread {
    String songName;
    int steps;

    Song(String songName, int steps) {
        this.songName = songName;
        this.steps = steps;
    }

    public void run() {
        System.out.println("Playing song: " + songName);

        for (int i = 1; i <= steps; i++) {
            System.out.println("Progress " + i);

            try {
                Thread.sleep(1000); // delay for 1 second
            } catch (Exception e) {}
        }

        System.out.println(songName + " finished playing");
    }
}

// Main class (same as file name)
public class MusicPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter song name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of progress steps: ");
        int steps = sc.nextInt();

        // Create and start thread
        Song s = new Song(name, steps);
        s.start();
    }
}
