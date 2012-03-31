package ar.com.tecsat.server;

import java.util.Date;


public class TecsatServer{
	
	/**
	 * Tecsat Server
	 * Author: Nicolas Alderete
	 * Date: 11 de Marzo de 2012
	 */
	
	public static void main(String[] args) {
		
	    System.out.println(ServerConstants.DateFormat.format(new Date()) + " Start: ");
	    new ServerUDP(4444);
	}
}
