package ar.com.tecsat.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ar.com.tecsat.dao.OperadorDao;
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
	public boolean isOperador(String usuario, String contrasenia)
			throws Exception {
		Operador ope = operadorDao.findOperador(usuario, contrasenia);
		return ope != null;
	}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.service.local.LoginServiceLocal#findByOpe(java.lang.String, java.lang.String)
	 */
	@Override
	public Operador findByOpe(String usuario, String contrasenia)
			throws Exception {
		return operadorDao.findOperador(usuario, contrasenia);
	}
	
	
	
	
}
