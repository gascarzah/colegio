package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Asistencia;

@Local
public interface AsistenciaBeanDAOLocal {
	public List<Asistencia> listar(Asistencia parametros);
	public int grabar(Asistencia parametros);
}
