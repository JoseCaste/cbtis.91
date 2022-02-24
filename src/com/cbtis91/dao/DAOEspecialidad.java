package com.cbtis91.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.cbtis91.databases_items.ConnectionDB;
import com.cbtis91.interfaces.IDAOcrud;
import com.cbtis91.models.Especialidad;

public class DAOEspecialidad implements IDAOcrud<Especialidad> {

	private ConnectionDB connectionDB;
	private Statement statement;
	private ResultSet resultSet;
	private static final Logger logger= Logger.getLogger(DAOEspecialidad.class.getName());
	
	public DAOEspecialidad() {
		this.connectionDB=ConnectionDB.getInstance();
		try {
			this.statement= this.connectionDB.getCon().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error en crear la intancia Statament en DAOEspecialidad {0}", e);
		}
	}

	@Override
	public boolean save(Especialidad data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Especialidad> getAll() {
		List<Especialidad> especialidades= new ArrayList<>();
		try {
			this.resultSet= this.statement.executeQuery("Select * from especialidad d");
			while(this.resultSet.next()) {
				especialidades.add(new Especialidad(this.resultSet.getInt("id_especialidad"), this.resultSet.getString("nombre_especialidad")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error al recuperar datos de la tabla especialidad {0}", e);
			
		}
		return especialidades;
	}

	@Override
	public Especialidad getByName(String name) {
		try {
			this.statement= this.connectionDB.getCon().createStatement();
			this.resultSet= this.statement.executeQuery(String.format("SELECT * FROM especialidad e WHERE e.nombre_especialidad like '%s'", name));
				if(this.resultSet.next())
				
					return new Especialidad(this.resultSet.getInt("id_especialidad"),this.resultSet.getString("nombre_especialidad"));
				
				else return null;
		} catch (Exception e) {
			logger.log(Level.WARNING,"Error al recuperar datos de la tabla especialidad {0}",e);
			
			JOptionPane.showMessageDialog(null, "Error al recuperar datos de la especialidad","Error",2);
			
			return null;
		}
	}
	public Especialidad getById(int id) {
		try {
			this.statement= this.connectionDB.getCon().createStatement();
			this.resultSet= this.statement.executeQuery(String.format("SELECT * FROM especialidad e WHERE e.id_especialidad = %d", id));
				if(this.resultSet.next())
				
					return new Especialidad(this.resultSet.getInt("id_especialidad"),this.resultSet.getString("nombre_especialidad"));
				
				else return null;
		} catch (Exception e) {
			logger.log(Level.WARNING,"Error al recuperar datos de la tabla especialidad {0}",e);
			
			JOptionPane.showMessageDialog(null, "Error al recuperar datos de la especialidad","Error",2);
			
			return null;
		}
	}

}
