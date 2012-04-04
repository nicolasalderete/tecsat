package ar.com.tecsat.server.utils;

public class Checksum {
	
	
	public static String calcularCheck (String texto){
		
		char [] mensaje = texto.toCharArray();
		char chkSum = 0;
		for(int i=0; i<mensaje.length;i++){
			if(mensaje[i] == '*'){
				break;
			}
			chkSum = (char) (chkSum ^ mensaje[i]);
		}
		texto = texto + "*" + chkSum + "<";
		System.out.println("El mensaje es texto");
		return texto;
	}	
}
