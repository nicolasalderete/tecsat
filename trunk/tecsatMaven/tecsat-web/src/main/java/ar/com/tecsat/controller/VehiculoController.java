/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.controller;

import java.io.Serializable;
import java.util.ArrayList;
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
public class VehiculoController extends BaseController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int dispositivoId;
	
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
		this.vehiculos = vehiculoService.transporteByClienteWithDispositivo(1);
	}
	
	/**
	 * Acciones
	 */
	
	public void doConsulta (){
		List<Evento> historial = eventoService.obtenerHistorial(1, 1);
		//Obtener marcas de posicion
		obtenerMarcas(this.map, historial);
		//Obtener lineas de rutas
		obtenerPolilineas(this.map, historial);
	}

	/**
	 * @param map2
	 * @param historial
	 */
	private void obtenerPolilineas(Map map2, List<Evento> historial) {
	}

	/**
	 * @param map2
	 * @param historial
	 */
	private void obtenerMarcas(Map map2, List<Evento> historial) {
		ArrayList<Marker> markers = new ArrayList<Marker>();
		for (Evento evento : historial) {
			Marker mark = new Marker();
			mark.setLatitude(evento.getLatitud());
			mark.setLongitude(evento.getLongitud());
			markers.add(mark);
		}
		this.map.getChildren().addAll(markers);
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

	/**
	 * @return the dispositivoId
	 */
	public int getDispositivoId() {
		return dispositivoId;
	}

	/**
	 * @param dispositivoId the dispositivoId to set
	 */
	public void setDispositivoId(int dispositivoId) {
		this.dispositivoId = dispositivoId;
	}
}
