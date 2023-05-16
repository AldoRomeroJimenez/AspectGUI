/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.beans;

import java.sql.Connection;

/**
 *
 * @author gabriel
 * @param <T>
 */
public abstract class TransactionDB<T> {
    protected T pojo;

    public TransactionDB(T pojo) {
        this.pojo = pojo;
    }
    public abstract boolean execture(Connection con) throws DataServiceException;
    public T getPojo(){
        return pojo;
    }
}
