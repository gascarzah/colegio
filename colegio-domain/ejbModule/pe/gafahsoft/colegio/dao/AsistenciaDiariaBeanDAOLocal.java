package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.modelo.AsistenciaDiaria;

@Local
public interface AsistenciaDiariaBeanDAOLocal {
	public List<AsistenciaDiaria> listar(AsistenciaDiaria parametros);
	
	public int grabar(AsistenciaDiaria parametros);
}
