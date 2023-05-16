/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.beans;

import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.text.MessageFormat;
import javax.swing.table.TableColumn;

/**
 *
 * @author gabriel
 */
public class UIUtils {

    public static Point getCenterLocation(Component parent, Component toCenter) {
        Point p = null;
        try {
            int x = parent.getWidth() / 2 - toCenter.getWidth() / 2;
            int y = (parent.getHeight() / 2 - toCenter.getHeight() / 2);
            p = new Point(x, y);
        } catch (Exception ex) {
            p = new Point(0, 0);
        }
        return p;

    }

    public static Point getCenterLocationOnX(Component parent, Component toCenter, int yLocation) {
        Point p = getCenterLocation(parent, toCenter);
        p.y = yLocation;
        return p;
    }

    public static String fillTemplate(String source, String[] arg) {
        MessageFormat ft = new MessageFormat("");
        ft.applyPattern(source);
        return ft.format(arg);
    }

    public static void setPreferedSizeTableColumn(TableColumn column,int pref,int min,int max){
      column.setPreferredWidth(pref);
      column.setMinWidth(min);
      column.setMaxWidth(max);
    };
    
    public static void setPreferedSizeTableColumn(TableColumn column,int size){
      setPreferedSizeTableColumn(column, size, size, size+1);
    };

    public static Image getIconApp(Class c,String name){
      return Toolkit.getDefaultToolkit().createImage(c.getResource(name));
    }

    /*
     * Obtiene la extencion de un archivo
     */
    public static String getFileExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }


}
