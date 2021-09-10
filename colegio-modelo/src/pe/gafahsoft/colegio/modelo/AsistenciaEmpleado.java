package pe.gafahsoft.colegio.modelo;

import java.util.Date;

import pe.gafahsoft.colegio.bean.Comun;

public class AsistenciaEmpleado extends Comun {

	private static final long serialVersionUID = -3021027306212103348L;

	private Integer asisEmpId;

	private Integer empId;

	private Date dia;

	private String hora;

	public Integer getAsisEmpId() {
		return asisEmpId;
	}

	public void setAsisEmpId(Integer asisEmpId) {
		this.asisEmpId = asisEmpId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	

}