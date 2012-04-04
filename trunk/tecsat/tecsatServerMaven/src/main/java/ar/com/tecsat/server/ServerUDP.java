package ar.com.tecsat.server;

import java.io.IOException;
import java.net.DatagramSocket;

import ar.com.tecsat.server.utils.ServerConstants;

/** 
 * Description: class ServerUDP
 * @author Nicolas
 * @version 11 de Marzo de 2012
 */



public class ServerUDP {

	/**field port of the DatagramSocket*/
	private int mPort;
	/**field socket DatagramSocket*/
	private DatagramSocket mSocket;

	/**
	 * Description: constructor ServerUDP()
	 * @param port
	 */
	
	public ServerUDP(int port) {
	    mPort = port;
	    try {
	        mSocket = new DatagramSocket(mPort);
	        mSocket.setReceiveBufferSize(ServerConstants.MAX_BUFFER_SIZE);
	        mSocket.setSendBufferSize(ServerConstants.MAX_BUFFER_SIZE);
	        mSocket.setSoTimeout(0);

	        for (int i = 0; i < ServerConstants.MAX_LISTENER_THREADS; i++) {
	          new Thread(new Listener(mSocket)).start();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
