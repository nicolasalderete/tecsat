/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ar.com.tecsat.modelo.Cliente;
import ar.com.tecsat.modelo.Operador;
import ar.com.tecsat.service.local.LoginServiceLocal;

/**
 * @author Nicolas
 *
 */
@ManagedBean(name="loginController")
@SessionScoped
public class LoginController extends BaseController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1283869214860680245L;
	
	private String dni = "";
	
	private String pass = "";

	@EJB
	private LoginServiceLocal loginService;
	/**
	 * 
	 */
	public LoginController() {
	}
	
	/**
	 * Acciones del controller
	 */
	
	/**
	 * Accion de login del usuario
	 * @return
	 */
	public String doLogin () {
		try {
			if (loginService.autenticarOperador(this.dni, this.pass)) {
				Operador ope = loginService.obtenerOperador(this.dni);
				ope.setPass("");
				this.pass = "";
				Cliente cli = ope.getCliente();
				this.putParameterSession("cliente", cli);
				this.putParameterSession("operador", ope);
				this.dni = "";
				return "success";
			}
		} catch (Exception e) {
			anadirMensajeError("Error en el servicio de login");
		}
		return "failed";
	}
	
	public String doLogOut () {
		this.pass = "";
		this.dni = "";
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "success";
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

}
