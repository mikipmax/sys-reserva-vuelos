package com.srv.vistas;

import com.srv.dto.Destino;
import com.srv.dto.Itinerario;
import com.srv.dto.Origen;
import com.srv.servicios.DestinoServicioI;
import com.srv.servicios.DestinoServicioImpl;

import com.srv.servicios.ItinerarioServicioI;
import com.srv.servicios.ItinerarioServicioImpl;
import com.srv.servicios.OrigenServicioI;
import com.srv.servicios.OrigenServicioImpl;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.util.Date;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class ItinerarioVista extends javax.swing.JInternalFrame {

    private int mod;

    private List<Itinerario> lista;
    private Itinerario itinerario;
    private ItinerarioServicioI servicio = new ItinerarioServicioImpl();
    private DestinoServicioI servicioDestino = new DestinoServicioImpl();
    private OrigenServicioI servicioOrigen = new OrigenServicioImpl();
    private int banderaEncontrado = 0;
    private int banderaBuscar = 0;

    public ItinerarioVista() {
        initComponents();
        limpiarBloquearTexto();
        cb_crud.setEnabled(true);
        this.cargarLista();

        ((DefaultEditor) txtHora.getEditor()).getTextField().setEditable(false); //Deshabilito el jspinner para que no escriban
        ((DefaultEditor) txtMin.getEditor()).getTextField().setEditable(false);
    }

    private void cargarLista() {
        try {

            this.lista = servicio.listar();
            DefaultTableModel dtm = (DefaultTableModel) elemento_tabla.getModel();
            dtm.setRowCount(0);

            for (Itinerario itinerario : lista) {
                dtm.addRow(new Object[]{
                    itinerario.getIdItinerario(),
                    servicioOrigen.buscar(itinerario.getIdOrigen()).getnAeropuerto(),
                    servicioDestino.buscar(itinerario.getIdDestino()).getnAeropuerto(),
                    itinerario.getHora(),
                    itinerario.getFecha()

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
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        selectDestino = new javax.swing.JComboBox();
        selectOrigen = new javax.swing.JComboBox();
        jcFecha = new rojeru_san.componentes.RSDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHora = new javax.swing.JSpinner();
        txtMin = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        cb_crud = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        elemento_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        jLabel5.setText("Busqueda por");

        setClosable(true);
        setIconifiable(true);
        setTitle("Itinerarios");
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
                "Id", "Origen", "Destino", "Hora", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(elemento_tabla);

        jTabbedPane1.addTab("Listado", jScrollPane1);

        jLabel1.setText("Origen");

        jLabel2.setText("Destino");

        jLabel6.setText("Hora (24 horas)");

        jLabel8.setText("Fecha");

        selectDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDestinoActionPerformed(evt);
            }
        });

        selectOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectOrigenActionPerformed(evt);
            }
        });

        jLabel9.setText(":");

        jLabel10.setText("hh:mm");

        txtHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        txtHora.setEditor(new javax.swing.JSpinner.NumberEditor(txtHora, ""));
        txtHora.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtHoraStateChanged(evt);
            }
        });
        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraKeyTyped(evt);
            }
        });

        txtMin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        txtMin.setEditor(new javax.swing.JSpinner.NumberEditor(txtMin, ""));
        txtMin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtMinStateChanged(evt);
            }
        });
        txtMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinKeyTyped(evt);
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
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(71, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(selectDestino, javax.swing.GroupLayout.Alignment.LEADING, 0, 175, Short.MAX_VALUE)
                            .addComponent(selectOrigen, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
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
                        .addComponent(elemento_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cancelar)
                            .addComponent(elemento_guardar)))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        try {

            banderaEncontrado = 0;
            if (!txtbuscar.getText().isBlank()) {
                banderaBuscar = 1;
                itinerario = servicio.buscar(Integer.parseInt(txtbuscar.getText()));
                if (itinerario != null) {
                    banderaEncontrado = 1;

                    DefaultTableModel dtm = (DefaultTableModel) elemento_tabla.getModel();
                    dtm.setRowCount(0);

                    dtm.addRow(new Object[]{
                        itinerario.getIdItinerario(),
                        servicioOrigen.buscar(itinerario.getIdOrigen()).getnAeropuerto(),
                        servicioDestino.buscar(itinerario.getIdDestino()).getnAeropuerto(),
                        itinerario.getHora(),
                        itinerario.getFecha()

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

        int origen = Integer.parseInt(selectOrigen.getSelectedItem().toString().split(",")[0]);
        int destino = Integer.parseInt(selectDestino.getSelectedItem().toString().split(",")[0]);
        String hh = txtHora.getValue().toString();
        String mm = txtMin.getValue().toString();

        Date fecha = jcFecha.getDatoFecha();

        if (fecha != null && !hh.isBlank() && !mm.isBlank()) {
            LocalTime hora = LocalTime.of(Integer.parseInt(hh), Integer.parseInt(mm));
            if (mod == 1) {

                servicio.actualizar(new Itinerario(itinerario.getIdItinerario(),
                        origen, destino, hora, fecha));

                limpiarBloquearTexto();
                cargarLista();

            } else {

                servicio.crear(new Itinerario(origen, destino, hora, fecha));

                cargarLista();
                limpiarBloquearTexto();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene los campos vacíos");
        }
    }//GEN-LAST:event_elemento_guardarActionPerformed

    private void cb_crudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_crudActionPerformed
        selectOrigen.removeAllItems();
        selectDestino.removeAllItems();

        for (Origen origen : servicioOrigen.listar()) {
            String s = origen.getIdOrigen() + ", " + origen.getnAeropuerto();
            selectOrigen.addItem(s);

        }
        for (Destino destino : servicioDestino.listar()) {
            String s = destino.getIdDestino() + ", " + destino.getnAeropuerto();
            selectDestino.addItem(s);
        }

        switch (cb_crud.getSelectedItem().toString()) {

            case "Crear":

                prepararAntesCrearEditar("Insertar");

                mod = 0;

                break;
            case "Editar":

                if (banderaEncontrado == 1 && banderaBuscar == 1) {

                    prepararAntesCrearEditar("Guardar");

                    txtHora.setValue(itinerario.getHora().getHour());
                    txtMin.setValue(itinerario.getHora().getMinute());
                    jcFecha.setDatoFecha(itinerario.getFecha());

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

                    boolean seElimino = servicio.eliminar(itinerario.getIdItinerario());
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

    private void selectDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectDestinoActionPerformed

    private void selectOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectOrigenActionPerformed

    private void txtHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyTyped

        System.out.println("asasdfasdf");

    }//GEN-LAST:event_txtHoraKeyTyped

    private void txtHoraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtHoraStateChanged

    }//GEN-LAST:event_txtHoraStateChanged

    private void txtMinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtMinStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinStateChanged

    private void txtMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinKeyTyped

    private void prepararAntesCrearEditar(String s) {
        configurarTxt(true);

        elemento_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        elemento_guardar.setText(s);
        cb_crud.setEnabled(false);
        banderaBuscar = 0;
    }

    private void limpiarBloquearTexto() {

        txtMin.setValue(0);
        jcFecha.setDatoFecha(null);
        txtHora.setValue(0);
        configurarTxt(false);

        elemento_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        cb_crud.setEnabled(true);
    }

    public void configurarTxt(boolean b) {
        selectOrigen.setEnabled(b);
        selectDestino.setEnabled(b);
        txtMin.setEnabled(b);
        txtHora.setEnabled(b);
        jcFecha.setVisible(b);

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
    private rojeru_san.componentes.RSDateChooser jcFecha;
    private javax.swing.JComboBox selectDestino;
    private javax.swing.JComboBox selectOrigen;
    private javax.swing.JSpinner txtHora;
    private javax.swing.JSpinner txtMin;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

}
