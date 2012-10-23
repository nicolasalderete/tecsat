package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the operador database table.
 * 
 */
@Entity
@Table(name="operador")
public class Operador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=20)
	private String celular;

	@Column(nullable=false, length=20)
	private String dni;

	@Column(nullable=false, length=2)
	private String estado;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion", nullable=false)
	private Date fechaActualizacion;

	@Column(nullable=false, length=20)
	private String mail;

	@Column(nullable=false, length=20)
	private String nombre;

	@Column(nullable=false, length=20)
	private String pass;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="cli_id", nullable=false)
	private Cliente cliente;

    public Operador() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}