package One;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.shell.InvertedShell;
import org.apache.sshd.server.shell.ProcessShellFactory;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Collections;


public class BasicServer {
    public static void main(String[] args) throws IOException, InterruptedException {

        SshServer sshd = SshServer.setUpDefaultServer();
        sshd.setPort(8080);
        Path path = Paths.get("/media/nayan/Core 1/Projects/testing/Java-In-Depth/SFTPServer/ApaceMinaOne/src/main/java/One/KEY");
        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(path));
//        sshd.setShellFactory(new InvertedShell.Factory());
        sshd.setShellFactory(new ProcessShellFactory());

        sshd.setPasswordAuthenticator((username, password, session) -> username.equals("test") && password.equals("password"));

//            while (true) {
//
//            }
        sshd.start();
        System.out.println("SFTP server started");
        Thread.sleep(Long.MAX_VALUE);

    }
}
