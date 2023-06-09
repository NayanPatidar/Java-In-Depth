package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DelimiterMatchingApp {
    public static void main(String[] args) throws IOException {
        String input;

            System.out.print("Enter string containing delimiters: ");
            System.out.flush();
            input = getString();
            DelimiterMatching theChecker = new DelimiterMatching(input);
            theChecker.check();

    }


    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
        return br.readLine();

    }
}