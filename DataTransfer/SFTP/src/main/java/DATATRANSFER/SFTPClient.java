package DATATRANSFER;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SFTPClient {
    public static void main(String[] args) {
        JSch jSch = new JSch();

        try {
            Session session = jSch.getSession("Nayan", "10.200.233.92", 200 );
            session.setPassword("Indore123$");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println("Started");

            if (session.isConnected()){
                System.out.println("Is connected");
            } else if (!session.isConnected()) {
                System.out.println("Not connected");
            }
        } catch (JSchException e) {
            System.out.println("Error Occurred");
        }
    }
}
