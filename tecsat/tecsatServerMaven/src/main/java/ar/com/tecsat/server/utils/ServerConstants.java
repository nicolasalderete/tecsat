package ar.com.tecsat.server.utils;

import java.text.SimpleDateFormat;

public class ServerConstants {

	public static final int MAX_BUFFER_SIZE = 8192;
	public final static SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss.SSSZ");
	public static final int TIMEOUT = 30;
	public static final int MAX_LISTENER_THREADS = 5;

}
