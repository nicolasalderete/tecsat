/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.controller;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Nicolas
 *
 */
@ManagedBean(name="vehiculoBean")
@RequestScoped
public class VehiculoBean {

	private long vehiculoId;
	
	private Date desde;
	
	private Date hasta;
	
	public VehiculoBean() {}

	/**
	 * @return the desde
	 */
	public Date getDesde() {
		return desde;
	}

	/**
	 * @param desde the desde to set
	 */
	public void setDesde(Date desde) {
		this.desde = desde;
	}

	/**
	 * @return the hasta
	 */
	public Date getHasta() {
		return hasta;
	}

	/**
	 * @param hasta the hasta to set
	 */
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	/**
	 * @return the vehiculoId
	 */
	public long getVehiculoId() {
		return vehiculoId;
	}

	/**
	 * @param vehiculoId the vehiculoId to set
	 */
	public void setVehiculoId(long vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

}
