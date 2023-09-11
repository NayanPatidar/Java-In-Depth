package ConcurrentThreadsOne;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;

public class CoordinatesTransfer {
    ServerSocket socket;
    boolean breakOrNot = false;
    InetAddress serverAddress;

    {
        try {
            serverAddress = InetAddress.getByName("10.200.233.131");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    int serverPortSend = 12345;
    int serverPortReceive = 12346;

    {
        try {
            socket = new ServerSocket(serverPortSend);
            waitForTheClient = socket.accept();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Socket waitForTheClient;

    public static void main(String[] args) {
        Point mousePosition = MouseInfo.getPointerInfo().getLocation();
        CoordinatesTransfer ojb = new CoordinatesTransfer();
    }

    public CoordinatesTransfer() {
        try {
            ClientVerification();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ClientVerification() throws IOException {
        System.out.println("Client Accepted The Connection !!");
        OutputStream outputStream = waitForTheClient.getOutputStream();
        String msg = "Starting\n";
        outputStream.write(msg.getBytes());

        InputStream inputStream = waitForTheClient.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String receivedMsg = bufferedReader.readLine();
        System.out.println(receivedMsg);

        socket.close();

        if (Objects.equals(receivedMsg, "Sure")) {
            sendingCoordinates();
            System.out.println("Here");
        }
    }

    private void sendingCoordinates() {
        Thread senderThread = new Thread(() -> {
            try {
                DatagramSocket senderSocket = new DatagramSocket();
                while (!breakOrNot) {
                    Point cursorInfo = MouseInfo.getPointerInfo().getLocation();

                    int x = cursorInfo.x;
                    int y = cursorInfo.y;
                    String msg = x + " " + y;
                    byte[] sendData = msg.getBytes();

                    DatagramPacket packet = new DatagramPacket(sendData, sendData.length, serverAddress, serverPortSend);
                    senderSocket.send(packet);

                    if (breakOrNot){
                        break;
                    }

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Thread receiverThread = new Thread(() -> {
            try {
                DatagramSocket receiverSocket = new DatagramSocket(serverPortReceive);

                byte[] receivedData = new byte[1024];

                while (true) {
                    DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
                    receiverSocket.receive(receivePacket);
                    String receivedMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
//                    System.out.println(receivedMsg + " Here ");
                    if (receivedMsg.equals("Stop")) {
                        breakOrNot = true;
//                        System.out.println("Got the msg");
                        break;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        senderThread.start();
        receiverThread.start();


    }
}

//try {
//
//
//        datagramSocket.receive(receivePacket);
//        String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
//
//
//        if ("stop".equalsIgnoreCase(receivedMessage)) {
//        System.out.println("Server stopped sending messages.");
//        break;
//        }
//        } catch (IOException e) {
//        throw new RuntimeException(e);
//        }



//package ConcurrentThreadsOne;
//
//import java.awt.*;
//import java.io.*;
//import java.net.*;
//import java.util.Objects;
//
//public class CoordinatesTransfer {
//    ServerSocket socket;
//    InetAddress serverAddress;
//
//    {
//        try {
//            serverAddress = InetAddress.getByName("10.200.233.131");
//        } catch (UnknownHostException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    int serverPort = 12345;
//
//    {
//        try {
//            socket = new ServerSocket(serverPort);
//            waitForTheClient = socket.accept();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    Socket waitForTheClient;
//
//    public static void main(String[] args) {
//        Point mousePosition = MouseInfo.getPointerInfo().getLocation();
//        CoordinatesTransfer ojb = new CoordinatesTransfer();
//    }
//    public CoordinatesTransfer(){
//        try {
//            ClientVerification();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void ClientVerification() throws IOException {
//
//        System.out.println("Client Accepted The Connection !!");
//        OutputStream outputStream = waitForTheClient.getOutputStream();
//        String msg = "Starting\n";
//        outputStream.write(msg.getBytes());
//
//
//
//        InputStream inputStream = waitForTheClient.getInputStream();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String receivedMsg = bufferedReader.readLine();
//        System.out.println(receivedMsg);
//
//        socket.close();
//
//        if (Objects.equals(receivedMsg, "Sure")){
//            sendingCoordinates();
//            System.out.println("Here");
//        }
//
//    }
//
//    private void sendingCoordinates() {
//        DatagramSocket socket = null;
//        try {
//            socket = new DatagramSocket();
//
//        while (true){
//            Point cursorLocation = MouseInfo.getPointerInfo().getLocation();
//            int x = cursorLocation.x;
//            int y = cursorLocation.y;
////            System.out.println(x + " " + y);
//
//            String message = x + " " + y;
//            byte[] sendData = message.getBytes();
//            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
//
//            socket.send(sendPacket);
////            String receivedMsg = getMsg(socket);
////            if (receivedMsg.equals("Stop")){
////                break;
////            }
//            System.out.println("Here");
//            Thread.sleep(8);
//        }
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private String getMsg(DatagramSocket socket) {
//        byte[] receiveData = new byte[1024];
//        String receiveMsg;
//            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//            try {
//                socket.receive(receivePacket);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            receiveMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
//        return receiveMsg;
//    }
//
//
//}
