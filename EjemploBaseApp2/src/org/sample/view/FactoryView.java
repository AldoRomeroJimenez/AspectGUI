/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.view;

import java.util.Calendar;
import org.sample.main.Principal;
import org.sample.beans.AbstractManageableIFrame;


/**
 *
 * @author gabriel
 */
public class FactoryView {
      public enum ViewsCatalog {DEPARTAMENTO,EMPLEADO};
      
      public static AbstractManageableIFrame createView(ViewsCatalog view,Principal mdi){
          AbstractManageableIFrame viewForm=null;
          switch(view){
              case DEPARTAMENTO:
                    viewForm=new AbstractManageableIFrame(mdi,mdi.getDesktopPane() , "Catálogo de Departamento") {
                    @Override
                    public void initComponetsOther() {
                        //this.setFrameIcon(new ImageIcon(getClass().getResource("/com/astiservices/sifae/images/products2.png")));
                        panelView = new DepartamentoPanel(this,mdi);
                        ((DepartamentoPanel)panelView).activate();
                    }
                  };
              break;
                  case EMPLEADO:
                    viewForm=new AbstractManageableIFrame(mdi,mdi.getDesktopPane() , "Catálogo de Empleado") {
                    @Override
                    public void initComponetsOther() {
                        //this.setFrameIcon(new ImageIcon(getClass().getResource("/com/astiservices/sifae/images/products2.png")));
                        panelView = new EmpleadoPanel(this,mdi);
                        ((EmpleadoPanel)panelView).activate();
                    }
                  };
              break;
              
              
          }
          return viewForm;
      }
 public int calcularEdad(Calendar fechaNac) {
        
        Calendar fechaActual = Calendar.getInstance();
 
    // Cálculo de las diferencias.
    int anios = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
    int meses = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
    int dias = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
 
    // Hay que comprobar si el día de su cumpleaños es posterior
    // a la fecha actual, para restar 1 a la diferencia de años,
    // pues aún no ha sido su cumpleaños.</code>
 
    if(meses < 0 // Aún no es el mes de su cumpleaños
       || (meses==0 && dias < 0)) { // o es el mes pero no ha llegado el día.
 
        anios--;
    }
    return anios;
    }

}
