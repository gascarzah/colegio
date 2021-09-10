package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import pe.gafahsoft.colegio.dao.UsuarioBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Usuario;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

public class UsuarioBeanDAO extends MantenimientoGeneralDAO<Usuario> implements UsuarioBeanDAOLocal{
	

	@Override
	public List<Usuario> listar(Usuario parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
				sql.append( "select usu_id                      as   usuid           ,         " +
					"			 emp_id                      as   empid           ,         " +
					"			 login                       as   login           ,         " +
					"			 clave                       as   clave           ,         " +
					"			 perfil                      as   perfil           ,        " +
					"			 estado                      as   estado           ,        " +
					"			 cole_id                     as   coleid           ,        " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 colegio_id                  as   colegioid           ,     " +
					"			 maq_mod                     as   maqmod                    " +
					"			 from usuario                                               " );	
			break;

		
		default:
			break;
		}
		
		System.out.println("sql >> " + sql);
		List<Usuario> lista = buscar(sql.toString(), parametros);

		return lista;
		
	}

	public int grabar(Usuario parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into usuario (emp_id, login, clave, perfil, estado, cole_id, usu_reg, fec_reg, maq_reg, colegio_id) values "+Utiles.inParametros(10));		
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update usuario set  emp_id=?, login=?, clave=?, perfil=?, estado=?, cole_id=?, usu_mod=?, fec_mod=?, maq_mod=?, colegio_id=? where usu_id=? ");	
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}

	

	@Override
	public void setParametros(PreparedStatement prepaStatement, Usuario parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++, parametros.getEmpId());
			prepaStatement.setString(i++, parametros.getLogin());
			prepaStatement.setString(i++, parametros.getClave());
			prepaStatement.setString(i++, parametros.getPerfil());

			break;
		case Constantes.ACTUALIZAR:
			prepaStatement.setInt(i++, parametros.getEmpId());
			prepaStatement.setString(i++, parametros.getLogin());
			prepaStatement.setString(i++, parametros.getClave());
			prepaStatement.setString(i++, parametros.getPerfil());
			prepaStatement.setInt(i++, parametros.getUsuId());
			
			break;
			
		case 4: //parametros de busqueda
			prepaStatement.setInt(i++, parametros.getUsuId());
			
			break;	
			
		default:
			break;
		}
		
	}

	@Override
	public Usuario getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
