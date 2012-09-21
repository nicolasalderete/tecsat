/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.dao;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Evento;

/**
 * @author Nicolas
 *
 */
@Local
public interface EventoDao {
	
	public Evento find();
}
