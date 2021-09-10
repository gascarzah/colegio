package pe.gafahsoft.colegio.web;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pe.gafahsoft.colegio.modelo.Usuario;
import pe.gafahsoft.colegio.util.Utiles;

@ManagedBean
@RequestScoped
public class UsuarioBean extends Utiles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5326288778104974976L;
	private Usuario usuario = new Usuario();
	
	public UsuarioBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void login(){
		System.out.println("aqui");
		
		try {
//		getSession(true).setAttribute("login", "logeado");
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return "index";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
