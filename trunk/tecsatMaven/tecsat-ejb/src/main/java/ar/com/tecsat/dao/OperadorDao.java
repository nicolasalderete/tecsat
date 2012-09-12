package ar.com.tecsat.dao;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Operador;

@Local
public interface OperadorDao {

	public Operador findOperador(String usuario, String contrasenia);
}
