package ar.com.tecsat.server;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

import ar.com.tecsat.server.utils.ServerConstants;

/**
 * Description: class Listener implements Runnable
 * @author Nicolas
 * @version 11 de Marzo de 2012
 */
public class Listener implements Runnable {

	/**
	 * field DatagramSocket socket
	 */
    private final DatagramSocket socket;

    /**
     * Description: constructor Listener
     * @param serverSocket
     */
    public Listener(DatagramSocket serverSocket) {
        socket = serverSocket;
    }

    /**
     * Description: method readLn
     * @param packet
     * @return String
     * @throws IOException
     */
    private String readLn(DatagramPacket packet) throws IOException {
        socket.receive(packet);
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(packet.getData())), ServerConstants.MAX_BUFFER_SIZE).readLine();
    }

    /**
     * Description: method writeLn
     * @param packet
     * @param string
     * @throws IOException
     */
    private void writeLn(DatagramPacket packet, String string) throws IOException {
        packet.setData(string.concat("\r\n").getBytes());
        socket.send(packet);
    }

    /**
     * Description: method run
     * Override method
     */
    public void run() {
    	//Creo el paquete para recibir los datos
        DatagramPacket packet = new DatagramPacket(new byte[ServerConstants.MAX_BUFFER_SIZE], ServerConstants.MAX_BUFFER_SIZE);
        String in, out="mensaje retorno";
        while (true) {
            try {
            	//Recibe el paquete
                packet = new DatagramPacket(new byte[ServerConstants.MAX_BUFFER_SIZE], ServerConstants.MAX_BUFFER_SIZE);
                in = readLn(packet);
                
                //log
                System.out.println(ServerConstants.DateFormat.format(new Date()) + " Received: " + in);
                
                //Thread.sleep(ServerConstants.TIMEOUT * 1000);
                processMessage(in);
                
                //Envia la respuesta al Virloc
                writeLn(packet, out);
                
                //log
                System.out.println(ServerConstants.DateFormat.format(new Date()) + " Sent: " + out);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	private void processMessage(String in) {
		// TODO Auto-generated method stub
		
	}
}
