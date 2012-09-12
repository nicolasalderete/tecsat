package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;


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
	@Column(name="tra_id", unique=true, nullable=false)
	private int traId;

	@Column(name="tra_descripcion", nullable=false, length=20)
	private String traDescripcion;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="cli_id", nullable=false)
	private Cliente cliente;

    public Transporte() {
    }

	public int getTraId() {
		return this.traId;
	}

	public void setTraId(int traId) {
		this.traId = traId;
	}

	public String getTraDescripcion() {
		return this.traDescripcion;
	}

	public void setTraDescripcion(String traDescripcion) {
		this.traDescripcion = traDescripcion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}