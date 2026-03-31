/*Define a class TextEditorBuffer.
 Create a string using StringBuffer.
 Append text to the string.
 Insert text at a specific position.
 Reverse the final string and display it. */
import java.util.Scanner;

public class TextEditorBuffer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create string using StringBuffer
        System.out.print("Enter initial text: ");
        String input = sc.nextLine();
        StringBuffer sb = new StringBuffer(input);

        // Step 2: Append text
        System.out.print("Enter text to append: ");
        String appendText = sc.nextLine();
        sb.append(appendText);

        // Step 3: Insert text
        System.out.print("Enter text to insert: ");
        String insertText = sc.nextLine();

        System.out.print("Enter position to insert: ");
        int pos = sc.nextInt();

        // Check position validity
        if (pos >= 0 && pos <= sb.length()) {
            sb.insert(pos, insertText);
        } else {
            System.out.println("Invalid position, skipping insert.");
        }

        // Step 4: Reverse string
        sb.reverse();

        // Display final string
        System.out.println("Final String: " + sb.toString());
    }
}
