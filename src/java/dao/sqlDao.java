/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocio.Usuario;

/**
 *
 * @author pedro
 */
public class sqlDao {
    	private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
//	private static final String DB_URI = "jdbc:hsqldb:hsql://localhost/";
        private static final String DB_URI = "jdbc:hsqldb:file:teste";
	private static final String DB_USER = "SA";
	private static final String DB_PWD = "";
	private static final String FIND_ALL = "SELECT * FROM USUARIOS";
        private static final String FIND_SPECIFIC = "SELECT * FROM USUARIOS WHERE ID = ? AND PWD = ?";
        
        public sqlDao() throws SQLException, ClassNotFoundException {
            Class.forName(sqlDao.DRIVER_NAME);
	}
        
        private Connection getConnection() throws SQLException {
            return DriverManager.getConnection(sqlDao.DB_URI, sqlDao.DB_USER, sqlDao.DB_PWD);
	}
        
        public boolean find(Usuario user) throws SQLException{
            String id = user.getId();
            String pwd = user.getPwd();
            
            PreparedStatement stmt = this.getConnection().prepareStatement(sqlDao.FIND_SPECIFIC);
            stmt.setString(1, id);
            stmt.setString(2, pwd);
            
            ResultSet rSet = stmt.executeQuery();
            
            stmt.close();
            
            if(rSet != null){
                rSet.close();
                return true;
            }
            rSet.close();
            return false;
            
        }
}
