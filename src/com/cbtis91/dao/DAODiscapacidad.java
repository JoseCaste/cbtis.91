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
import com.cbtis91.models.Discapacidad;

public class DAODiscapacidad implements IDAOcrud<Discapacidad> {

	private ConnectionDB connectionDB;
	private Statement statement;
	private ResultSet resultSet;
	private static final Logger logger= Logger.getLogger(DAODiscapacidad.class.getName());
	
	public DAODiscapacidad() {
		this.connectionDB=ConnectionDB.getInstance();
		try {
			this.statement= this.connectionDB.getCon().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error en crear la intancia Statament en DAODiscapacidad {0}", e);
		}
	}
	@Override
	public boolean save(Discapacidad data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Discapacidad> getAll() {
		List<Discapacidad> discapacidades= new ArrayList<>();
		try {
			this.resultSet= this.statement.executeQuery("Select * from discapacidad d");
			while(this.resultSet.next()) {
				discapacidades.add(new Discapacidad(this.resultSet.getInt("id_discapacidad"), this.resultSet.getString("nombre_discapacidad")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error al recuperar datos de la tabla discapacidad {0}", e);
			
		}
		return discapacidades;
	}

	@Override
	public Discapacidad getByName(String name) {
		try {
			
			this.statement= this.connectionDB.getCon().createStatement();
			this.resultSet= this.statement.executeQuery(String.format("SELECT * FROM discapacidad d WHERE d.nombre_discapacidad like '%s'", name));
				if(this.resultSet.next())
				
					return new Discapacidad(this.resultSet.getInt("id_discapacidad"), this.resultSet.getString("nombre_discapacidad"));
				
				else return null;
		}catch (Exception e) {
			
			logger.log(Level.WARNING,"Error al recuperar datos de la tabla discapacidad {0}",e);
			
			JOptionPane.showMessageDialog(null, "Error al recuperar datos de la discapacidad","Error",2);
			
			return null;
		}
	}

}
