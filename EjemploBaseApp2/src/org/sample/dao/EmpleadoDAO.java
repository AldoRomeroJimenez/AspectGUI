
package org.sample.dao;

import org.sample.pojo.Empleado;
import org.sample.beans.ConexionDB;
import org.sample.beans.DataServiceException;
import org.sample.beans.Filtro;
import org.sample.beans.SelectionDB;
import org.sample.beans.TransactionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sample.pojo.Departamento;

public class EmpleadoDAO {
    private ConexionDB cx=null;
    public EmpleadoDAO() {
        cx=ConexionDB.getInstance();
    }
    public Empleado modificar(Empleado emple) throws DataServiceException{
        TransactionDB<Empleado> t=new TransactionDB<Empleado>(emple) {
            @Override
            public boolean execture(Connection con) throws DataServiceException{
                boolean res=false;
                try {
                    PreparedStatement st=con.prepareStatement("update empleado set nombre=? , direccion=?, telefono=?, sexo=?, edad=?, departamento=?, fecha=? where clave=?");
                    st.setString(1, pojo.getNombre());
                    st.setString(2, pojo.getDireccion());
                    st.setString(3, pojo.getTelefono());
                    st.setString(4, pojo.getSexo());
                    st.setInt(5, pojo.getEdad());
                    st.setString(6, pojo.getDepartamento().getClave());
                    st.setDate(7, new Date(pojo.getFecha().getTime()));
                    st.setString(8, pojo.getClave());
                  
                    st.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
                return res;
            }
        };
        cx.execute(t);
        return t.getPojo();
    }
    public Empleado guardar(Empleado emple) throws DataServiceException{
        TransactionDB<Empleado> t=new TransactionDB<Empleado>(emple) {
            @Override
            public boolean execture(Connection con) throws DataServiceException{
                boolean res=false;
                try {
                    PreparedStatement st=con.prepareStatement("insert into empleado (clave,nombre,direccion,telefono,sexo,edad,departamento,fecha) values (?,?,?,?,?,?,?,?)");
                    st.setString(1, pojo.getClave());
                    st.setString(2, pojo.getNombre());
                    st.setString(3, pojo.getDireccion());
                    st.setString(4, pojo.getTelefono());
                    st.setString(5, pojo.getSexo());
                    st.setInt(6, pojo.getEdad());
                    st.setString(7, pojo.getDepartamento().getClave());
                    st.setDate(8, new Date(pojo.getFecha().getTime()));
                    st.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
                return res;
            }
        };
        cx.execute(t);
        return t.getPojo();
    }
    public void borrar(Empleado emple) throws DataServiceException{
        TransactionDB<Empleado> t=new TransactionDB<Empleado>(emple) {
            @Override
            public boolean execture(Connection con) throws DataServiceException{
                boolean res=false;
                try {
                    
                    PreparedStatement st=con.prepareStatement("delete from empleado where clave=?");
                    st.setString(1, pojo.getClave());
                    st.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
                return res;
            }
        };
        cx.execute(t);
    }
    public List<Empleado> listar() throws DataServiceException{
        SelectionDB<Empleado> s=new SelectionDB<Empleado>(null,null) {
            @Override
            public List<Empleado> select(Connection con) throws DataServiceException {
                List<Empleado> lstEmple=new ArrayList<>();
                try {
                    Statement st=con.createStatement();
                    ResultSet reg=st.executeQuery("Select * from empleado order by clave");
                    while(reg.next()){
                        Empleado p=new Empleado();
                        p.setClave(reg.getString("clave"));
                        p.setNombre(reg.getString("nombre"));
                        p.setDireccion(reg.getString("direccion"));
                        p.setTelefono(reg.getString("telefono"));
                        p.setSexo(reg.getString("sexo"));
                        p.setEdad(reg.getInt("edad"));
                        p.setFecha(reg.getDate("fecha"));
                        
                        DepartamentoDAO depDao=new DepartamentoDAO();
                        Filtro busquedaPorClave=new Filtro("Clave", "clave", reg.getString("departamento"), String.class,Filtro.EQUAL);
                        
                        Departamento dep= depDao.find(busquedaPorClave);
                        
                        p.setDepartamento(dep);
                        lstEmple.add(p);
                    }
                    return lstEmple;
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
               
            }
        };
        List<Empleado> lstEmple=cx.select(s);
        return lstEmple;
    }
    public List<Empleado> listar(Filtro filtro) throws DataServiceException{
        
        SelectionDB<Empleado> s=new SelectionDB<Empleado>(null,filtro) {
            @Override
            public List<Empleado> select(Connection con) throws DataServiceException {
                List<Empleado> lstEmple=new ArrayList<>();
                String sql="";
                if (filtro.getType() == Filtro.EQUAL) {
                    sql="Select * from empleado where " + filtro.getProperty() +"=?  order by clave";
                } else {
                    sql="Select * from empleado where " + filtro.getProperty() +" like ?  order by clave";
                }

                try { 
                    PreparedStatement  st=con.prepareStatement(sql);
                    st.setString(1, "%"+filtro.getValue().toString()+"%");
                    ResultSet reg=st.executeQuery();
                    while(reg.next()){
                        Empleado p=new Empleado();
                        p.setClave(reg.getString("clave"));
                        p.setNombre(reg.getString("nombre"));
                        p.setDireccion(reg.getString("direccion"));
                        p.setTelefono(reg.getString("telefono"));
                        p.setSexo(reg.getString("sexo"));
                        p.setEdad(reg.getInt("edad"));
                        Departamento dep=new Departamento();
                        dep.setClave(reg.getString("departamento"));
                        p.setDepartamento(dep);
                        p.setFecha(reg.getDate("fecha"));
                        
                        lstEmple.add(p);
                    }
                    return lstEmple;
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DataServiceException(ex.getMessage());
                }
               
            }
        };
        List<Empleado> lstEmple=cx.select(s);
        return lstEmple;
    }
    
    public Empleado find(Filtro filtro) throws DataServiceException{
        SelectionDB<Empleado> s=new SelectionDB<Empleado>(null,filtro) {
            @Override
            public List<Empleado> select(Connection con) throws DataServiceException {
                List<Empleado> lstEmple=new ArrayList<>();
                lstEmple.add(new Empleado());
                return lstEmple;
            }
        };
        List<Empleado> lstEmple=cx.select(s);
        if (lstEmple.size()>0)
            return lstEmple.get(0);
        else
            return null;
    }
    
    
}
