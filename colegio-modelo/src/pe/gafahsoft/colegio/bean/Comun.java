package pe.gafahsoft.colegio.bean;

public class Comun extends Auditoria{
	
	private static final long serialVersionUID = 1678144785000623937L;
	private Integer estado = 1;
	private Integer colegioId;
	private String anio;
	private String grado;
	
	private boolean personalizado;
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getColegioId() {
		return colegioId;
	}

	public void setColegioId(Integer colegioId) {
		this.colegioId = colegioId;
	}

	public boolean isPersonalizado() {
		return personalizado;
	}

	public void setPersonalizado(boolean personalizado) {
		this.personalizado = personalizado;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	
	
	
}
