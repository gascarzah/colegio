package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import pe.gafahsoft.colegio.dao.MaestraBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

public class MaestraBeanDAO extends MantenimientoGeneralDAO<Maestra> implements MaestraBeanDAOLocal{

	public List<Maestra> listar(Maestra parametros){
		StringBuilder sql = new StringBuilder();
		sql.append( " select m.maes_id 	      as   maesId     , " +
						   " m.maes_padre_id  as   maesPadreId ,   " +
						   " m.valor          as   valor     ,  " +
						   " m.desc_larga     as   descLarga ,  " +
						   " m.desc_corta     as   descCorta ,  " +
						   " m.estado         as   estado       " +
					" from maestra  m where m.estado = ? " );
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			
			break;
		case Constantes.BUSCAR_POR_PADRE:
			sql.append(" and m.maes_padre_id = ? ");
			
			break;	
		
		default:
			break;
		}
		
		List<Maestra> lista = new ArrayList<>();
		
		
		lista = buscar(sql.toString(), parametros);
		
		return lista;
		
		
	}
	
	public int grabar(Maestra parametros){
		int i=0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( "  insert into maestra (maes_padre_id,  valor, desc, estado, usu_reg, fec_reg, maq_reg) values "+Utiles.inParametros(8));		
			break;
		case Constantes.ACTUALIZAR:
			sql.append( " update maestra set maes_padre_id=?,  valor=?, desc_larga=?, estado=?, usu_mod=?, fec_mod=?, maq_mod=? where maes_id=? ");	
			break;

		default:
			break;
		}
		 
		
		i = crud(sql.toString(),parametros);
		
		
		return i;
	}


	@Override
	public void setParametros(PreparedStatement prepaStatement, Maestra parametros) throws SQLException  {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++,parametros.getMaesPadreId());
			prepaStatement.setString(i++,parametros.getValor());
			prepaStatement.setString(i++,parametros.getDescLarga());
			prepaStatement.setInt(i++,parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			
			break;

		case Constantes.ACTUALIZAR:
			
			break;
		case Constantes.BUSCAR_TODOS:
			prepaStatement.setInt(i++, parametros.getEstado());
			
			break;	
			
		case Constantes.BUSCAR_POR_PADRE:
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setInt(i++, parametros.getMaesId());
			
			break;	
			
		default:
			break;
		}
		
	}

	@Override
	public List<Maestra> buscarOpciones(Maestra parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maestra getFactory() {
		// TODO Auto-generated method stub
		return new Maestra();
	}




	
}
