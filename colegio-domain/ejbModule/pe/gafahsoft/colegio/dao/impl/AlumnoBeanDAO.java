package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import pe.gafahsoft.colegio.dao.AlumnoBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

/**
 * Session Bean implementation class AlumnoBeanDAO
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

public class AlumnoBeanDAO extends MantenimientoGeneralDAO<Alumno> implements AlumnoBeanDAOLocal {

	@Override
	public List<Alumno> listar(Alumno parametros) {
		StringBuilder sql = new StringBuilder();
		sql.append( 	" SELECT alum_id  as alumId   , "+
				"			 	 dni      as dni      , "+
				"			 	 nombres	as nombres	, "+
				"			 	 ape_pate	as apePate	, "+
				"			 	 ape_mate	as apeMate	, "+
				"			 	 sexo			as sexo			, "+
				"			 	 fec_naci	as fecNaci	, "+
				"			 	 direccion		as direccion		, "+
				"			 	 telefono	as telefono	, "+
				"			 	 email		as email		, "+
				"			 	 estado		as estado		, "+
				"			 	 usu_reg	as usuReg		, "+
//				"			 	 fec_reg	as fecReg		, "+
//				"			 	 usu_mod	as usuMod		, "+
//				"			 	 fec_mod	as fecMod		, "+
				"			 	 maq_reg	as maqReg		 "+
//				"			 	 maq_mod  as maqMod     "+
				"	  from alumno   where estado =?              ");
			
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
         
			break;
		case Constantes.BUSCAR_POR_DNI:
			sql = new StringBuilder();
			sql.append( 	" SELECT alum_id  as alumId   , "+
					"			 	 dni      as dni       "+					
					"	  from alumno   where estado =?              ");
			sql.append(" and dni = ? ");
			
			break;	
		
		}
		
		List<Alumno> lista = buscar(sql.toString(), parametros);
		
		return lista;
		
	}

	@Override
	public int grabar(Alumno parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into alumno (dni, nombres, ape_pate, ape_mate, sexo, fec_naci, direccion, telefono, email, estado, usu_reg, maq_reg ) values "+Utiles.inParametros(12));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update alumno set dni = ? , nombres = ?, ape_pate= ?, ape_mate= ?, sexo= ?, fec_naci= ?, direc= ?, telefono= ?, email= ?, estado= ?, usu_mod= ?, fec_mod= ?, maq_mod = ? where alum_id = ? ");
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}

	

	@Override
	public void setParametros(PreparedStatement prepaStatement, Alumno parametros) throws SQLException {
		int i = 1;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setString(i++, parametros.getDni());
			prepaStatement.setString(i++, parametros.getNombres());
			prepaStatement.setString(i++, parametros.getApePate());
			prepaStatement.setString(i++, parametros.getApeMate());
			prepaStatement.setInt(i++, parametros.getSexo());
			prepaStatement.setDate(i++, parametros.getFecNaci()==null?null:new java.sql.Date(parametros.getFecNaci().getTime()));
//			prepaStatement.setDate(i++, new java.sql.Date(Utiles.convertirFechaDate("21/03/2015").getTime()));
			
			prepaStatement.setString(i++, parametros.getDireccion());
			prepaStatement.setString(i++, parametros.getTelefono());
			prepaStatement.setString(i++, parametros.getEmail());
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getAlumId());
			break;
		
		case Constantes.BUSCAR_TODOS:
			prepaStatement.setInt(i++, parametros.getEstado());
			break;
		
		case Constantes.BUSCAR_POR_DNI:
			prepaStatement.setInt(i++, parametros.getEstado());
			prepaStatement.setString(i++, parametros.getDni());
			break;
		default:
			break;
		}
		

		
	}

	@Override
	public Alumno getFactory() {
		// TODO Auto-generated method stub
		return new Alumno();
	}

 
	
}
