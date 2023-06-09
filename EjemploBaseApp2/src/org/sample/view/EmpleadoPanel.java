/*
 *  ASTI Services (c) © 2010
 *  Consultoria de Software.
 */
/*
 * JCompanyPanel.java
 *
 * Created on 7/05/2010, 02:06:03 PM
 */
package org.sample.view;


import org.sample.beans.AbstractManageableIFrame;
import org.sample.beans.Filtro;
import org.sample.main.Principal;
import org.sample.dao.EmpleadoDAO;
import org.sample.pojo.Empleado;
import org.sample.beans.DataServiceException;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import org.developercircle.beans.JEditionDataProvider;
import org.developercircle.beans.JEditionListener;
import org.developercircle.beans.RichColumnModel;
import org.developercircle.beans.RichDataColumn;
import org.developercircle.beans.RichTableModel;
import org.sample.beans.ConexionDB;
import org.sample.dao.DepartamentoDAO;
import org.sample.pojo.Departamento;

public class EmpleadoPanel extends JPanel implements JEditionDataProvider<Empleado>, JEditionListener<Empleado>, ListSelectionListener {

    private final String LIST_PANEL = "LISTING";
    private final String EDIT_PANEL = "EDITION";//tambien sera utilizado como bandera para hacer save or update
    private AbstractManageableIFrame janf;
    private Principal app;
    private RichTableModel model;
    private Empleado empleadoToEdit;
    private EmpleadoDAO daoEmpleado;
    private String currentView;
    private boolean  isEdit=false;
   
    public EmpleadoPanel(AbstractManageableIFrame janf, Principal app) {
        initComponents();
        this.janf = janf;
        this.app = app;
        daoEmpleado=new EmpleadoDAO();
        initOtherComponent();
        fillDepartamento();
        
        
        
    }
    
 
    private void fillDepartamento(){
        try {
            box_departamento.removeAllItems();
            DepartamentoDAO daoDepartamento=new DepartamentoDAO();
            List<Departamento> lstDepartamento= daoDepartamento.listar();
            for (Departamento departamentoTemp : lstDepartamento) {
               box_departamento.addItem(departamentoTemp);
            }
        } catch (DataServiceException ex) {
            Logger.getLogger(DepartamentoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initOtherComponent() {
        showOnLayout(LIST_PANEL);
        fillComboSearch();
        createTableDepartamento();
        jtableProducts.getSelectionModel().addListSelectionListener(this);
        jeditionBar.setDataProvider(this);
        jeditionBar.setEditionListener(this);
        jeditionBar.active();
        doEnableBar();
    }
    //@Override
    public void activate() {
            showOnLayout(LIST_PANEL);
            refreshData();
            empleadoToEdit = null;

    }

    private void fillComboSearch() {
        jcmb_search.setModel(new DefaultComboBoxModel(getItemsComboSearch()));
    }

    /**
     * Rergesa los filtros a aparecer en el combo
     * @return Object[] - Lista de filtros dispoibles para la pantalla de productos
     */
    private Object[] getItemsComboSearch() {

        return new Object[]{
                    new Filtro("Nombre", "nombre", String.class),};
    }

    private void doEnableBar() {
        jeditionBar.enableBuscar(false);
        jeditionBar.enableEditar(true);
        //jeditionBar.enableElimnar(true);
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpanel_content = new javax.swing.JPanel();
        jpanel_listdata = new javax.swing.JPanel();
        jpanel_filtro = new javax.swing.JPanel();
        jtxt_value = new javax.swing.JTextField();
        jcmb_search = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jbtn_search = new javax.swing.JButton();
        jrdo_equal = new javax.swing.JRadioButton();
        jrdo_contentwords = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableProducts = new javax.swing.JTable();
        jpanel_editing = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spinnerEdad = new javax.swing.JSpinner();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        radioF = new javax.swing.JRadioButton();
        radioM = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        box_departamento = new javax.swing.JComboBox();
        dateCalendar = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jeditionBar = new org.developercircle.beans.JEditionBar();

        setPreferredSize(new java.awt.Dimension(786, 536));
        setLayout(new java.awt.BorderLayout());

        jpanel_content.setLayout(new java.awt.CardLayout());

        jpanel_listdata.setLayout(new java.awt.BorderLayout());

        jpanel_filtro.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros de búsqueda"));

        jLabel2.setText("Por");

        jbtn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sample/imagen/filter.png"))); // NOI18N
        jbtn_search.setIconTextGap(8);
        jbtn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_searchActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrdo_equal);
        jrdo_equal.setText("Igual");
        jrdo_equal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdo_equalActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrdo_contentwords);
        jrdo_contentwords.setSelected(true);
        jrdo_contentwords.setText("Que contenga las palabras");

        javax.swing.GroupLayout jpanel_filtroLayout = new javax.swing.GroupLayout(jpanel_filtro);
        jpanel_filtro.setLayout(jpanel_filtroLayout);
        jpanel_filtroLayout.setHorizontalGroup(
            jpanel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_filtroLayout.createSequentialGroup()
                        .addComponent(jrdo_equal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrdo_contentwords, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                    .addComponent(jtxt_value, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcmb_search, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374))
        );
        jpanel_filtroLayout.setVerticalGroup(
            jpanel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmb_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrdo_equal)
                    .addComponent(jrdo_contentwords))
                .addContainerGap())
        );

        jpanel_listdata.add(jpanel_filtro, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(jtableProducts);

        jpanel_listdata.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpanel_content.add(jpanel_listdata, "LISTING");

        jpanel_editing.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del producto"));

        jLabel22.setText("Nombre");

        jLabel23.setText("Clave");

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 204, 51));
        jLabel29.setText("*");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 204, 51));
        jLabel32.setText("*");

        jLabel3.setText("Direccion");

        jLabel4.setText("Telefono");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setText("Sexo");

        jLabel6.setText("Edad");

        spinnerEdad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 204, 51));
        jLabel33.setText("*");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 204, 51));
        jLabel34.setText("*");

        buttonGroup1.add(radioF);
        radioF.setText("Femenino");
        radioF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioM);
        radioM.setText("Masculino");
        radioM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMActionPerformed(evt);
            }
        });

        jLabel7.setText("Departamento");

        jLabel8.setText("Fecha de nacimiento");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 204, 51));
        jLabel35.setText("*");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 204, 51));
        jLabel36.setText("*");

        jLabel9.setText("NO LO LLENES");

        javax.swing.GroupLayout jpanel_editingLayout = new javax.swing.GroupLayout(jpanel_editing);
        jpanel_editing.setLayout(jpanel_editingLayout);
        jpanel_editingLayout.setHorizontalGroup(
            jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_editingLayout.createSequentialGroup()
                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpanel_editingLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpanel_editingLayout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel29))
                                .addGroup(jpanel_editingLayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel32))
                                .addGroup(jpanel_editingLayout.createSequentialGroup()
                                    .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addGroup(jpanel_editingLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36))))
                    .addGroup(jpanel_editingLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel35))
                    .addGroup(jpanel_editingLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_editingLayout.createSequentialGroup()
                        .addComponent(dateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(661, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_editingLayout.createSequentialGroup()
                        .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpanel_editingLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(jpanel_editingLayout.createSequentialGroup()
                                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                    .addComponent(txtClave)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpanel_editingLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(radioF)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioM))
                                    .addComponent(box_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(303, 303, 303))))
        );
        jpanel_editingLayout.setVerticalGroup(
            jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_editingLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel29))
                .addGap(12, 12, 12)
                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel32))
                .addGap(30, 30, 30)
                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(28, 28, 28)
                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(radioF)
                    .addComponent(radioM)
                    .addComponent(jLabel35))
                .addGap(34, 34, 34)
                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jpanel_editingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(spinnerEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25))
        );

        jpanel_content.add(jpanel_editing, "EDITION");

        add(jpanel_content, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 2, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sample/imagen/help.png"))); // NOI18N
        jLabel1.setText("Visualiza, edita y elimina Tipos de Empleados  del catálogo");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIconTextGap(8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(357, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName(""); // NOI18N

        jPanel4.add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel4.add(jeditionBar, java.awt.BorderLayout.EAST);

        add(jPanel4, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jbtn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_searchActionPerformed

        try {

            List<Empleado> emple = new ArrayList<Empleado>();
            if (!jtxt_value.getText().isEmpty()) {
                Filtro f = (Filtro) jcmb_search.getModel().getSelectedItem();
                if (jrdo_equal.isSelected()) {
                    f.setType(Filtro.EQUAL);
                } else {
                    f.setType(Filtro.LIKE);
                }
                f.setValue(jtxt_value.getText());

                emple = daoEmpleado.listar(f);

            } else {
                emple = daoEmpleado.listar();
            }

            model.clear();
            loadData(emple);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Error:",JOptionPane.ERROR_MESSAGE);
            
        }

    }//GEN-LAST:event_jbtn_searchActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void radioFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFActionPerformed
        
    }//GEN-LAST:event_radioFActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
       
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
      char c= evt.getKeyChar();
     if(c<'0'|| c>'9')evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void radioMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMActionPerformed
        
    }//GEN-LAST:event_radioMActionPerformed

    private void jrdo_equalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdo_equalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrdo_equalActionPerformed


    private void showOnLayout(String namePanel) {
        currentView = namePanel;
        CardLayout lyt = (CardLayout) jpanel_content.getLayout();
        lyt.show(jpanel_content, namePanel);
    }

    private void createTableDepartamento() {
        RichColumnModel columnModel = new RichColumnModel();

        columnModel.add(new RichDataColumn(String.class, "Clave", "clave", false));
        columnModel.add(new RichDataColumn(String.class, "Nombre", "nombre", false));
        columnModel.add(new RichDataColumn(String.class, "Direccion","direccion", false));
        columnModel.add(new RichDataColumn(Integer.class, "Telefono","telefono", false));
        columnModel.add(new RichDataColumn(String.class, "Sexo","sexo", false));
        columnModel.add(new RichDataColumn(String.class, "Fecha de Nacimiento","fecha", false));
        columnModel.add(new RichDataColumn(int.class, "Edad","edad", false));
        columnModel.add(new RichDataColumn(int.class, "Departamento","departamento", false));
        
        model = new RichTableModel(columnModel);
        jtableProducts.setModel(model);
    }

    public void refreshData() {
        model.clear();
        loadData();
    }

    private void loadData() {
        try {
            List<Empleado> emples = daoEmpleado.listar();
            loadData(emples);
        } catch (DataServiceException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error:", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadData(List<Empleado> emple) {
        for (Empleado emp : emple) {
            model.addRow(emp);
        }
    }

    /**
     * Metodo que llena con informacion los controles del formulario de Producto
     * @param e un producto
     */
    private void fillControls(Empleado e) {
        txtClave.setText(e.getClave());
        txtNombre.setText(e.getNombre());
        txtDireccion.setText(e.getDireccion());
        txtTelefono.setText(e.getTelefono());
        spinnerEdad.setValue(e.getEdad());
        box_departamento.setSelectedItem(e.getDepartamento().toString());
       
        if(e.getSexo().equals("Femenino"))
             radioF.setSelected(true);
         else
             radioM.setSelected(true);
        
        dateCalendar.setDate(e.getFecha());
        FactoryView c = new FactoryView();
        int d = c.calcularEdad(dateCalendar.getCalendar());
    }

    private void fillEmpleado(Empleado e) {
        if (isValidated()) {
            e.setClave(txtClave.getText());
            e.setNombre(txtNombre.getText());
            e.setDireccion(txtDireccion.getText());
            e.setTelefono(txtTelefono.getText());
            //e.setEdad(Integer.parseInt(spinnerEdad.getValue().toString()));
            Departamento dep= (Departamento)box_departamento.getSelectedItem();
            e.setDepartamento(dep);
    
             if(radioF.isSelected())
                 e.setSexo("Femenino");
             else 
                 e.setSexo("Masculino");
            e.setFecha(dateCalendar.getDate());
            
            //Aqui Empieza mi Calculo
            
            FactoryView c = new FactoryView();
            int d = c.calcularEdad(dateCalendar.getCalendar());
            e.setEdad(d);
        }
    }

    /**
     * limpia los controles
     */
    private void clearControls() {
        txtClave.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        
        
    }

    private boolean isValidated() {
        boolean band = false;
        if (!txtClave.getText().trim().isEmpty() && !txtNombre.getText().trim().isEmpty()&& !txtDireccion.getText().trim().isEmpty() && !txtTelefono.getText().trim().isEmpty()) {
            band = true;
        }
        return band;
    }

    /**
     * Regresa un producto seleccionado de la tabla
     * @return Producto - un producto selecionado en la tabla de productos
     */
    private Empleado detSelectedEmpleado() {
        Empleado c = null;
        int index = jtableProducts.getSelectionModel().getMinSelectionIndex();

        if (jtableProducts.getSelectionModel().isSelectedIndex(index)) {
            c = (Empleado) model.getData().get(index);
        }
        return c;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox box_departamento;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dateCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_search;
    private javax.swing.JComboBox jcmb_search;
    private org.developercircle.beans.JEditionBar jeditionBar;
    private javax.swing.JPanel jpanel_content;
    private javax.swing.JPanel jpanel_editing;
    private javax.swing.JPanel jpanel_filtro;
    private javax.swing.JPanel jpanel_listdata;
    private javax.swing.JRadioButton jrdo_contentwords;
    private javax.swing.JRadioButton jrdo_equal;
    private javax.swing.JTable jtableProducts;
    private javax.swing.JTextField jtxt_value;
    private javax.swing.JRadioButton radioF;
    private javax.swing.JRadioButton radioM;
    private javax.swing.JSpinner spinnerEdad;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public Empleado getCurrentData() {
        Empleado c = null;
        if (currentView.equals(LIST_PANEL)) {
            c = detSelectedEmpleado();
            if (c == null) {
                Toolkit.getDefaultToolkit().beep();
            }
        } else if (currentView.equals(EDIT_PANEL) && empleadoToEdit != null) {
            fillEmpleado(empleadoToEdit);
            return empleadoToEdit;
        } else {
            //devolvemos un producto nuevo
            c = new Empleado();
            fillEmpleado(c);//llenamos un producto con la informacion del fomulario
        }
        return c;
    }

    @Override
    public boolean cancel() {
        refreshData();
        showOnLayout(LIST_PANEL);
        empleadoToEdit = null;
        return true;
    }

    @Override
    public Empleado search() {
        return null;
    }

    @Override
    public boolean newData() {
        isEdit=false;
        showOnLayout(EDIT_PANEL);
        clearControls();
        empleadoToEdit = null;
        return true;
    }

    @Override
    public boolean edit(Empleado data) {
        isEdit=true;
        if (data != null) {
            empleadoToEdit = data;
            showOnLayout(EDIT_PANEL);
            fillControls(data);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(Empleado data) {
        if (data != null) {
            try {
                
                if (JOptionPane.showConfirmDialog(this,
                        "Realmente desea eliminar el empleado","Atención:",JOptionPane.YES_NO_CANCEL_OPTION) 
                        == JOptionPane.YES_OPTION) {
                    daoEmpleado.borrar(data);
                    showOnLayout(LIST_PANEL);
                    refreshData();
                    empleadoToEdit = null;
                    return true;
                } else {
                    return false;
                }
            } catch (DataServiceException ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage(),"Error:",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean save(Empleado data) {
        //System.out.println(data+"---------------------------------------------------------------"+jtxt_codebar.getText());
        //if (!jtxt_nombre.getText().trim().isEmpty()&&!jtxt_codebar.getText().trim().isEmpty()&&!jtxt_unidad.getText().trim().isEmpty()&&!jtxt_costo.getText().trim().isEmpty()) {
        //if (data !=null) {
        if (isValidated()) {
            try {
                if (isEdit)
                    data = daoEmpleado.modificar(data);
                else
                    data = daoEmpleado.guardar(data);
                
                showOnLayout(LIST_PANEL);
                refreshData();
                empleadoToEdit = null;
                return true;
            } catch (DataServiceException ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage(),"Error:", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(this,"Faltan campos","Atención:", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    @Override
    public void cathException(Exception ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage(),"Error:", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public boolean foundData(Empleado found) {
        return false;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            //nos permitira observar si se selecciona algun elemento d ela lista
            int i = jtableProducts.getSelectionModel().getMinSelectionIndex();
            if (jtableProducts.getSelectionModel().isSelectedIndex(i)) {
                doEnableBar();
            }
        }
    }

    private void poblarCombo() {
        try {
            Connection con = null;
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ejemplo2","postgres","1234");
            java.sql.Statement st=con.createStatement();
            ResultSet reg=st.executeQuery("Select nombre  from departamento");
            box_departamento.removeAllItems();
            while (reg.next()) {
               box_departamento.addItem(reg.getString(1));
                
            }
        } catch (Exception e) {
        }
       
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

