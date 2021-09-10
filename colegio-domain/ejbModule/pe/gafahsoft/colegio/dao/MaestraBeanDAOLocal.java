package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Maestra;
@Local
public interface MaestraBeanDAOLocal {

	public List<Maestra> buscarOpciones(Maestra parametros);
	public List<Maestra> listar(Maestra parametros);
	
	public int grabar(Maestra parametros);
}
