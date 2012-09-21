/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.service.local;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Evento;

/**
 * @author Nicolas
 *
 */
@Local
public interface EventoServiceLocal {
	
	public Evento obtenerPosicion();
}
