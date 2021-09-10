package pe.gafahsoft.colegio.dao;

import java.util.List;

import javax.ejb.Local;

import pe.gafahsoft.colegio.bean.MatriculadosBean;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.modelo.Matricula;

@Local
public interface MatriculaBeanDAOLocal {
	public List<Matricula> listar(Matricula parametros);

	public int grabar(Matricula parametros);

	public List<MatriculadosBean> listarMatriculados(Alumno parametros);
}
