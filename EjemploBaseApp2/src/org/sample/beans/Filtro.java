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
public class Filtro {
  public final static int EQUAL=0;
  public final static int LIKE=1;

  private String filterName;
  private String property;
  private Object value;
  private Class clazz;
  private int typeLike;

    public Filtro() {
    }

    public Filtro(String filterName,String property,Class clazz){
      this(filterName, property,null, clazz,-1);
    }

    public Filtro(String filterName, String property, Object value, Class clazz, int typeLike) {
        this.filterName = filterName;
        this.property = property;
        this.value = value;
        this.clazz = clazz;
        this.typeLike = typeLike;
    }


    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public int getType() {
        return typeLike;
    }

    public void setType(int type) {
        this.typeLike = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterName() {
        return filterName;
    }

    @Override
    public String toString() {
        if(filterName!=null){
          return filterName;
        }else{
         return super.toString();
        }
    }


}
