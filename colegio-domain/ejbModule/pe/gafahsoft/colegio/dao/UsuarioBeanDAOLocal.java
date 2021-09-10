package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Usuario;

@Local
public interface UsuarioBeanDAOLocal {
	public List<Usuario> listar(Usuario parametros);

	public int grabar(Usuario parametros);
}
