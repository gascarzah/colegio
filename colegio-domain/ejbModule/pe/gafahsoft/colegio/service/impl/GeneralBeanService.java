package pe.gafahsoft.colegio.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import pe.gafahsoft.colegio.bean.MatriculadosBean;
import pe.gafahsoft.colegio.dao.AlumnoBeanDAOLocal;
import pe.gafahsoft.colegio.dao.ApoderadoBeanDAOLocal;
import pe.gafahsoft.colegio.dao.AsistenciaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.AsistenciaDiariaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.AsistenciaEmpleadoDAOLocal;
import pe.gafahsoft.colegio.dao.CitaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.ColegioBeanDAOLocal;
import pe.gafahsoft.colegio.dao.EmpleadoBeanDAOLocal;
import pe.gafahsoft.colegio.dao.HoraBeanDAOLocal;
import pe.gafahsoft.colegio.dao.HorarioBeanDAOLocal;
import pe.gafahsoft.colegio.dao.MaestraBeanDAOLocal;
import pe.gafahsoft.colegio.dao.MatriculaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.MenuBeanDAOLocal;
import pe.gafahsoft.colegio.dao.NotaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.OpcionMenuBeanDAOLocal;
import pe.gafahsoft.colegio.dao.ParteBeanDAOLocal;
import pe.gafahsoft.colegio.dao.UsuarioBeanDAOLocal;
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
import pe.gafahsoft.colegio.service.GeneralServiceRemote;

/**
 * Session Bean implementation class AlumnoBeanService
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

public class GeneralBeanService implements GeneralServiceRemote {

	@EJB
	AlumnoBeanDAOLocal alumnoBeanDAOLocal;

	@EJB
	ApoderadoBeanDAOLocal apoderadoBeanDAOLocal;

	@EJB
	AsistenciaBeanDAOLocal asistenciaBeanDAOLocal;

	@EJB
	AsistenciaDiariaBeanDAOLocal asistenciaDiariaBeanDAOLocal;

	@EJB
	AsistenciaEmpleadoDAOLocal asistenciaEmpleadoDAOLocal;



	@EJB
	CitaBeanDAOLocal citaBeanDAOLocal;

	@EJB
	ColegioBeanDAOLocal colegioBeanDAOLocal;

	@EJB
	EmpleadoBeanDAOLocal empleadoBeanDAOLocal;

	@EJB
	HoraBeanDAOLocal horaBeanDAOLocal;

	@EJB
	HorarioBeanDAOLocal horarioBeanDAOLocal;

	@EJB
	MaestraBeanDAOLocal maestraBeanDAOLocal;

	@EJB
	MatriculaBeanDAOLocal matriculaBeanDAOLocal;

	@EJB
	MenuBeanDAOLocal menuBeanDAOLocal;

	@EJB
	NotaBeanDAOLocal notaBeanDAOLocal;

	@EJB
	OpcionMenuBeanDAOLocal opcionMenuBeanDAOLocal;

	@EJB
	ParteBeanDAOLocal parteBeanDAOLocal;

	@EJB
	UsuarioBeanDAOLocal usuarioBeanDAOLocal;

	/**
	 * Default constructor.
	 */
	public GeneralBeanService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Alumno> listar(Alumno parametros) {

		return alumnoBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Alumno parametros) {

		return alumnoBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Apoderado> listar(Apoderado parametros) {

		return apoderadoBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Apoderado parametros) {

		return apoderadoBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Asistencia> listar(Asistencia parametros) {

		return asistenciaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Asistencia parametros) {

		return asistenciaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<AsistenciaDiaria> listar(AsistenciaDiaria parametros) {

		return asistenciaDiariaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(AsistenciaDiaria parametros) {

		return asistenciaDiariaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<AsistenciaEmpleado> listar(AsistenciaEmpleado parametros) {

		return asistenciaEmpleadoDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(AsistenciaEmpleado parametros) {

		return asistenciaEmpleadoDAOLocal.grabar(parametros);
	}


	@Override
	public List<Cita> listar(Cita parametros) {

		return citaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Cita parametros) {

		return citaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Colegio> listar(Colegio parametros) {

		return colegioBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Colegio parametros) {

		return colegioBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Empleado> listar(Empleado parametros) {

		return empleadoBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Empleado parametros) {

		return empleadoBeanDAOLocal.grabar(parametros);
	}

	@Override
	public int grabar(Hora parametros) {

		return horaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Hora> listar(Hora parametros) {

		return horaBeanDAOLocal.listar(parametros);
	}

	@Override
	public List<Horario> listar(Horario parametros) {

		return horarioBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Horario parametros) {

		return horarioBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Maestra> buscarOpciones(Maestra parametros) {

		return maestraBeanDAOLocal.buscarOpciones(parametros);
	}

	@Override
	public List<Maestra> listar(Maestra parametros) {

		return maestraBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Maestra parametros) {

		return maestraBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Matricula> listar(Matricula parametros) {

		return matriculaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Matricula parametros) {

		return matriculaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Menu> listar(Menu parametros) {

		return menuBeanDAOLocal.listar(parametros);
	}

	@Override
	public List<Menu> getObtenerMenuPorPadre(Menu parametros) {

		return menuBeanDAOLocal.getObtenerMenuPorPadre(parametros);
	}

	@Override
	public int grabar(Menu parametros) {

		return menuBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Nota> listar(Nota parametros) {

		return notaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Nota parametros) {

		return notaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<OpcionesMenu> getOpcionesMenus(OpcionesMenu parametros) {

		return opcionMenuBeanDAOLocal.getOpcionesMenus(parametros);
	}

	@Override
	public List<OpcionesMenu> listar(OpcionesMenu parametros) {

		return opcionMenuBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(OpcionesMenu parametros) {

		return opcionMenuBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Parte> listar(Parte parametros) {

		return parteBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Parte parametros) {

		return parteBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Usuario> listar(Usuario parametros) {

		return usuarioBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Usuario parametros) {

		return usuarioBeanDAOLocal.grabar(parametros);
	}
	
	@Override
	public List<MatriculadosBean> listarMatriculados(Alumno parametros) {

		return matriculaBeanDAOLocal.listarMatriculados(parametros);
	}

}
