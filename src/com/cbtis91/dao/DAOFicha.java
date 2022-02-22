package com.cbtis91.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cbtis91.databases_items.ConnectionDB;
import com.cbtis91.interfaces.IDAOcrud;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ficha getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
