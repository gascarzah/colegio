package pe.gafahsoft.colegio.modelo;

import java.util.Date;

import pe.gafahsoft.colegio.bean.Comun;

public class Asistencia extends Comun {

	private static final long serialVersionUID = 1804465587513138717L;

	private Integer asisId;

	private Integer empId;

	private Date fecasis;

	public Integer getAsisId() {
		return asisId;
	}

	public void setAsisId(Integer asisId) {
		this.asisId = asisId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Date getFecasis() {
		return fecasis;
	}

	public void setFecasis(Date fecasis) {
		this.fecasis = fecasis;
	}

	

}