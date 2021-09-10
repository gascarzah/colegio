package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Apoderado;

@Local
public interface ApoderadoBeanDAOLocal {
	public List<Apoderado> listar(Apoderado parametros);

	public int grabar(Apoderado parametros);
}
