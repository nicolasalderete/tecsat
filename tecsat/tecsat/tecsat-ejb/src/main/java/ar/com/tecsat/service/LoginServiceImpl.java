package ar.com.tecsat.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ar.com.tecsat.modelo.Operador;
import ar.com.tecsat.service.local.LoginServiceLocal;

/**
 * Session Bean implementation class LoginServiceImpl
 */
@Stateless
public class LoginServiceImpl implements LoginServiceLocal {

	@PersistenceContext (unitName = "TECSAT-DB")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public boolean isOperador(Operador operador) throws Exception {
		Operador ope = em.find(Operador.class, 1);
		return ope != null;
	}
}
