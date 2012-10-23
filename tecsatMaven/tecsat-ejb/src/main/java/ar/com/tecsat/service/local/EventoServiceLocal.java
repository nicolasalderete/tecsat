/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.service.local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Evento;

/**
 * @author Nicolas
 *
 */
@Local
public interface EventoServiceLocal {
	
	public List<Evento> obtenerPosicion(int cli_id, int dis_id, Date fdesde, Date fhastas);
	
	public List<Evento> obtenerHistorial(int cli_id, int dis_id);
}
