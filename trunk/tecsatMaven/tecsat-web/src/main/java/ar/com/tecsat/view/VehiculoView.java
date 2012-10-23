/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ar.com.tecsat.modelo.Transporte;
import ar.com.tecsat.service.local.VehiculoServiceLocal;

/**
 * @author Nicolas
 *
 */
@ManagedBean(name="vehiculoView")
@RequestScoped
public class VehiculoView {

	private List<Transporte> vehiculos;
	
	@EJB
	private VehiculoServiceLocal vehiculoService;

	public VehiculoView() {
	}
	
	@PostConstruct
	public void init() {
		this.vehiculos = vehiculoService.transporteByClienteWithDispositivo(1);
	}
	

	/**
	 * @return the vehiculos
	 */
	public List<Transporte> getVehiculos() {
		return vehiculos;
	}

	/**
	 * @param vehiculos the vehiculos to set
	 */
	public void setVehiculos(List<Transporte> vehiculos) {
		this.vehiculos = vehiculos;
	}
}
