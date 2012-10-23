package ar.com.tecsat.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ar.com.tecsat.dao.OperadorDao;
import ar.com.tecsat.exception.AdministrativeException;
import ar.com.tecsat.modelo.Operador;
import ar.com.tecsat.service.local.LoginServiceLocal;

/**
 * Session Bean implementation class LoginServiceImpl
 */
@Stateless
public class LoginService implements LoginServiceLocal {
	
	@EJB
	private OperadorDao operadorDao;

	/**
	 * Default constructor.
	 */
	public LoginService() {}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.service.local.LoginServiceLocal#isOperador(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean autenticarOperador(String dni, String pass)
			throws AdministrativeException, Exception {
		Operador ope = operadorDao.findOperador(dni, pass);
		return ope != null;
	}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.service.local.LoginServiceLocal#findByOpe(java.lang.String, java.lang.String)
	 */
	@Override
	public Operador obtenerOperador(String dni) throws AdministrativeException, Exception {
		Operador ope = operadorDao.findByOperador(dni);
		return ope;
	}
	
	
	
	
}
