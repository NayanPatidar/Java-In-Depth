import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class SimpleHttpServer implements HttpHandler{

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message = "Hey !!! Let's go. Finally learned how to set up http servers in Java";

        exchange.getResponseHeaders().set("Content-Type", "text/plain");
        exchange.sendResponseHeaders(200, message.getBytes().length);

        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(message.getBytes(StandardCharsets.UTF_8));
    }
}