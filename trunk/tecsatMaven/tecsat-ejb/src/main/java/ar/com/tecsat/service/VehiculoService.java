package ar.com.tecsat.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ar.com.tecsat.dao.TransporteDao;
import ar.com.tecsat.modelo.Transporte;
import ar.com.tecsat.service.local.VehiculoServiceLocal;

/**
 * Session Bean implementation class VehiculoServiceImpl
 */
@Stateless
public class VehiculoService implements VehiculoServiceLocal {

	@EJB
	private TransporteDao transporteDao;
	
    /**
     * Default constructor. 
     */
    public VehiculoService() {}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.service.local.VehiculoServiceLocal#transporteByCliente(ar.com.tecsat.modelo.Cliente)
	 */
	@Override
	public List<Transporte> transporteByClienteWithDispositivo(int cli) {
		return transporteDao.findByClienteAndDispositivoNotNull(cli);
	}
    
    
}
