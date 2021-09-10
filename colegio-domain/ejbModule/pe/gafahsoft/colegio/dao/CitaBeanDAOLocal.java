package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Cita;

@Local
public interface CitaBeanDAOLocal {
	public List<Cita> listar(Cita parametros);
	
	public int grabar(Cita parametros);
}
