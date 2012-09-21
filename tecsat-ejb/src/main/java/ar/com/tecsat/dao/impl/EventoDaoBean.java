/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ar.com.tecsat.dao.EventoDao;
import ar.com.tecsat.modelo.Evento;

/**
 * @author Nicolas
 *
 */
@Stateless
public class EventoDaoBean implements EventoDao {
	
	@PersistenceContext(unitName="TECSAT-DB")
	private EntityManager em;
	
	public EventoDaoBean () {}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.EventoDao#find()
	 */
	@Override
	public Evento find() {
		String sqlquery = "select * from evento";
		Query query = em.createNativeQuery(sqlquery, Evento.class);
		return (Evento) query.getSingleResult();
	}
	
}
