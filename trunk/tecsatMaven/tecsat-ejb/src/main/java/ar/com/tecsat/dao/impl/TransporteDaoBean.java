/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ar.com.tecsat.dao.TransporteDao;
import ar.com.tecsat.modelo.Transporte;

/**
 * @author Nicolas
 *
 */
@Stateless
public class TransporteDaoBean implements TransporteDao {

	@PersistenceContext(unitName="TECSAT-DB")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.TransporteDao#findByCliente(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Transporte> findByCliente(int clidId) {
		String sql = "select * from transporte " +
				"where cli_id = ?";
		Query query = em.createNativeQuery(sql, Transporte.class);
		query.setParameter(1, Integer.valueOf(clidId));
		return query.getResultList(); 
	}
	

}
