package ar.com.tecsat.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	/* (non-Javadoc)
	 * @see ar.com.tecsat.service.local.LoginServiceLocal#isOperador(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isOperador(String usuario, String contrasenia)
			throws Exception {
		String sqlQuery = "select * from operador "
				+"where ope_nombre = ? "
				+"and ope_password = ?";
		
		Query query = em.createNativeQuery(sqlQuery, Operador.class);
		query.setParameter(1, usuario);
		query.setParameter(2, contrasenia);
		@SuppressWarnings("unchecked")
		List<Operador> operadores = query.getResultList();
		return operadores.size() > 0;
	}
}
