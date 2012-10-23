package ar.com.tecsat.webservice;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface="ar.com.tecsat.webservice.Calculator")
public class CalculatorBean
{
   public int add(Integer x, Integer y)
   {
      return x.intValue() + y.intValue();
   }

   public int subtract(Integer x, Integer y)
   {
      return x.intValue() - y.intValue();
   }
}
