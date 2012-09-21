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

}