/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.view;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;

import ar.com.tecsat.service.local.LoginServiceLocal;

/**
 * @author Nicolas
 *
 */

@ManagedBean(name="loginView")
@RequestScoped
public class LoginView implements Serializable{

	/**
	 * 
	 */
	
	@EJB
	private LoginServiceLocal loginService;
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String usuario;
	
	@NotNull
	private String contrasenia;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String isOperador () throws Exception {
		if (loginService.isOperador(this.usuario, this.contrasenia))
			return "success";
		return "failed";
	}
}