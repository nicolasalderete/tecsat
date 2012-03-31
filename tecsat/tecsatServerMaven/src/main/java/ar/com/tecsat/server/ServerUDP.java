package ar.com.tecsat.server;

import java.io.IOException;
import java.net.DatagramSocket;

public class ServerUDP {


	private int mPort;
	private DatagramSocket mSocket;

	// You can remove this for a working version
	//private ExecutorService mPool;

	public ServerUDP(int port) {
	    mPort = port;
	    try {
	        mSocket = new DatagramSocket(mPort);
	        mSocket.setReceiveBufferSize(ServerConstants.MAX_BUFFER_SIZE);
	        mSocket.setSendBufferSize(ServerConstants.MAX_BUFFER_SIZE);
	        mSocket.setSoTimeout(0);

	        // You can uncomment this for a working version
	        for (int i = 0; i < ServerConstants.MAX_LISTENER_THREADS; i++) {
	          new Thread(new Listener(mSocket)).start();
	        }
	        // You can remove this for a working version
	        //mPool = Executors.newFixedThreadPool(MAX_LISTENER_THREADS);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
