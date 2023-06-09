import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        args = new String[100];

        for (int i =0 ; i< 100 ; i++){
            args[i] = br.readLine();
            if(args[i].equals("stops") ){
                break;
            }
        }

        System.out.println("Result!!");

        for (int i = 0 ; i < args.length; i++){
            if (args[i].equals("stops")) break;
            System.out.println(args[i]);
        }

    }
}
