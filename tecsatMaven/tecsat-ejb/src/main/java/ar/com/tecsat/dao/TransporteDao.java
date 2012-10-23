package ar.com.tecsat.dao;

import java.util.List;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Transporte;

@Local
public interface TransporteDao {

	/**
	 * @param clidId
	 * @return
	 */
	List<Transporte> findByCliente(int clid_id);
	
	List<Transporte> findByClienteAndDispositivoNotNull(int cli_id);
	
}
