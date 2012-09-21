package ar.com.tecsat.service.local;

import java.util.List;

import javax.ejb.Local;

import ar.com.tecsat.modelo.Transporte;

@Local
public interface VehiculoServiceLocal {

	public List<Transporte> transporteByCliente (int cli);
}
