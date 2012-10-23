/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.service;

import java.util.Date;
import java.util.List;

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
	public List<Evento> obtenerPosicion(int cli_id, int dis_id, Date fdesde, Date fhastas) {
		return eventoDao.findByFecha(cli_id, dis_id, fdesde, fhastas);
	}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.service.local.EventoServiceLocal#obtenerhistorial(int, int)
	 */
	@Override
	public List<Evento> obtenerHistorial(int cli_id, int dis_id) {
		return eventoDao.findByClienteAndDispositivo(cli_id, dis_id);
	}
	
	
}
