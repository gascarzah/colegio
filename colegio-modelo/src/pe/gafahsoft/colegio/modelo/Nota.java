package pe.gafahsoft.colegio.modelo;

import java.math.BigDecimal;

import pe.gafahsoft.colegio.bean.Auditoria;
import pe.gafahsoft.colegio.bean.Comun;

public class Nota extends Comun {

	private static final long serialVersionUID = 416426867488910397L;

	private Integer notaId;

	private Integer empId;

	private Integer matriId;

	private BigDecimal nota1;

	private BigDecimal nota2;

	private BigDecimal nota3;

	private BigDecimal nota4;

	private BigDecimal promFinal;

	

	public Integer getNotaId() {
		return notaId;
	}

	public void setNotaId(Integer notaId) {
		this.notaId = notaId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getMatriId() {
		return matriId;
	}

	public void setMatriId(Integer matriId) {
		this.matriId = matriId;
	}

	public BigDecimal getNota1() {
		return nota1;
	}

	public void setNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	public BigDecimal getNota2() {
		return nota2;
	}

	public void setNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public BigDecimal getNota3() {
		return nota3;
	}

	public void setNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	public BigDecimal getNota4() {
		return nota4;
	}

	public void setNota4(BigDecimal nota4) {
		this.nota4 = nota4;
	}

	public BigDecimal getPromFinal() {
		return promFinal;
	}

	public void setPromFinal(BigDecimal promFinal) {
		this.promFinal = promFinal;
	}

	

}