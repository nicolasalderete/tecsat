package ar.com.tecsat.service.local;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Operador;

@Local
public interface LoginServiceLocal {

	public boolean autenticarOperador(String dni, String pass) throws Exception;
	
	public Operador obtenerOperador(String dni) throws Exception;
}
