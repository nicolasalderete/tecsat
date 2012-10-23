package ar.com.tecsat.service.remote;

import javax.ejb.Remote;

import ar.com.tecsat.modelo.Operador;

@Remote
public interface LoginServiceRemote {

	public boolean autenticarOperador(String dni, String pass) throws Exception;
	
	public Operador obtenerOperador(String dni) throws Exception;
}