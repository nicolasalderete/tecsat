/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.view;

import javax.faces.bean.ManagedBean;

import ar.com.tecsat.modelo.Operador;

@ManagedBean(name = "operadorBean")
/**
 * @author Nicolas
 *
 */
public class OperadorBean {

	private Operador operador;

	public OperadorBean() {
		this.operador = new Operador();
	}

	public void createOperadorBean (Operador operador) {
		
	}

	/**
	 * @return the operador
	 */
	public Operador getOperador() {
		return operador;
	}

	/**
	 * @param operador
	 *            the operador to set
	 */
	public void setOperador(Operador operador) {
		this.operador = operador;
	}

}
