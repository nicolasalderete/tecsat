package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dispositivo database table.
 * 
 */
@Entity
@Table(name="dispositivo")
public class Dispositivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=20)
	private String codigo;

	@Column(length=20)
	private String descripcion;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="dispositivo")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Transporte
	@OneToMany(mappedBy="dispositivo")
	private List<Transporte> transportes;

    public Dispositivo() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public List<Transporte> getTransportes() {
		return this.transportes;
	}

	public void setTransportes(List<Transporte> transportes) {
		this.transportes = transportes;
	}
	
}