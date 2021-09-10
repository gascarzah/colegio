package pe.gafahsoft.colegio.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.service.GeneralServiceRemote;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.ServiceLocator;
import pe.gafahsoft.colegio.util.Utiles;


public abstract class GeneralBean<T> extends Utiles implements Serializable {

	private boolean disableAgregar;
	private boolean disableModificar;
	private boolean disableEstado;

	private List<Maestra> estados;
	private List<Maestra> niveles;
	private List<SelectItem> grados  = new ArrayList<>();
	
	private static final long serialVersionUID = -5790234500145698056L;

	private GeneralServiceRemote generaServiceRemote;

	
	
	
	public GeneralBean() {

		setEstados(buscarMaestra(Constantes.COD_TABLA_ESTADO));
		setNiveles(buscarMaestra(Constantes.COD_TABLA_NIVELES));
	}

	public List<Maestra> buscarMaestra(int idTabla){
		Maestra p1 = new Maestra();
		p1.setMaesId(idTabla);
		p1.setOpcion(Constantes.BUSCAR_POR_PADRE);
//		p1.setEstado(Constantes.ACTIVO);
		return getGeneraServiceRemote().listar(p1);
		
	}
	
	public void evaluarResultado(Integer i){
		if (i == 1) {
			buscarMatricula();
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Satisfactorio", ""));
		} else {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Problemas al grabar", ""));
		}
	}
	
	protected GeneralServiceRemote getGeneraServiceRemote() {
		generaServiceRemote = ServiceLocator.doLookup();
		return generaServiceRemote;
	}

	public boolean isDisableAgregar() {
		return disableAgregar;
	}

	public void setDisableAgregar(boolean disableAgregar) {
		this.disableAgregar = disableAgregar;
	}

	public boolean isDisableModificar() {
		return disableModificar;
	}

	public void setDisableModificar(boolean disableModificar) {
		this.disableModificar = disableModificar;
	}

	public boolean isDisableEstado() {
		return disableEstado;
	}

	public void setDisableEstado(boolean disableEstado) {
		this.disableEstado = disableEstado;
	}

	public abstract void agregar();

	public abstract void modificar(T parametro);

	public abstract void buscarMatricula();

	public abstract void grabar();

	public abstract void actualizar();
	
	public List<Maestra> getEstados() {
		return estados;
	}

	public void setEstados(List<Maestra> estados) {
		this.estados = estados;
	}

	public List<Maestra> getNiveles() {
		return niveles;
	}

	public void setNiveles(List<Maestra> niveles) {
		this.niveles = niveles;
	}

	public void setGeneraServiceRemote(GeneralServiceRemote generaServiceRemote) {
		this.generaServiceRemote = generaServiceRemote;
	}

	public List<SelectItem> getGrados() {
		return grados;
	}

	public void setGrados(List<SelectItem> grados) {
		this.grados = grados;
	}

	public SelectItem getSelectItem(){
		return new SelectItem();
	}
	

}
