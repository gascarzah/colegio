package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import pe.gafahsoft.colegio.dao.AsistenciaEmpleadoDAOLocal;
import pe.gafahsoft.colegio.modelo.AsistenciaEmpleado;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

public class AsistenciaEmpleadoDAO extends MantenimientoGeneralDAO<AsistenciaEmpleado> implements AsistenciaEmpleadoDAOLocal{

	@Override
	public List<AsistenciaEmpleado> listar(AsistenciaEmpleado parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select asis_emp_id                 as   asisempid           ,     " +
					"			 emp_id                      as   empid           ,         " +
					"			 dia                         as   dia           ,           " +
					"			 hora                        as   hora           ,          " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 maq_mod                     as   maqmod                    " +
					"			 from asistencia_empleado                                   ") ;	
			break;

		
		default:
			break;
		}
		
		List<AsistenciaEmpleado> lista = buscar(sql.toString(), parametros);
		
		return lista;
	}

	@Override
	public int grabar(AsistenciaEmpleado parametros) {
	int i = 0;
	StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into asistencia_empleado (emp_id, dia, hora, usu_reg, fec_reg, maq_reg ) values "	+Utiles.inParametros(6));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update asistencia_empleado set emp_id=?, dia=?, hora=?,  usu_mod=?, fec_mod=?, maq_mod=?  where asis_emp_id=? ");
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
		
	}


	@Override
	public void setParametros(PreparedStatement prepaStatement, AsistenciaEmpleado parametros) throws SQLException {
		int i = 1;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getEmpId());
//			prepaStatement.setDate(i++, parametros.getDia());
			prepaStatement.setString(i++, parametros.getHora());
			
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getAsisEmpId());
			break;
		default:
			break;
		}
		
		

		
	}

	@Override
	public AsistenciaEmpleado getFactory() {
		// TODO Auto-generated method stub
		return new AsistenciaEmpleado();
	}

}
