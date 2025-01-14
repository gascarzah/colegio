package pe.gafahsoft.colegio.service;

import java.util.List;

import javax.ejb.Remote;

import pe.gafahsoft.colegio.bean.MatriculadosBean;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.modelo.Apoderado;
import pe.gafahsoft.colegio.modelo.Asistencia;
import pe.gafahsoft.colegio.modelo.AsistenciaDiaria;
import pe.gafahsoft.colegio.modelo.AsistenciaEmpleado;
import pe.gafahsoft.colegio.modelo.Cita;
import pe.gafahsoft.colegio.modelo.Colegio;
import pe.gafahsoft.colegio.modelo.Empleado;
import pe.gafahsoft.colegio.modelo.Hora;
import pe.gafahsoft.colegio.modelo.Horario;
import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.modelo.Matricula;
import pe.gafahsoft.colegio.modelo.Menu;
import pe.gafahsoft.colegio.modelo.Nota;
import pe.gafahsoft.colegio.modelo.OpcionesMenu;
import pe.gafahsoft.colegio.modelo.Parte;
import pe.gafahsoft.colegio.modelo.Usuario;

@Remote
public interface GeneralServiceRemote {
	public List<Alumno> listar(Alumno parametros);

	public int grabar(Alumno parametros);

	public List<Apoderado> listar(Apoderado parametros);

	public int grabar(Apoderado parametros);

	public List<Asistencia> listar(Asistencia parametros);

	public int grabar(Asistencia parametros);

	public List<AsistenciaDiaria> listar(AsistenciaDiaria parametros);

	public int grabar(AsistenciaDiaria parametros);

	public List<AsistenciaEmpleado> listar(AsistenciaEmpleado parametros);

	public int grabar(AsistenciaEmpleado parametros);



	public List<Cita> listar(Cita parametros);

	public int grabar(Cita parametros);

	public List<Colegio> listar(Colegio parametros);

	public int grabar(Colegio parametros);

	List<Empleado> listar(Empleado parametros);

	int grabar(Empleado parametros);

	int grabar(Hora parametros);

	List<Hora> listar(Hora parametros);

	public List<Horario> listar(Horario parametros);

	public int grabar(Horario parametros);

	public List<Maestra> buscarOpciones(Maestra parametros);

	public List<Maestra> listar(Maestra parametros);

	public int grabar(Maestra parametros);

	public List<Matricula> listar(Matricula parametros);

	public int grabar(Matricula parametros);

	public List<Menu> listar(Menu parametros);

	public List<Menu> getObtenerMenuPorPadre(Menu parametros);

	public int grabar(Menu parametros);

	public List<Nota> listar(Nota parametros);

	public int grabar(Nota parametros);

	public List<OpcionesMenu> getOpcionesMenus(OpcionesMenu parametros);

	public List<OpcionesMenu> listar(OpcionesMenu parametros);

	public int grabar(OpcionesMenu parametros);

	public List<Parte> listar(Parte parametros);

	public int grabar(Parte parametros);

	public List<Usuario> listar(Usuario parametros);

	public int grabar(Usuario parametros);	

	public List<MatriculadosBean> listarMatriculados(Alumno parametros);
}
