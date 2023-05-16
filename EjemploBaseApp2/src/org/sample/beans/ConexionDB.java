/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class ConexionDB {
    private Connection con=null;
    
    private static ConexionDB cx=null;
    public static ConexionDB getInstance(){
        if(cx==null)
            cx=new ConexionDB();
        return cx;
    }

    
    private ConexionDB() {
        String url="jdbc:postgresql://localhost:5432/ejemplo2";
        String usr="postgres";
        String pwd="1234";
        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection(url,usr,pwd);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean execute(TransactionDB t)throws DataServiceException{
        boolean r=t.execture(con);
        return r;
    }
    public List select(SelectionDB t)throws DataServiceException{
        List r=t.select(con);
        return r;
    }
    
}
