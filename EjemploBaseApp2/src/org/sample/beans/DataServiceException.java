/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.beans;

/**
 *
 * @author gabriel
 */
public class DataServiceException extends Exception{

    public DataServiceException() {
    }

    public DataServiceException(String msg) {
        super(msg);
    }

    public DataServiceException(String msg,Throwable trw){
      super(msg, trw);
    }

}

