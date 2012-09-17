/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Nicolas
 *
 */
@ManagedBean(name="menuController")
@SessionScoped
public class MenuController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String doHome () {
		return "success";
	}
	
	public String doLocalizacion () {
		return "success";
	}
	
	public String doReportes () {
		return "success";
	}
	
	public String doAlertas () {
		return "success";
	}
	
	public String doAdminOperadores () {
		return "success";
	}
	
	public String doAdminVehiculos () {
		return "success";
	}

}
