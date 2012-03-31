package ar.com.tecsat.server;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class Listener implements Runnable {

    private final DatagramSocket socket;

    public Listener(DatagramSocket serverSocket) {
        socket = serverSocket;
    }

    private String readLn(DatagramPacket packet) throws IOException {
        socket.receive(packet);
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(packet.getData())), ServerConstants.MAX_BUFFER_SIZE).readLine();
    }

    private void writeLn(DatagramPacket packet, String string) throws IOException {
        packet.setData(string.concat("\r\n").getBytes());
        socket.send(packet);
    }

    public void run() {
        DatagramPacket packet = new DatagramPacket(new byte[ServerConstants.MAX_BUFFER_SIZE], ServerConstants.MAX_BUFFER_SIZE);
        String s;
        while (true) {
            try {
                packet = new DatagramPacket(new byte[ServerConstants.MAX_BUFFER_SIZE], ServerConstants.MAX_BUFFER_SIZE);
                s = readLn(packet);
                System.out.println(ServerConstants.DateFormat.format(new Date()) + " Received: " + s);
                Thread.sleep(ServerConstants.TIMEOUT * 1000);
                writeLn(packet, s);
                System.out.println(ServerConstants.DateFormat.format(new Date()) + " Sent: " + s);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
