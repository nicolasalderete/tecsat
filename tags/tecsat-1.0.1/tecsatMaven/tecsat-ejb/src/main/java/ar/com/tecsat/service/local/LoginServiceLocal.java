package ar.com.tecsat.service.local;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Operador;

@Local
public interface LoginServiceLocal {

	public boolean isOperador(String usuario, String contrasenia) throws Exception;
	
	public Operador findByOpe (String usuario) throws Exception;
}
