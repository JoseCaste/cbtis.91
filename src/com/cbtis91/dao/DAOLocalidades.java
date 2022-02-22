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
import com.cbtis91.models.Localidad;

public class DAOLocalidades implements IDAOcrud<Localidad> {

	private ConnectionDB connectionDB;
	private Statement statement;
	private ResultSet resultSet;
	private static final Logger logger= Logger.getLogger(DAOLocalidades.class.getName());
	
	
	public DAOLocalidades() {
		this.connectionDB= ConnectionDB.getInstance();
		try {
			this.statement= this.connectionDB.getCon().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error en crear la intancia Statament en DAOLocalidades{0}", e);
		}
	}

	@Override
	public boolean save(Localidad data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Localidad> getAll() {
		List<Localidad> localidades= new ArrayList<>();
		try {
			this.statement=this.connectionDB.getCon().createStatement();
			final String query= "SELECT * FROM localidades l order by l.nombre_localidad asc";
			this.resultSet= this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				localidades.add(new Localidad(this.resultSet.getInt("id_localidad"),this.resultSet.getString("nombre_localidad")));
			}
			return localidades;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error al recuperar datos de la tabla localidades {0}", e);
			JOptionPane.showMessageDialog(null, "Hubo un error al recuperar los datos de las localidades","Error",2);
			return null;
		}
	}

	@Override
	public Localidad getByName(String name) {
		try {
			this.statement= this.connectionDB.getCon().createStatement();
			this.resultSet= this.statement.executeQuery(String.format("SELECT * FROM localidades l WHERE l.nombre_localidad like '%s'", name));
			if(this.resultSet.next()) 
				
				return new Localidad(this.resultSet.getInt("id_localidad"), this.resultSet.getString("nombre_localidad"));
			
			 return null;
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(Level.WARNING,"Error al buscar por nombre {0} ",e);
			JOptionPane.showMessageDialog(null, "Error al recuperar datos de la localidad","Error",2);
			return null;
		}
	}

}
