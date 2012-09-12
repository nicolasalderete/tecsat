package ar.com.tecsat.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ar.com.tecsat.modelo.Operador;

/**
 * Session Bean implementation class OperadorDaoBean
 */
@Stateless
public class OperadorDaoBean implements OperadorDao {

	@PersistenceContext(unitName="TECSAT-DB")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public OperadorDaoBean() {
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.OperadorDao#findOperador(ar.com.tecsat.modelo.Operador)
	 */
	@Override
	public Operador findOperador(String usuario, String contrasenia) {
		String sqlQuery = "select * from operador "
				+"where ope_nombre = ? "
				+"and ope_password = ?";
		
		Query query = em.createNativeQuery(sqlQuery, Operador.class);
		query.setParameter(1, usuario);
		query.setParameter(2, contrasenia);
		return (Operador) query.getSingleResult();
	}

}
