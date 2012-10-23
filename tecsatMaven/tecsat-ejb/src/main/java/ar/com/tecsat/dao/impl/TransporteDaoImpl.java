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
public class TransporteDaoImpl implements TransporteDao {

	@PersistenceContext(unitName="TECSAT-DB")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.TransporteDao#findByCliente(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Transporte> findByCliente(int cli_Id) {
		String sql = "select * from transporte " +
				"where cli_id = ?";
		Query query = em.createNativeQuery(sql, Transporte.class);
		query.setParameter(1, Integer.valueOf(cli_Id));
		return query.getResultList(); 
	}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.TransporteDao#findByClienteAndDispositivoNotNull(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Transporte> findByClienteAndDispositivoNotNull(int cli_id) {
		String sql = "select * from transporte " +
				"where cli_id = ? " +
				"and dis_id IS NOT NULL";
		Query query = em.createNativeQuery(sql, Transporte.class);
		query.setParameter(1, cli_id);
		return query.getResultList();
	}
	

}
