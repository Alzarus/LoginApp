/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.SQLException;

import dao.sqlDao;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pedro
 */
public class Usuario {

    public Usuario(){
        instantiateDao();
    }
    
    private void instantiateDao(){
        try {
            this.sql = new sqlDao();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public boolean existsOnDatabase() throws SQLException{
        return sql.find(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    private String id;
    private String pwd;
    private sqlDao sql;
    
}
