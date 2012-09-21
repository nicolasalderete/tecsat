/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.controller;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author Nicolas
 * Superclase comun a todos los controladores con funciones de utilidad (mensajes de error, acceso a parametros, etc)
 *
 */
public abstract class BaseController {

    /**
     * Añade un mensaje de error a la jeraquia de componetes de la página JSF
     * @param mensaje
     */
    protected void anadirMensajeError(String mensaje){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, null));
    }
    
    
    /**
     * Recupera el valor asociado a un parametro de la página JSF
     * @param parametro
     * @return
     */
    protected String recuperarParametro(String parametro){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> map = context.getExternalContext().getRequestParameterMap();
        return map.get(parametro);
    }

    /**
     * Recupera el id de tipo long asociado a un parametro de la página JSF
     * @param parametro
     * @return
     */
    protected long recuperarIdParametro(String parametro){
        return Long.parseLong(recuperarParametro(parametro));
    }


}
