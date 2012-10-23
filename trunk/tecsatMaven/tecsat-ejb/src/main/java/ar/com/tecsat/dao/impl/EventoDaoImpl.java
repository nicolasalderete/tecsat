/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.dao.impl;

import java.util.Date;
import java.util.List;

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
public class EventoDaoImpl implements EventoDao {
	
	@PersistenceContext(unitName="TECSAT-DB")
	private EntityManager em;
	
	public EventoDaoImpl () {}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.EventoDao#find()
	 */
	@Override
	public Evento find() {
		String sqlquery = "select * from evento";
		Query query = em.createNativeQuery(sqlquery, Evento.class);
		return (Evento) query.getSingleResult();
	}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.EventoDao#findByClienteAndDispositivo()
	 */
	@Override
	public List<Evento> findByClienteAndDispositivo(int cli_id, int dis_id) {
		
		String sqlString = "select * from evento "+
				"where cli_id = ? " +
				"and dis_id = ? " +
				"order by time_stamp";
		Query query = em.createNativeQuery(sqlString, Evento.class);
		query.setParameter(1, cli_id);
		query.setParameter(2, dis_id);
		@SuppressWarnings("unchecked")
		List<Evento> eventos = query.getResultList();
		return eventos;
	}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.dao.EventoDao#findByFecha(long, long, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Evento> findByFecha(int  cli_id, int  dis_id, Date fdesde,
			Date fhastas) {
		// TODO Auto-generated method stub
		return null;
	}
}
