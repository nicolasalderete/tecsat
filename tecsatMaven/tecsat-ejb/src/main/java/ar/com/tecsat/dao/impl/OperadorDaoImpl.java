package ar.com.tecsat.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ar.com.tecsat.dao.OperadorDao;
import ar.com.tecsat.modelo.Operador;

/**
 * Session Bean implementation class OperadorDaoBean
 */
@Stateless
public class OperadorDaoImpl implements OperadorDao {

	@PersistenceContext(unitName="TECSAT-DB")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public OperadorDaoImpl() {
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.OperadorDao#findOperador(ar.com.tecsat.modelo.Operador)
	 */
	@Override
	public Operador findOperador(String dni, String pass) {
		String sqlQuery = "select * from operador "
				+"where dni = ? "
				+"and pass = ?";
		Query query = em.createNativeQuery(sqlQuery, Operador.class);
		query.setParameter(1, dni);
		query.setParameter(2, pass);
		return (Operador) query.getSingleResult();
	}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.OperadorDao#findOperador(java.lang.String)
	 */
	@Override
	public Operador findByOperador(String dni) {
		String sqlQuery = "select * from operador "
				+ "where dni = ?";
		Query query = em.createNativeQuery(sqlQuery, Operador.class);
		query.setParameter(1, dni);
		return (Operador) query.getSingleResult();
	}

}
