package com.cbtis91.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cbtis91.databases_items.ConnectionDB;
import com.cbtis91.interfaces.IDAOcrud;
import com.cbtis91.models.Lengua;

public class DAOLengua implements IDAOcrud<Lengua> {
	private ConnectionDB connectionDB;
	private Statement statement;
	private ResultSet resultSet;
	private static final Logger logger= Logger.getLogger(DAOLengua.class.getName());
	
	public DAOLengua() {
		this.connectionDB= ConnectionDB.getInstance();
		try {
			this.statement= this.connectionDB.getCon().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error en crear la intancia Statament en DAOLengua{0}", e);
		}
	}
	@Override
	public boolean save(Lengua data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Lengua> getAll() {
		List<Lengua> languajes= new ArrayList<>();
		try {
			this.resultSet= this.statement.executeQuery("Select * from lengua u");
			while(this.resultSet.next()) {
				languajes.add(new Lengua(this.resultSet.getInt("id_lengua"), this.resultSet.getString("nombre_lengua")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error al recuperar datos de la tabla lengua {0}", e);
			
		}
		return languajes;
	}

	@Override
	public Lengua getById() {
		// TODO Auto-generated method stub
		return null;
	}

}
