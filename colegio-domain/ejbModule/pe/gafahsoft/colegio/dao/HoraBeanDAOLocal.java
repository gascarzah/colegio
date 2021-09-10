package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Hora;

@Local
public interface HoraBeanDAOLocal {

	int grabar(Hora parametros);

	List<Hora> listar(Hora parametros);

	

}
