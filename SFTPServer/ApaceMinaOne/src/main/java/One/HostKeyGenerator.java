//package One;
//
//import org.apache.sshd.common.session.SessionContext;
//import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.security.KeyPair;
//import java.util.List;
//
//public class HostKeyGenerator {
//    public static void main(String[] args) {
//
////         Currently Adding Path of the KEY
//        Path path = Paths.get("/media/nayan/Core 1/Projects/testing/Java-In-Depth/SFTPServer/ApaceMinaOne/src/main/java/One/KEY");
//        System.out.println(path.getFileSystem());
//        SimpleGeneratorHostKeyProvider hostKeyProvider = new SimpleGeneratorHostKeyProvider();
//        hostKeyProvider.setKeySize(2048);
//        hostKeyProvider.setPath(path);
//        hostKeyProvider.loadKeys(null);
//
////        SimpleGeneratorHostKeyProvider hostKeyProvider = new SimpleGeneratorHostKeyProvider();
////
////        // Load available key pairs from the provider
////        List<KeyPair> keyPairs = hostKeyProvider.loadKeys(null);
////
////        // Print information about the loaded key pairs
////        for (KeyPair keyPair : keyPairs) {
////            System.out.println("Loaded key pair: " + keyPair);
////        }
//
//    }
//    }
