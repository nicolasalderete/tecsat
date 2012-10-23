package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=20)
	private String direccion;

	@Column(nullable=false, length=2)
	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion", nullable=false)
	private Date fechaActualizacion;

	@Column(nullable=false, length=20)
	private String latitud;

	@Column(nullable=false, length=20)
	private String longitud;

	@Column(nullable=false, length=20)
	private String mail;

	@Column(name="razon_social", nullable=false, length=20)
	private String razonSocial;

	@Column(nullable=false, length=20)
	private String telefono;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="cliente")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Operador
	@OneToMany(mappedBy="cliente")
	private List<Operador> operadors;

	//bi-directional many-to-one association to Transporte
	@OneToMany(mappedBy="cliente")
	private List<Transporte> transportes;

    public Cliente() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public List<Operador> getOperadors() {
		return this.operadors;
	}

	public void setOperadors(List<Operador> operadors) {
		this.operadors = operadors;
	}
	
	public List<Transporte> getTransportes() {
		return this.transportes;
	}

	public void setTransportes(List<Transporte> transportes) {
		this.transportes = transportes;
	}
	
}