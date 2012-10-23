package ar.com.tecsat.webservice;

import java.rmi.Remote;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface Calculator extends Remote
{
   @WebMethod
   int add(Integer x, Integer y);

   @WebMethod 
   int subtract(Integer x, Integer y);
}