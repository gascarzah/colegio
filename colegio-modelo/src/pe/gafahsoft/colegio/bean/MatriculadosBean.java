package pe.gafahsoft.colegio.bean;

import java.util.Date;

public class MatriculadosBean extends Comun {

	private Integer matriId;
	private String alumno;
	private Integer sexo;
	private Date fecNaci;
	private String anio;
	
	public Integer getMatriId() {
		return matriId;
	}
	public void setMatriId(Integer matriId) {
		this.matriId = matriId;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	
	public Integer getSexo() {
		return sexo;
	}
	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}
	public Date getFecNaci() {
		return fecNaci;
	}
	public void setFecNaci(Date fecNaci) {
		this.fecNaci = fecNaci;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	
	
}
