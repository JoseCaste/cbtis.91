package com.cbtis91.databases_items;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	    public static ConnectionDB conexionDB=null;
	    private static final Logger logger= Logger.getLogger(ConnectionDB.class.getName());  
	    private ConnectionDB(){
	    	Connection con=null;
	    	try {
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/servicios_escolares", "cbtis", "12345");
			} catch (Exception e) {
				logger.log(Level.WARNING, "Error {0}",e);
			}
	    }
	    
	    public static ConnectionDB getInstance(){
	        if(conexionDB == null)
	             conexionDB= new ConnectionDB();
	        return conexionDB;
	    }
	    public boolean execute(String sql){
	        return true;
	    }
}
