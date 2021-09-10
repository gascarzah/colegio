package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Parte;

@Local
public interface ParteBeanDAOLocal {
	public List<Parte> listar(Parte parametros);

	public int grabar(Parte parametros);
}
