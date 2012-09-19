package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;


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
	@Column(name="ope_id", unique=true, nullable=false)
	private int opeId;

	@Column(name="ope_nombre", nullable=false, length=20)
	private String opeNombre;

	@Column(name="ope_password", nullable=false, length=20)
	private String opePassword;

	@Column(name="ope_usuario", nullable=false, length=20)
	private String opeUsuario;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="cli_id", nullable=false)
	private Cliente cliente;

    public Operador() {
    }

	public int getOpeId() {
		return this.opeId;
	}

	public void setOpeId(int opeId) {
		this.opeId = opeId;
	}

	public String getOpeNombre() {
		return this.opeNombre;
	}

	public void setOpeNombre(String opeNombre) {
		this.opeNombre = opeNombre;
	}

	public String getOpePassword() {
		return this.opePassword;
	}

	public void setOpePassword(String opePassword) {
		this.opePassword = opePassword;
	}

	public String getOpeUsuario() {
		return this.opeUsuario;
	}

	public void setOpeUsuario(String opeUsuario) {
		this.opeUsuario = opeUsuario;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}