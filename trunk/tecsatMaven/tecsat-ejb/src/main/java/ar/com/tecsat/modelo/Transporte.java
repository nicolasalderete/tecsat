package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transporte database table.
 * 
 */
@Entity
@Table(name="transporte")
public class Transporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=20)
	private String anio;

	@Column(nullable=false, length=20)
	private String codigo;

	@Column(length=20)
	private String descripcion;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion", nullable=false)
	private Date fechaActualizacion;

	@Column(nullable=false, length=20)
	private String marca;

	@Column(nullable=false, length=20)
	private String modelo;

	@Column(nullable=false, length=20)
	private String patente;

	//bi-directional many-to-one association to Dispositivo
    @ManyToOne
	@JoinColumn(name="dis_id", nullable=false)
	private Dispositivo dispositivo;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="cli_id", nullable=false)
	private Cliente cliente;

    public Transporte() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Dispositivo getDispositivo() {
		return this.dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}