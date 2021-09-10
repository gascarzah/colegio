package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.modelo.AsistenciaEmpleado;

public interface AsistenciaEmpleadoDAOLocal {

	public List<AsistenciaEmpleado> listar(AsistenciaEmpleado parametros);

	public int grabar(AsistenciaEmpleado parametros);
}
