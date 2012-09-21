/**
 * @author Nicolas
 * @version $Revision: $ $Date: $ $Author: $ $State: $
 * 
 */
package ar.com.tecsat.server;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import ar.com.tecsat.server.NettyServer;

@Singleton(name = "NettyEJB")
@Startup
public class NettyEJB {

	@PostConstruct
	void init() {
		try {
			new NettyServer().startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}