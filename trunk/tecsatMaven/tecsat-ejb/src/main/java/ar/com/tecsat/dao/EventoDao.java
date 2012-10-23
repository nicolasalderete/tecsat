/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Evento;

/**
 * @author Nicolas
 *
 */
@Local
public interface EventoDao {
	
	public Evento find ();
	
	public List<Evento> findByClienteAndDispositivo (int cli_id, int dis_id);
	
	public List<Evento> findByFecha(int cli_id, int dis_id, Date fdesde, Date fhastas);
	
}
