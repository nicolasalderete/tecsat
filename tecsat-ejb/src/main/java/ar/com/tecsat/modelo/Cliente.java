package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;
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
	@Column(name="cli_id", unique=true, nullable=false)
	private int cliId;

	@Column(name="cli_mail", nullable=false, length=20)
	private String cliMail;

	@Column(name="cli_nombre", nullable=false, length=20)
	private String cliNombre;

	//bi-directional many-to-one association to Operador
	@OneToMany(mappedBy="cliente")
	private List<Operador> operadors;

	//bi-directional many-to-one association to Transporte
	@OneToMany(mappedBy="cliente")
	private List<Transporte> transportes;

    public Cliente() {
    }

	public int getCliId() {
		return this.cliId;
	}

	public void setCliId(int cliId) {
		this.cliId = cliId;
	}

	public String getCliMail() {
		return this.cliMail;
	}

	public void setCliMail(String cliMail) {
		this.cliMail = cliMail;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
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