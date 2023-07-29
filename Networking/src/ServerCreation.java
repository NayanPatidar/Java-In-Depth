import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class ServerCreation {
    public static void CreatingServer() throws IOException, InterruptedException {
        System.out.print("Server is getting started ");
        animation();
        TimeUnit.SECONDS.sleep(5);

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/",new SimpleHttpServer());

        server.start();
        TimeUnit.SECONDS.sleep(8);
        System.out.println("Closing Server ...");
        server.stop(1);

    }

    public static void animation() throws InterruptedException {
        for (int i = 0; i < 3; i++){
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
        }
        System.out.println();
    }
}
