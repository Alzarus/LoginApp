/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.sqlDao;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class Usuario {

    public Usuario(String id, String pwd){
        this.setId(id);
        this.setPwd(pwd);
    }
    
    public boolean existsOnDatabase() throws SQLException, ClassNotFoundException{
        sqlDao sql = new sqlDao();
        
        if(sql.find(this))
            return true;
        return false;
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
    
}
