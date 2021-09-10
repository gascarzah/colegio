package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Alumno;

@Local
public interface AlumnoBeanDAOLocal {
	public List<Alumno> listar(Alumno parametros);
	public int grabar(Alumno parametros);
	

	

}
