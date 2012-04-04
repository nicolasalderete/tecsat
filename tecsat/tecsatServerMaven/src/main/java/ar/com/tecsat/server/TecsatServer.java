package ar.com.tecsat.server;

import java.util.Date;

import ar.com.tecsat.server.utils.ServerConstants;

/**
 * Description: class TecsatServer
 * @author Nicolas
 * @version 11 de Marzo de 2012
 */

public class TecsatServer{
	
	/**
	 * Description: method main of the app.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//log inicial
	    System.out.println(ServerConstants.DateFormat.format(new Date()) + " Start: ");

	    //Creamos el servidor UDP
	    new ServerUDP(4444);
	    
	    //log final
	}
}
