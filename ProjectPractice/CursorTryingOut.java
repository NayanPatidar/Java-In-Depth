import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CursorTryingOut {
    public static void main(String[] args) {
        int x,y;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            x = bufferedReader.read();
            y = bufferedReader.read();

        }catch (IOException io){
            System.out.println("There is some error");
        }
    }
}
