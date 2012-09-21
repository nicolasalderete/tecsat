/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ar.com.tecsat.dao.EventoDao;
import ar.com.tecsat.modelo.Evento;
import ar.com.tecsat.service.local.EventoServiceLocal;

/**
 * @author Nicolas
 *
 */
@Stateless
public class EventoService implements EventoServiceLocal{
	
	@EJB
	private EventoDao eventoDao;

	/* (non-Javadoc)
	 * @see ar.com.tecsat.service.EventoServiceLocal#obtenerPosicion()
	 */
	@Override
	public Evento obtenerPosicion() {
		return eventoDao.find();
	}
	
	
}
