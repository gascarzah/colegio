package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.Menu;

@Local
public interface MenuBeanDAOLocal {

	public List<Menu> listar(Menu parametros);

	public List<Menu> getObtenerMenuPorPadre(Menu parametros);

	public int grabar(Menu parametros);
}
