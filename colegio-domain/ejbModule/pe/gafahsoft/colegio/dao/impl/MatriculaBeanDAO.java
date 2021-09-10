package pe.gafahsoft.colegio.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.apache.commons.lang3.StringUtils;

import pe.gafahsoft.colegio.bean.MatriculadosBean;
import pe.gafahsoft.colegio.dao.MatriculaBeanDAOLocal;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.modelo.Matricula;
import pe.gafahsoft.colegio.patron.MantenimientoGeneralDAO;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.Utiles;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

public class MatriculaBeanDAO extends MantenimientoGeneralDAO<Matricula> implements MatriculaBeanDAOLocal{

	@Override
	public List<Matricula> listar(Matricula parametros) {
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.BUSCAR_TODOS:
			sql.append( "select matri_id                    as   matriid           ,       " +
					"			 alum_id                     as   alumid           ,        " +
					"			 aula_id                     as   aulaid           ,        " +
					"			 fec_matri                   as   fecmatri           ,      " +
					"			 observ                      as   observ           ,        " +
					"			 estado                      as   estado           ,        " +
					"			 anio                        as   anio           ,          " +
					"			 usu_reg                     as   usureg           ,        " +
					"			 fec_reg                     as   fecreg           ,        " +
					"			 usu_mod                     as   usumod           ,        " +
					"			 fec_mod                     as   fecmod           ,        " +
					"			 maq_reg                     as   maqreg           ,        " +
					"			 colegio_id                  as   colegioid           ,     " +
					"			 maq_mod                     as   maqmod                    " +
					"			 from matricula                                             " );	
			break;
		

		
		default:
			break;
		}

		List<Matricula> lista = buscar(sql.toString(), parametros);

		
		return lista;
	}

	@Override
	public int grabar(Matricula parametros) {
		int i = 0;
		StringBuilder sql = new StringBuilder();
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			sql.append( " insert into matricula (alum_id, nivel, fec_matri, observ, estado, anio, usu_reg,  maq_reg) values "+Utiles.inParametros(8));
			break;

		case Constantes.ACTUALIZAR:
			sql.append( " update matricula set alum_id=?, aula_id=?, fec_matri=?, observ=?, estado=?, anio=?, usu_mod=?, fec_mod=?, maq_mod=? where  matri_id=?  ");
			break;
		default:
			break;
		}
		

		i = crud(sql.toString(), parametros);

		return i;
	}

	

	@Override
	public void setParametros(PreparedStatement prepaStatement, Matricula parametros) throws SQLException {
		int i = 1;
		switch (parametros.getOpcion()) {
		case Constantes.INSERTAR:
			prepaStatement.setInt(i++,parametros.getAlumId());
			prepaStatement.setInt(i++,parametros.getNivel());
			prepaStatement.setDate(i++,new java.sql.Date(new Date().getTime()));
			prepaStatement.setString(i++,parametros.getObserv());
			prepaStatement.setInt(i++,parametros.getEstado());
			prepaStatement.setString(i++,parametros.getAnio());
			prepaStatement.setString(i++, parametros.getUsuReg());
			prepaStatement.setString(i++, parametros.getMaqReg());
			
			break;

		case Constantes.ACTUALIZAR:
			
			break;
		case Constantes.BUSCAR_TODOS:
			prepaStatement.setInt(i++, parametros.getMatriId());
			
			break;	
			
		default:
			break;
		}
		
		
	}

	@Override
	public Matricula getFactory() {
		// TODO Auto-generated method stub
		return new Matricula();
	}

	public List<MatriculadosBean> listarMatriculados(Alumno parametro){
		List<MatriculadosBean> lista = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
			sql.append(" select m.matri_id, " + 
						" (select concat(IFNULL(ms.valor,''), ' ', IFNULL(ms.desc_larga,''), ' ', IFNULL(ms.desc_corta,'')) "+ 
						" from maestra ms where ms.maes_id = m.nivel) grado, " + 
						" concat(a.ape_pate, ' ', a.ape_mate, ', ', a.nombres) alumno,  "+ 
						" (select ms.valor  from maestra ms where ms.maes_id = a.sexo) sexo, "+ 
						" a.fec_naci fecNaci, "+ 
						" m.anio "+ 
						" from matricula m, alumno a "+ 
						" where m.alum_id = a.alum_id ");
			if(StringUtils.isNotEmpty(parametro.getApePate())){
				sql.append(" and a.ape_pate like ?%");
			}
			if(StringUtils.isNotEmpty(parametro.getApeMate())){
				sql.append(" and a.ape_mate like ?%");
			}
			if(StringUtils.isNotEmpty(parametro.getNombres())){
				sql.append(" and a.nombres like ?%");
			}
			
			if(StringUtils.isNotEmpty(parametro.getDni())){
				sql.append(" and a.dni = ?");
			}
			
			sql.append(" and m.colegioId = ? ");
			sql.append(" and m.anio = ? ");
			
			try {
				connection = dataSource.getConnection();
				prepaStatement = connection.prepareStatement(sql.toString());
				
				resultSet = prepaStatement.executeQuery();
				while(resultSet.next()){
					MatriculadosBean objCons = getMatriculados();
					objCons.setMatriId(resultSet.getInt("matriId"));
					objCons.setAlumno(resultSet.getString("alumno"));
					objCons.setAnio(resultSet.getString("anio"));
					objCons.setSexo(resultSet.getInt("sexo"));
					objCons.setFecNaci(resultSet.getDate("fecNaci"));
					lista.add(objCons);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		return lista;
	}

	public MatriculadosBean getMatriculados() {
		// TODO Auto-generated method stub
		return new MatriculadosBean();
	}
}
