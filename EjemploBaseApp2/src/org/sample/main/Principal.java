/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.main;

//import com.astiservices.asistencia.view.FactoryView;
//import com.astiservices.beans.AbstractManageableIFrame;
//import javafx.scene.AmbientLight;
import javax.swing.JDesktopPane;
import org.sample.beans.AbstractManageableIFrame;
import org.sample.view.FactoryView;

/**
 *
 * @author gabriel
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalMDI
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuDepartamento = new javax.swing.JMenuItem();
        mnuEmpleado = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(desktopPrincipal, java.awt.BorderLayout.CENTER);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sample/imagen/inicio.png"))); // NOI18N
        jMenu1.setText("Inicio");
        jMenu1.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jMenu1.add(jSeparator1);

        mnuSalir.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sample/imagen/exit.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sample/imagen/organizacion.png"))); // NOI18N
        jMenu2.setText("Catalogo");
        jMenu2.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jMenu2.add(jSeparator2);

        mnuDepartamento.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        mnuDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sample/imagen/asistencia.png"))); // NOI18N
        mnuDepartamento.setText("Departamento");
        mnuDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDepartamentoActionPerformed(evt);
            }
        });
        jMenu2.add(mnuDepartamento);

        mnuEmpleado.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        mnuEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sample/imagen/grupo.png"))); // NOI18N
        mnuEmpleado.setText("Empleado");
        mnuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEmpleadoActionPerformed(evt);
            }
        });
        jMenu2.add(mnuEmpleado);

        jMenuItem1.setText("jMenuItem1");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDepartamentoActionPerformed
        AbstractManageableIFrame departamentoV= FactoryView.createView(FactoryView.ViewsCatalog.DEPARTAMENTO, this);
        departamentoV.activate();
        departamentoV.setVisible(true);
    }//GEN-LAST:event_mnuDepartamentoActionPerformed

    private void mnuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEmpleadoActionPerformed
       AbstractManageableIFrame empleadoV= FactoryView.createView(FactoryView.ViewsCatalog.EMPLEADO, this);
        empleadoV.activate();
        empleadoV.setVisible(true);
    }//GEN-LAST:event_mnuEmpleadoActionPerformed
   public JDesktopPane getDesktopPane(){
       return desktopPrincipal;
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem mnuDepartamento;
    private javax.swing.JMenuItem mnuEmpleado;
    private javax.swing.JMenuItem mnuSalir;
    // End of variables declaration//GEN-END:variables
}