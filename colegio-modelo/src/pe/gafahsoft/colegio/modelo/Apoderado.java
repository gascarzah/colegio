package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Persona;

public class Apoderado extends Persona {

	private static final long serialVersionUID = -8804768941500146393L;

	private Integer apodId;

	private Integer alumId;

	public Integer getApodId() {
		return apodId;
	}

	public void setApodId(Integer apodId) {
		this.apodId = apodId;
	}

	public Integer getAlumId() {
		return alumId;
	}

	public void setAlumId(Integer alumId) {
		this.alumId = alumId;
	}

	

}