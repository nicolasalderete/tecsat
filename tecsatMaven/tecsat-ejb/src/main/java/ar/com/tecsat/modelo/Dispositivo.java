package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;


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
	@Column(name="dis_id", unique=true, nullable=false)
	private int disId;

	@Column(name="dis_nombre", nullable=false, length=20)
	private String disNombre;

    public Dispositivo() {
    }

	public int getDisId() {
		return this.disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
	}

	public String getDisNombre() {
		return this.disNombre;
	}

	public void setDisNombre(String disNombre) {
		this.disNombre = disNombre;
	}

}