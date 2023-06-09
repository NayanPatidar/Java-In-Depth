package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReverseApp {
    public static void main(String[] args) throws IOException {
         String input,output;
         input = getString();
         Reverser rev = new Reverser(input);
         output = rev.stringReverse();
        System.out.println("Reversed String: " + output);
    }

    public static String getString() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a String: ");
        String input = bf.readLine();
        return input;
     }
}
