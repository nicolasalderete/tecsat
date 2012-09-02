package ar.com.tecsat.service.local;

import javax.ejb.Local;

@Local
public interface LoginServiceLocal {

	public boolean isOperador(String usuario, String contrasenia) throws Exception;
}
