package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.OpcionesMenu;

@Local
public interface OpcionMenuBeanDAOLocal {
	public List<OpcionesMenu> getOpcionesMenus(OpcionesMenu parametros);

	public List<OpcionesMenu> listar(OpcionesMenu parametros);

	public int grabar(OpcionesMenu parametros);
}
