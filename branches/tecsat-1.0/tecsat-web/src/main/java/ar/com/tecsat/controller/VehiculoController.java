/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ar.com.tecsat.modelo.Evento;
import ar.com.tecsat.modelo.Transporte;
import ar.com.tecsat.service.local.EventoServiceLocal;
import ar.com.tecsat.service.local.VehiculoServiceLocal;

/**
 * @author Nicolas
 *
 */
@ManagedBean(name="vehiculoController")
@RequestScoped
public class VehiculoController {

	private long vehiculoId;
	
	private Date desde;
	
	private Date hasta;

	private List<Transporte> vehiculos;
	
	private String lat;
	
	private String lon;

	@EJB
	private EventoServiceLocal eventoService;
	
	@EJB
	private VehiculoServiceLocal vehiculoService;
	
	public VehiculoController () {}
	
	@PostConstruct
	public void init() {
		this.setVehiculos(vehiculoService.transporteByCliente(1));
	}
	
	/**
	 * Acciones
	 */

	public String doConsulta () {
		Evento event = eventoService.obtenerPosicion();
		setLat(event.getLatitud());
		setLon(event.getLongitud());
		return null;
	}
	
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

	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public String getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}

}
