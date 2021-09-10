package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import pe.gafahsoft.colegio.dao.NotaBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Nota;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

public class NotaBeanDAO extends MantenimientoGeneralDAO<Nota> implements NotaBeanDAOLocal{
	
	
	public List<Nota> listar(Nota parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select nota_id                     as   notaid           ,        " +
			"			 emp_id                      as   empid           ,         " +
			"			 matri_id                    as   matriid           ,       " +
			"			 nota_1                      as   nota1           ,         " +
			"			 nota_2                      as   nota2           ,         " +
			"			 nota_3                      as   nota3           ,         " +
			"			 nota_4                      as   nota4           ,         " +
			"			 prom_final                  as   promfinal           ,     " +
			"			 usu_reg                     as   usureg           ,        " +
			"			 fec_reg                     as   fecreg           ,        " +
			"			 usu_mod                     as   usumod           ,        " +
			"			 fec_mod                     as   fecmod           ,        " +
			"			 maq_reg                     as   maqreg           ,        " +
			"			 maq_mod                     as   maqmod                    " +
			"			 from nota                                                  ") ;	
			break;

		
		default:
			break;
		}
		
		System.out.println("sql >> " + sql);
		List<Nota> lista = buscar(sql.toString(), parametros);

		return lista;
	}
	
	public int grabar(Nota parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into nota (emp_id, matri_id, nota_1, nota_2, nota_3, nota_4, prom_final, usu_reg, fec_reg, maq_reg) values "+Utiles.inParametros(10));		
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update nota set emp_id=?, matri_id=?, nota_1=?, nota_2=?, nota_3=?, nota_4=?, prom_final=?, usu_mod=?, fec_mod,maq_mod where nota_id =? ");	
			break;
		default:
			break;
		}
		


		i = crud(sql.toString(), parametros);

		return i;
	}

	



	@Override
	public void setParametros(PreparedStatement prepaStatement, Nota parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setBigDecimal(i++, parametros.getNota1());
			prepaStatement.setBigDecimal(i++, parametros.getNota2());
			prepaStatement.setBigDecimal(i++, parametros.getNota3());
			prepaStatement.setBigDecimal(i++, parametros.getNota4());
			prepaStatement.setBigDecimal(i++, parametros.getPromFinal());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			
			break;
		case Constantes.ACTUALIZAR:
			prepaStatement.setBigDecimal(i++, parametros.getNota1());
			prepaStatement.setBigDecimal(i++, parametros.getNota2());
			prepaStatement.setBigDecimal(i++, parametros.getNota3());
			prepaStatement.setBigDecimal(i++, parametros.getNota4());
			prepaStatement.setInt(i++, parametros.getNotaId());
//			prepaStatement.setInt(i++, parametros.getMatriId());
			break;
			
		case 4: //parametros de busqueda
			prepaStatement.setInt(i++, parametros.getNotaId());
			
			break;	
			
		default:
			break;
		}
		
	}

	@Override
	public Nota getFactory() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
