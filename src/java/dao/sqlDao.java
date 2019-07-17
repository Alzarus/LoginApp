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
        private static final String DB_URL = "jdbc:derby://localhost:1527/test";
        private static final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
        private static final String DB_USER = "test";
        private static final String DB_PWD = "test";
	private static final String FIND_ALL = "SELECT * FROM TEST.USUARIOS";
        private static final String FIND_SPECIFIC = "SELECT * FROM TEST.USUARIOS WHERE ID = ? AND PWD = ?";
        
        public sqlDao() throws SQLException, ClassNotFoundException {
            Class.forName(sqlDao.DRIVER_NAME);
	}
        
        private Connection getConnection() throws SQLException {
            return DriverManager.getConnection(sqlDao.DB_URL, sqlDao.DB_USER, sqlDao.DB_PWD);
	}
        
        public boolean find(Usuario user) throws SQLException{
            String id = user.getId();
            String pwd = user.getPwd();
            
            ResultSet rSet;
            try (PreparedStatement stmt = this.getConnection().prepareStatement(sqlDao.FIND_SPECIFIC)) {
                stmt.setString(1, id);
                stmt.setString(2, pwd);
                rSet = stmt.executeQuery();
            }
            
            return rSet.next();
            
//            if(rSet.next()){
//                rSet.close();
//                return true;
//            }
//            rSet.close();
//            return false;
            
        }
        
//      private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
//	private static final String DB_URL = "jdbc:hsqldb:hsql://localhost/";
//      private static final String DB_URL = "jdbc:hsqldb:file:teste";
//	private static final String DB_USER = "SA";
//	private static final String DB_PWD = "";
}
