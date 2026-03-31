/*Create a class WordCounter.
 Accept a sentence from the user.
 Use StringTokenizer to count words.

 Display total number of words. */
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept sentence
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Create StringTokenizer object
        StringTokenizer st = new StringTokenizer(sentence);

        // Count words
        int count = st.countTokens();

        // Display result
        System.out.println("Total number of words: " + count);
    }
}
