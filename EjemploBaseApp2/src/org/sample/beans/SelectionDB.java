/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.beans;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author gabriel
 */
public abstract class SelectionDB<T> {
    protected T pojo;
    protected Filtro filtro;

    public SelectionDB(T pojo,Filtro filtro) {
        this.filtro=filtro;
        this.pojo = pojo;
    }
    public abstract List<T> select(Connection con) throws DataServiceException;
    public T getPojo(){
        return pojo;
    }
}
