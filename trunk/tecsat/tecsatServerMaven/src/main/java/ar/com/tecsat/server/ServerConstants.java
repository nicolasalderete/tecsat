package ar.com.tecsat.server;

import java.text.SimpleDateFormat;

public class ServerConstants {

	public static final int MAX_BUFFER_SIZE = 8192;
	final static SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss.SSSZ");
	public static final int TIMEOUT = 30;
	public static final int MAX_LISTENER_THREADS = 5;

}
