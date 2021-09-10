package pe.gafahsoft.colegio.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import pe.gafahsoft.colegio.bean.MatriculadosBean;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.modelo.Apoderado;
import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.modelo.Matricula;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

@ManagedBean
@ViewScoped
public class MatriculaBean extends GeneralBean<Alumno> {

	private static final long serialVersionUID = 839410248736708522L;
	private Apoderado padre = new Apoderado();
	private Apoderado madre = new Apoderado();
	private Matricula matricula = new Matricula();
	private List<Alumno> listadoAlumno = new ArrayList<>();
	private List<Matricula> listadoMatricula = new ArrayList<>();
	private List<MatriculadosBean> matriculados = new ArrayList<>();
	private Alumno alumno = new Alumno();
	private Alumno parametro = new Alumno();
	private String manteAlumno = "/matricula/registroMatricula";
	private Maestra nivel = new Maestra();
	private Maestra grado = new Maestra();
	
	public MatriculaBean() {
		buscarMatricula();
		
	}

	public void buscarGrados(){
		List<Maestra> lista = buscarMaestra(getNivel().getMaesId());
		List<SelectItem> items = new ArrayList<>();
		
		if(CollectionUtils.isNotEmpty(lista)){
			for(Maestra maes : lista){
				SelectItem item = getSelectItem();
				item.setValue(maes.getMaesId());
				item.setLabel(StringUtils.trim(maes.getValor()+ " " + StringUtils.defaultString(maes.getDescCorta())));
				items.add(item);
				
			}
			setGrados(items);
		}
	}
	
	@Override
	public void agregar() {
		
		 alumno = new Alumno();
//		 alumno.setEstado(Constantes.ACTIVO);
			try {
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dialogoAgregarAlumno').show();");
				setDisableAgregar(false);
				setDisableModificar(true);
				setDisableEstado(true);
			} catch (Exception e) {
				e.printStackTrace();
				// log.error("Error en irMostrarMantenimientoMaestro(): " + e);
			}

		
		
	}

	@Override
	public void modificar(Alumno parametro) {
		Alumno nAlumno = new Alumno();
		try {
		BeanUtils.copyProperties(nAlumno, parametro);
		setAlumno(nAlumno);
		setDisableAgregar(true);
		setDisableModificar(false);
		setDisableEstado(false);
		
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialogoAgregarAlumno').show();");
			
			List<Alumno> lista = getGeneraServiceRemote().listar(alumno);

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void buscarMatricula() {
		
		
	 	setMatriculados(getGeneraServiceRemote().listarMatriculados(parametro));
		
	}

	public void buscarAsistencia() {

	 	setListadoAlumno(new ArrayList<>());
		
	}
	
	@Override
	public void grabar() {
		int i = 0;
		try {
			List<Alumno> listaExis = consultarExistencia();
			
			if (CollectionUtils.isEmpty(listaExis)) {
				// Grabar alumno
				alumno.setOpcion(Constantes.INSERTAR);
				i = getGeneraServiceRemote().grabar(alumno);

				if (i == 1) {
					i = 0;

					List<Alumno> lista = consultarExistencia();

					if (CollectionUtils.isNotEmpty(lista)) {
						Alumno alumnoRegistrado = lista.get(0);
						matricula.setAlumId(alumnoRegistrado.getAlumId());
//						matricula.setEstado(Constantes.ACTIVO);
						matricula.setAnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
						matricula.setNivel(grado.getMaesId());
						i = getGeneraServiceRemote().grabar(matricula);

					}
				}
				evaluarResultado(i);
				buscarMatricula();
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dialogoAgregarAlumno').hide ();");
			} else {
				FacesContext.getCurrentInstance().addMessage("msgs",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Alumno ya se encuentra registrado", ""));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

	public List<Alumno> consultarExistencia(){
		alumno.setOpcion(Constantes.BUSCAR_POR_DNI);
		List<Alumno> lista = getGeneraServiceRemote().listar(alumno);
		return lista;
	}
	
	

	
	@Override
	public void actualizar() {
		
		
	}



	public String getManteAlumno() {
		return manteAlumno;
	}

	public void setManteAlumno(String manteAlumno) {
		this.manteAlumno = manteAlumno;
	}

	public List<Alumno> getListadoAlumno() {
		return listadoAlumno;
	}

	public void setListadoAlumno(List<Alumno> listadoAlumno) {
		this.listadoAlumno = listadoAlumno;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public List<Matricula> getListadoMatricula() {
		return listadoMatricula;
	}

	public void setListadoMatricula(List<Matricula> listadoMatricula) {
		this.listadoMatricula = listadoMatricula;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Alumno getParametro() {
		return parametro;
	}

	public void setParametro(Alumno parametro) {
		this.parametro = parametro;
	}

	public Apoderado getPadre() {
		return padre;
	}

	public void setPadre(Apoderado padre) {
		this.padre = padre;
	}

	public Apoderado getMadre() {
		return madre;
	}

	public void setMadre(Apoderado madre) {
		this.madre = madre;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Maestra getNivel() {
		return nivel;
	}

	public void setNivel(Maestra nivel) {
		this.nivel = nivel;
	}

	public Maestra getGrado() {
		return grado;
	}

	public void setGrado(Maestra grado) {
		this.grado = grado;
	}

	public List<MatriculadosBean> getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(List<MatriculadosBean> matriculados) {
		this.matriculados = matriculados;
	}


	
}
