package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Empleado;


@Local
public interface EmpleadoBeanDAOLocal {

	List<Empleado> listar(Empleado parametros);

	int grabar(Empleado parametros);



}
