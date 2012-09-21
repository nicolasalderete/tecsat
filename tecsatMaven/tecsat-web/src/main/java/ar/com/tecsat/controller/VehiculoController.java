/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.controller;

import java.io.Serializable;
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

import com.googlecode.gmaps4jsf.component.map.Map;
import com.googlecode.gmaps4jsf.component.marker.Marker;

/**
 * @author Nicolas
 *
 */
@ManagedBean(name="vehiculoController")
@RequestScoped
public class VehiculoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long vehiculoId;
	
	private boolean posActual = true;
	
	private Date desde;
	
	private Date hasta;

	private List<Transporte> vehiculos;
	
	private String lat;
	
	private String lon;
	
	private Map map;
	
	@EJB
	private EventoServiceLocal eventoService;
	
	@EJB
	private VehiculoServiceLocal vehiculoService;
	
	public VehiculoController () {
		
	}
	
	@PostConstruct
	public void init() {
		this.vehiculos = vehiculoService.transporteByCliente(1);
		this.setMap(new Map());
	}
	
	/**
	 * Acciones
	 */
	
	public void doConsulta (){
		Evento event = eventoService.obtenerPosicion();
		Marker mark = new Marker();
		mark.setLatitude(event.getLatitud());
		mark.setLongitude(event.getLongitud());
		this.map.getChildren().add(mark);
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

	/**
	 * @return the posActual
	 */
	public boolean isPosActual() {
		return posActual;
	}

	/**
	 * @param posActual the posActual to set
	 */
	public void setPosActual(boolean posActual) {
		this.posActual = posActual;
	}

	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}
}
