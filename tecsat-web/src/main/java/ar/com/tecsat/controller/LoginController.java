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

	private Operador operadorActual;
	
	private Cliente clienteActual;
	

	private String usuario = "";
	
	private String contrasenia = "";

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
			if (loginService.isOperador(usuario, contrasenia)) {
				operadorActual = loginService.findByOpe(usuario);
				clienteActual = operadorActual.getCliente();
				contrasenia = "";
				usuario = "";
				return "success";
			}
		} catch (Exception e) {
			anadirMensajeError("Error en el servicio de login");
		}
		return "failed";
	}
	
	public String doLogOut () {
		operadorActual = null;
		clienteActual = null;
		contrasenia = "";
		usuario = "";
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "success";
	}
	
	
	/**
	 * Getters and Setters
	 */
	
	public Operador getOperadorActual() {
		return operadorActual;
	}
	
	public void setOperadorActual(Operador operadorActual) {
		this.operadorActual = operadorActual;
	}
	
	public Cliente getClienteActual() {
		return clienteActual;
	}
	
	public void setClienteActual(Cliente clienteActual) {
		this.clienteActual = clienteActual;
	}
	
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
}
