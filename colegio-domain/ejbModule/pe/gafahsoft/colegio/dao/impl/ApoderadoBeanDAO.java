package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import pe.gafahsoft.colegio.dao.ApoderadoBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Apoderado;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

public class ApoderadoBeanDAO extends MantenimientoGeneralDAO<Apoderado> implements ApoderadoBeanDAOLocal{

	@Override
	public List<Apoderado> listar(Apoderado parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( " SELECT apod_id  as apodid   , "+
					"			 	 alum_id  as alumid   , "+
					"			 	 dni      as dni      , "+
					"			 	 nombres	as nombres	, "+
					"			 	 ape_pate	as apepate	, "+
					"			 	 ape_mate	as apemate	, "+
					"			 	 sexo			as sexo			, "+
					"			 	 telefono	as telefono	, "+
					"			 	 tipo_pers	as tipopers	, "+
					"			 	 email		as email		, "+
					"			 	 fec_naci	as fecnaci	, "+
					"			 	 celular	as celular	, "+
					"			 	 direccion		as direccion		, "+
					"			 	 estado_civil		as estadocivil		, "+
					"			 	 usu_reg	as usureg		, "+
					"			 	 fec_reg	as fecreg		, "+
					"			 	 usu_mod	as usumod		, "+
					"			 	 fec_mod	as fecmod		, "+
					"			 	 maq_reg	as maqreg		, "+
					"			 	 maq_mod  as maqmod     "+
					"	  from apoderado             ");
			break;

		
		default:
			break;
		}
		
		List<Apoderado> lista = buscar(sql.toString(), parametros);
		return lista;
	}

	@Override
	public int grabar(Apoderado parametros) {
		StringBuilder sql = new StringBuilder();
		int i = 0;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into apoderado (alum_id, dni, nombres, ape_pate, ape_mate, sexo, telefono, tipo_apod, email, fec_naci, celular, direcc, estado_civil, usu_reg, fec_reg, maq_reg) values "+Utiles.inParametros(16));	
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update apoderado set alum_id =?, dni=?, nombres=?, ape_pate=?, ape_mate=?, sexo=?, telefono=?, tipo_apod=?, email=?, fec_naci=?, celular=?, direcc=?, estado_civil=?, usu_reg=?, fec_reg=?, maq_reg=? where apod_id = ? ");
			break;
		default:
			break;
		}
		i = crud(sql.toString(), parametros);

		return i;
	}



	@Override
	public void setParametros(PreparedStatement prepaStatement, Apoderado parametros) throws SQLException {
		int i = 1;
		
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setString(i++, parametros.getDni());
			prepaStatement.setString(i++, parametros.getNombres());
			prepaStatement.setString(i++, parametros.getApePate());
			prepaStatement.setString(i++, parametros.getApeMate());
			prepaStatement.setInt(i++, parametros.getSexo());
//			prepaStatement.setString(i++, parametros.getFecNaci());
			prepaStatement.setString(i++, parametros.getDireccion());
			prepaStatement.setString(i++, parametros.getTelefono());
			prepaStatement.setString(i++, parametros.getEmail());
			prepaStatement.setInt(i++, parametros.getEstadoCivil());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getUsuMod());
			break;

		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getApodId());
			break;
		default:
			break;
		}
		
		
	}

	@Override
	public Apoderado getFactory() {
		// TODO Auto-generated method stub
		return new Apoderado();
	}

}
