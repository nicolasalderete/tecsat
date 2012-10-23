/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.service;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import ar.com.tecsat.modelo.Operador;
import ar.com.tecsat.service.remote.LoginServiceRemote;

/**
 * @author Nicolas
 *
 */
@Stateless
@WebService(name = "Login", serviceName = "LoginService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class LoginServiceWeb implements LoginServiceRemote {

	/* (non-Javadoc)
	 * @see ar.com.tecsat.service.remote.LoginServiceRemote#autenticarOperador(java.lang.String, java.lang.String)
	 */
	@WebMethod(operationName = "AutenticarOperador")
	public boolean autenticarOperador(String dni, String pass) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see ar.com.tecsat.service.remote.LoginServiceRemote#obtenerOperador(java.lang.String)
	 */
	@WebMethod(operationName = "ObtenerOperador")
	public Operador obtenerOperador(String dni) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
