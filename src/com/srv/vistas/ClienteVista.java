package com.srv.vistas;

import com.srv.dto.Cliente;
import com.srv.servicios.ClienteServicioI;
import com.srv.servicios.ClienteServicioImpl;
import java.awt.event.KeyEvent;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteVista extends javax.swing.JInternalFrame {

    private int mod;

    private List<Cliente> lista;
    private Cliente cliente;
    private ClienteServicioI servicio = new ClienteServicioImpl();

    private int banderaEncontrado = 0;
    private int banderaBuscar = 0;

    public ClienteVista() {
        initComponents();
        limpiarBloquearTexto();
        cb_crud.setEnabled(true);
        this.cargarLista();
    }

    private void cargarLista() {
        try {

            this.lista = servicio.listar();
            DefaultTableModel dtm = (DefaultTableModel) elemento_tabla.getModel();
            dtm.setRowCount(0);

            for (Cliente cliente : lista) {
                dtm.addRow(new Object[]{
                    cliente.getIdCliente(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getEdad(),
                    cliente.getTelefono(),
                    cliente.getDireccion(),
                    cliente.getRuc()

                });
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        elemento_tabla = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_crud = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        elemento_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();

        jRadioButton1.setText("jRadioButton1");

        jLabel5.setText("Busqueda por");

        setClosable(true);
        setIconifiable(true);
        setTitle("Clientes");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        elemento_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Edad", "Telefono", "Dirección", "Ruc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(elemento_tabla);

        jTabbedPane1.addTab("Listado", jScrollPane1);

        jLabel1.setText("Nombre ");

        jLabel2.setText("Apellido");

        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });

        jLabel6.setText("Edad");

        jLabel8.setText("Teléfono");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(125, 125, 125))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEdad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono)
                .addGap(259, 259, 259))
        );

        jTabbedPane2.addTab("Insertar/Modificar", jPanel1);

        jLabel3.setText("ID");

        cb_crud.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crear", "Editar", "Listar", "Eliminar" }));
        cb_crud.setSelectedIndex(2);
        cb_crud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_crudActionPerformed(evt);
            }
        });

        jLabel7.setText("¿Qué operación desea realizar?");

        jLabel4.setText("NOTA: Para editar y eliminar primero debe buscar el elemento");

        elemento_guardar.setText("Guardar");
        elemento_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elemento_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("Dirección");

        jLabel10.setText("Ruc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_crud, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(elemento_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                            .addComponent(txtRuc, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnbuscar)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(cb_crud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cancelar)
                            .addComponent(elemento_guardar)))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        try {

            banderaEncontrado = 0;
            if (!txtbuscar.getText().isEmpty()) {
                banderaBuscar = 1;
                cliente = servicio.buscar(Integer.parseInt(txtbuscar.getText()));
                if (cliente != null) {
                    banderaEncontrado = 1;

                    DefaultTableModel dtm = (DefaultTableModel) elemento_tabla.getModel();
                    dtm.setRowCount(0);

                    dtm.addRow(new Object[]{
                        cliente.getIdCliente(),
                        cliente.getNombre(),
                        cliente.getApellido(),
                        cliente.getEdad(),
                        cliente.getTelefono(),
                        cliente.getDireccion(),
                        cliente.getRuc()

                    });

                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna coincidencia");
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
        }


    }//GEN-LAST:event_btnbuscarActionPerformed

    private void elemento_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elemento_guardarActionPerformed

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        int edad = txtEdad.getText().isEmpty() ? 0 : Integer.parseInt(txtEdad.getText());
        int telefono = txtTelefono.getText().isEmpty() ? 0 : Integer.parseInt(txtTelefono.getText());
        String direccion = txtDireccion.getText();
        String ruc = txtRuc.getText();
        if (!nombre.isEmpty() && !apellido.isEmpty() && !direccion.isEmpty() && !ruc.isEmpty()) {

            if (mod == 1) {

                servicio.actualizar(new Cliente(cliente.getIdCliente(),
                        nombre, apellido, edad, telefono, direccion, ruc));

                limpiarBloquearTexto();
                cargarLista();

            } else {

                servicio.crear(new Cliente(nombre, apellido, edad, telefono, direccion, ruc));

                cargarLista();
                limpiarBloquearTexto();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene los campos vacíos");
        }
    }//GEN-LAST:event_elemento_guardarActionPerformed

    private void cb_crudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_crudActionPerformed

        switch (cb_crud.getSelectedItem().toString()) {
            case "Crear":

                prepararAntesCrearEditar("Insertar");

                mod = 0;

                break;
            case "Editar":

                if (banderaEncontrado == 1 && banderaBuscar == 1) {

                    prepararAntesCrearEditar("Guardar");

                    txtNombre.setText(cliente.getNombre());
                    txtApellido.setText(cliente.getApellido());
                    txtEdad.setText(String.valueOf(cliente.getEdad()));
                    txtTelefono.setText(String.valueOf(cliente.getTelefono()));
                    txtDireccion.setText(cliente.getDireccion());
                    txtRuc.setText(cliente.getRuc());
                    mod = 1;

                } else {
                    JOptionPane.showMessageDialog(null, "Primero busque el registro a editar");
                }

                break;
            case "Listar":
                this.cargarLista();
                banderaBuscar = 0;
                break;

            case "Eliminar":
                if (banderaEncontrado == 1 && banderaBuscar == 1) {

                    boolean seElimino = servicio.eliminar(cliente.getIdCliente());
                    if (seElimino) {
                        JOptionPane.showMessageDialog(null, "Se elimninó con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede borrar porque es llave foránea en otro registro");
                    }

                    cargarLista();
                } else {
                    JOptionPane.showMessageDialog(null, "Primero busque el registro a eliminar");
                    banderaBuscar = 0;
                }
                break;
            default:
                banderaBuscar = 0;
                System.out.println("Listar");
        }


    }//GEN-LAST:event_cb_crudActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpiarBloquearTexto();
        cargarLista();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
         int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57) {
            if (txtEdad.getText().length() == 2) {
               
                evt.consume();
                getToolkit().beep();
            }
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            evt.consume();
         
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
              int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 57) {
            if (txtTelefono.getText().length() == 9) {
               
                evt.consume();
                getToolkit().beep();
            }
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            evt.consume();
         
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void prepararAntesCrearEditar(String s) {
        configurarTxt(true);

        elemento_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        elemento_guardar.setText(s);
        cb_crud.setEnabled(false);
        banderaBuscar = 0;
    }

    private void limpiarBloquearTexto() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtRuc.setText("");
        configurarTxt(false);

        elemento_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        cb_crud.setEnabled(true);
    }

    public void configurarTxt(boolean b) {
        txtNombre.setEditable(b);
        txtApellido.setEditable(b);
        txtEdad.setEditable(b);
        txtTelefono.setEditable(b);
        txtDireccion.setEditable(b);
        txtRuc.setEditable(b);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox cb_crud;
    private javax.swing.JButton elemento_guardar;
    private javax.swing.JTable elemento_tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

}
