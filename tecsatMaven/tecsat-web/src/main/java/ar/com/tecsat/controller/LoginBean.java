/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.controller;

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

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private LoginServiceLocal loginService;
	
	@NotNull
	private String usuario;
	
	@NotNull
	private String contrasenia;
	
	public LoginBean () {}
	
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
		if (loginService.isOperador(usuario, contrasenia)) {
			return "success";
		} else {
			return "failed";
		}
	}
}