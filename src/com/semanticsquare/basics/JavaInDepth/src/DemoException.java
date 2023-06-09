import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DemoException  {
    public static void main(String[] args) {
        int a,c,b;
        a = 6;
        b = 0;
        c = 0;
        System.out.println("Enter Value");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            if (a < 10)
            {
                throw new Exception("Issuee");
            }

        }
        catch (Exception r){
            System.out.println(r);
        }
    }
}
