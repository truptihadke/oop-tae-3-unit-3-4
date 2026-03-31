/* Create a class TextProcessingBuilder.
 Use StringBuilder to create a string.
 Append additional text.
 Display modified string.
 Write a comment comparing StringBuilder and
StringBuffer.*/
import java.util.Scanner;

public class TextProcessingBuilder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept initial text
        System.out.print("Enter initial text: ");
        String text = sc.nextLine();

        // Create StringBuilder object
        StringBuilder sb = new StringBuilder(text);

        // Accept additional text
        System.out.print("Enter text to append: ");
        String extra = sc.nextLine();

        // Append text
        sb.append(extra);

        // Display result
        System.out.println("Modified String: " + sb.toString());
    }
}

