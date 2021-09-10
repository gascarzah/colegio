package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Nota;

@Local
public interface NotaBeanDAOLocal {
	public List<Nota> listar(Nota parametros);

	public int grabar(Nota parametros);
}
