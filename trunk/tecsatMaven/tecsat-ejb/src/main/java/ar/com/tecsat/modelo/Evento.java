package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@Table(name="evento")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventoPK id;

	@Column(nullable=false, length=20)
	private String latitud;

	@Column(nullable=false, length=20)
	private String longitud;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="cli_id", nullable=false, insertable=false, updatable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to Dispositivo
    @ManyToOne
	@JoinColumn(name="dis_id", nullable=false, insertable=false, updatable=false)
	private Dispositivo dispositivo;

    public Evento() {
    }

	public EventoPK getId() {
		return this.id;
	}

	public void setId(EventoPK id) {
		this.id = id;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Dispositivo getDispositivo() {
		return this.dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
}