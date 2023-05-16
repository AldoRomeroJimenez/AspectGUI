/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.dao;


import org.sample.pojo.Departamento;
import org.sample.beans.ConexionDB;
import org.sample.beans.DataServiceException;
import org.sample.beans.Filtro;
import org.sample.beans.SelectionDB;
import org.sample.beans.TransactionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class DepartamentoDAO {
    private ConexionDB cx=null;
    public DepartamentoDAO() {
        cx=ConexionDB.getInstance();
    }
    public Departamento modificar(Departamento Depto) throws DataServiceException{
        TransactionDB<Departamento> t=new TransactionDB<Departamento>(Depto) {
            @Override
            public boolean execture(Connection con) throws DataServiceException{
                boolean res=false;
                try {
                    PreparedStatement st=con.prepareStatement("update departamento set nombre=? where clave=?");
                    st.setString(1, pojo.getNombre());
                    st.setString(2, pojo.getClave());
                    st.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
                return res;
            }
        };
        cx.execute(t);
        return t.getPojo();
    }
    public Departamento guardar(Departamento Depto) throws DataServiceException{
        TransactionDB<Departamento> t=new TransactionDB<Departamento>(Depto) {
            @Override
            public boolean execture(Connection con) throws DataServiceException{
                boolean res=false;
                try {
                    PreparedStatement st=con.prepareStatement("insert into departamento (clave,nombre) values (?,?)");
                    st.setString(1, pojo.getClave());
                    st.setString(2, pojo.getNombre());
                    st.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
                return res;
            }
        };
        cx.execute(t);
        return t.getPojo();
    }
    public void borrar(Departamento Depto) throws DataServiceException{
        TransactionDB<Departamento> t=new TransactionDB<Departamento>(Depto) {
            @Override
            public boolean execture(Connection con) throws DataServiceException{
                boolean res=false;
                try {
                    
                    PreparedStatement st=con.prepareStatement("delete from departamento where clave=?");
                    st.setString(1, pojo.getClave());
                    st.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
                return res;
            }
        };
        cx.execute(t);
    }
    public List<Departamento> listar() throws DataServiceException{
        SelectionDB<Departamento> s=new SelectionDB<Departamento>(null,null) {
            @Override
            public List<Departamento> select(Connection con) throws DataServiceException {
                List<Departamento> lstDepto=new ArrayList<>();
                try {
                    Statement st=con.createStatement();
                    ResultSet reg=st.executeQuery("Select * from departamento order by clave");
                    while(reg.next()){
                        Departamento p=new Departamento();
                        p.setClave(reg.getString("clave"));
                        p.setNombre(reg.getString("nombre"));
                        lstDepto.add(p);
                    }
                    return lstDepto;
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
               
            }
        };
        List<Departamento> lstDepto=cx.select(s);
        return lstDepto;
    }
    public List<Departamento> listar(Filtro filtro) throws DataServiceException{
        
        SelectionDB<Departamento> s=new SelectionDB<Departamento>(null,filtro) {
            @Override
            public List<Departamento> select(Connection con) throws DataServiceException {
                List<Departamento> lstDepto=new ArrayList<>();
                String sql="";
                if (filtro.getType() == Filtro.EQUAL) {
                    sql="Select * from departamento where " + filtro.getProperty() +"=?  order by clave";
                } else {
                    sql="Select * from departamento where " + filtro.getProperty() +" like ?  order by clave";
                }

                try { 
                    PreparedStatement  st=con.prepareStatement(sql);
                    st.setString(1, "%"+filtro.getValue().toString()+"%");
                    ResultSet reg=st.executeQuery();
                    while(reg.next()){
                        Departamento p=new Departamento();
                        p.setClave(reg.getString("clave"));
                        p.setNombre(reg.getString("nombre"));
                        lstDepto.add(p);
                    }
                    return lstDepto;
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
               
            }
        };
        List<Departamento> lstDepto=cx.select(s);
        return lstDepto;
    }
    
    public Departamento find(Filtro filtro) throws DataServiceException{
        SelectionDB<Departamento> s=new SelectionDB<Departamento>(null,filtro) {
            @Override
            public List<Departamento> select(Connection con) throws DataServiceException {
                List<Departamento> lstDepto=new ArrayList<>();
                String sql="";
                if (filtro.getType() == Filtro.EQUAL) {
                    sql="Select * from departamento where " + filtro.getProperty() +"=?  order by clave";
                } else {
                    sql="Select * from departamento where " + filtro.getProperty() +" like ?  order by clave";
                }
                try { 
                    PreparedStatement  st=con.prepareStatement(sql);
                    if(filtro.getType() == Filtro.EQUAL)
                        st.setString(1, filtro.getValue().toString());
                    else
                        st.setString(1, "%"+filtro.getValue().toString()+"%");                  
                    ResultSet reg=st.executeQuery();
                    while(reg.next()){
                        Departamento p=new Departamento();
                        p.setClave(reg.getString("clave"));
                        p.setNombre(reg.getString("nombre"));
                        lstDepto.add(p);
                    }
                    return lstDepto;
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }               
            }
        };
        List<Departamento> lstDepto=cx.select(s);
        if (lstDepto.size()>0)
            return lstDepto.get(0);
        else
            return null;
    }
}
