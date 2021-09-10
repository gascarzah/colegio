package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Horario;

@Local
public interface HorarioBeanDAOLocal {
	public List<Horario> listar(Horario parametros);
	
	public int grabar(Horario parametros);
}
