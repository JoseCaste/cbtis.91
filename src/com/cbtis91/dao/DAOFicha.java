package com.cbtis91.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.cbtis91.databases_items.ConnectionDB;
import com.cbtis91.interfaces.IDAOcrud;
import com.cbtis91.metadata.ExcelMetaData;
import com.cbtis91.models.Discapacidad;
import com.cbtis91.models.Especialidad;
import com.cbtis91.models.Ficha;
import com.cbtis91.models.Lengua;
import com.cbtis91.models.Localidad;

public class DAOFicha implements IDAOcrud<Ficha> {

	private ConnectionDB connectionDB;
	private Statement statement;
	private ResultSet resultSet;
	private DAOLocalidades daoLocalidades;
	private DAODiscapacidad daoDiscapacidad;
	private DAOEspecialidad daoEspecialidad;
	private DAOLengua daoLengua;
	private static final Logger logger= Logger.getLogger(DAOFicha.class.getName());
	
	public DAOFicha() {
		this.daoDiscapacidad= new DAODiscapacidad();
		this.daoEspecialidad= new DAOEspecialidad();
		this.daoLocalidades= new DAOLocalidades();
		this.daoLengua= new DAOLengua();
		this.connectionDB= ConnectionDB.getInstance();
		try {
			this.statement= this.connectionDB.getCon().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error en crear la intancia Statament en DAOLengua{0}", e);
		}
	}
	public boolean resetNumberFichaCounter() {
		try {
			//this.statement= this.connectionDB.getCon().createStatement();
			final int rowsUpdated= this.statement.executeUpdate("UPDATE numeroFicha SET numero_ficha = 1");
			if(rowsUpdated>0)
				return true;
			else 
				return false;
		} catch (SQLException e) {
			logger.log(Level.WARNING,"Error al recuperar datos de la tabla numeroFicha",e);
			JOptionPane.showMessageDialog(null, "Error al recuperar datos de la tabla numeroFicha");
			e.printStackTrace();
			return false;

		}
	}
	@Override
	public boolean save(Ficha data) {
		try {
			/*
			IN nombres_ VARCHAR(200),
			IN apellido_paterno_ varchar(200), 
			IN apellido_materno_ varchar(200),
			IN age_ int,
			IN curp_ varchar(18),
			IN fk_id_localidad_ mediumint, 
			IN address varchar(200),
			IN birth_place_ varchar(200),
			
			IN numero_telefono_ varchar(10),
			IN correo_electronico_ text, 
			
			IN op1_especialidad_ mediumint, 
			IN op2_especialidad_ mediumint,
			
			IN fk_id_lengua_ mediumint, 
			
			IN fk_id_discapacidad_ mediumint, 
			
			IN kind_school_ varchar(200), 
			OUT numeroFicha_ int
			*/
			CallableStatement callableStatement= this.connectionDB.getCon().prepareCall("{call saveFicha(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			callableStatement.setString(1,data.getNames());
			callableStatement.setString(2, data.getLastName());
			callableStatement.setString(3, data.getSecondLastName());
			callableStatement.setInt(4, data.getAge());
			callableStatement.setString(5, data.getCurp());
			//buscar id de la localidad
			Localidad localidad= this.daoLocalidades.getByName(data.getActualResidencia());
			callableStatement.setInt(6, localidad.getIdLocalidad());
			
			callableStatement.setString(7, data.getAddress());
			callableStatement.setString(8, data.getBirthPlace());
			callableStatement.setString(9, data.getContact());
			callableStatement.setString(10, data.getEmail());
			
			//buscar id de la especialidad
			Especialidad especialidad1= this.daoEspecialidad.getByName(data.getOp1Especilty());
			Especialidad especialidad2= this.daoEspecialidad.getByName(data.getOp2Especilty());
			
			callableStatement.setInt(11, especialidad1.getId_especialidad());
			callableStatement.setInt(12, especialidad2.getId_especialidad());
			
			//buscar id de la lengua
			Lengua lengua= this.daoLengua.getByName(data.getDetailLanguaje());
			callableStatement.setInt(13, lengua.getIdLengua());
			
			//buscar id de discapacidad
			Discapacidad discapacidad= this.daoDiscapacidad.getByName(data.getDetailDisability());
			callableStatement.setInt(14, discapacidad.getIdDiscapacidad());
			
			callableStatement.setString(15, data.getKindSchool());
			callableStatement.registerOutParameter(16, Types.INTEGER);
	
			callableStatement.execute();
			
			int numeroFicha= callableStatement.getInt(16);//16 es el indice del parámetro de salido según el procedimiento almacenado
			
			data.setNumeroFicha(numeroFicha);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Level.WARNING,"Error al guardar la ficha {0}",e);
		}
		return false;
	}

	@Override
	public List<Ficha> getAll() {
		return null;
	}
	
	public List<ExcelMetaData> getAllCustomQuery(){
		List<ExcelMetaData> excelMetaDatas= new ArrayList<>();
		try {
			this.resultSet=this.statement.executeQuery("SELECT f.numero_ficha, f.nombres , f.apellido_paterno ,f.apellido_materno ,f.curp ,f.numero_telefono ,f.correo_electronico ,f.op1_especialidad ,f.op2_especialidad ,l.nombre_lengua ,d.nombre_discapacidad, f.kind_school , f.edad , loc.nombre_localidad, f.birth_place , f.direccion from ficha f  inner join discapacidad d inner join lengua l inner join localidades loc where f.fk_id_localidad = loc.id_localidad and f.fk_id_discapacidad = d.id_discapacidad and l.id_lengua = f.fk_id_lengua ORDER BY f.numero_ficha;");
			while(this.resultSet.next()) {
				//"# Ficha", "Nombres", "Apellidos","Edad","CURP","Residencia actual","Dirección","Lugar de nacimiento","Opción 1 especialidad","Opción 2 especialidad","Correo electrónico","Número de teléfono","Lengua","Discapacidad","Tipo de secundaria"
				final int numeroFicha= this.resultSet.getInt("numero_ficha");
				final String names= this.resultSet.getString("nombres");
				final String lastNames=this.resultSet.getString("apellido_paterno")+" "+this.resultSet.getString("apellido_materno");
				final String curp= this.resultSet.getString("curp");
				final String contact= this.resultSet.getString("numero_telefono");
				final String email= this.resultSet.getString("correo_electronico");
				final int op1_especialidad= this.resultSet.getInt("op1_especialidad");
				final int op2_especialidad= this.resultSet.getInt("op2_especialidad");
				final String languaje= this.resultSet.getString("nombre_lengua");
				final String disability= this.resultSet.getString("nombre_discapacidad");
				final String kindSchool= this.resultSet.getString("kind_school");
				final int age= this.resultSet.getInt("edad");
				final String birthPlace= this.resultSet.getString("birth_place");
				final String address= this.resultSet.getString("direccion");
				final String locality= this.resultSet.getString("nombre_localidad");
				
				final Especialidad op1= this.daoEspecialidad.getById(op1_especialidad);
				final Especialidad op2= this.daoEspecialidad.getById(op2_especialidad);
				excelMetaDatas.add( new ExcelMetaData(numeroFicha,names, lastNames, curp, contact, email, languaje, disability, kindSchool, age, birthPlace, address, op1, op2,locality));
			}
			return excelMetaDatas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING,"Error al recupera datos para generar el reporte excel ",e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Ficha getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
