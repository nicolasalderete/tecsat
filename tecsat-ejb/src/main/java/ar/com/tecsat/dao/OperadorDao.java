package ar.com.tecsat.dao;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Operador;

@Local
public interface OperadorDao {

	/**
	 * 
	 * @param usuario
	 * @param contrasenia
	 * @return
	 */
	public Operador findOperador(String usuario, String contrasenia);

	/**
	 * @param usuario
	 * @return
	 */
	public Operador findOperador(String usuario);
}
