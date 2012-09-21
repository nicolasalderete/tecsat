/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ar.com.tecsat.modelo.Transporte;

/**
 * @author Nicolas
 *
 */
@ManagedBean(name="reportesController")
@SessionScoped
public class ReportesController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Transporte> vehiculos;
	
	private Long vehiculoId;
	
	private Date desde;
	
	private Date hasta;

	public List<Transporte> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Transporte> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Long getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(Long vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	
	
}
