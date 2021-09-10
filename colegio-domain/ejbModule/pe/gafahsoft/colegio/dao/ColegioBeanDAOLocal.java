package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Colegio;

@Local
public interface ColegioBeanDAOLocal {

	public List<Colegio> listar(Colegio parametros);
	public int grabar(Colegio parametros);
	
}
