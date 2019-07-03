/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smf.gui.clientes;

import java.awt.event.KeyEvent;
import java.util.Date;
import smf.controller.ClientesJpaController;
import smf.entity.Clientes;
import smf.gui.BaseFrame;
import smf.gui.SmartFactMain;

/**
 *
 * @author mjapon
 */
public class NewPersonaFrame extends BaseFrame {

    private IParenCliFrame parentFrame;
    private ClientesJpaController clientesCntrl;
    private Integer tipo;

    /**
     * Creates new form NewPersonaFrame
     */
    public NewPersonaFrame(IParenCliFrame parent, Integer tipo) {
        initComponents();
        clientesCntrl = new ClientesJpaController(em);
        this.parentFrame = parent;
        this.tipo = tipo;

        String titulo = "";
        switch (tipo) {
            case 1: {
                titulo = "Registrar Cliente";
                jRBCliente.setSelected(true);
                break;
            }
            case 2: {
                titulo = "Registrar Proveedor";
                jRBProveedor.setSelected(true);
                break;
            }
            default: {
                titulo = "";
                break;
            }
        }

        jLabelTit.setText(titulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelTit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jRBCliente = new javax.swing.JRadioButton();
        jRBProveedor = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jTFCiRuc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFTelf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFMovil = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabelTit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTit.setText("Registrar Referente");
        jPanel1.add(jLabelTit);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(8, 2));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Tipo:");
        jPanel2.add(jLabel2);

        buttonGroup1.add(jRBCliente);
        jRBCliente.setSelected(true);
        jRBCliente.setText("Cliente");
        jRBCliente.setEnabled(false);
        jRBCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBClienteActionPerformed(evt);
            }
        });
        jPanel4.add(jRBCliente);

        buttonGroup1.add(jRBProveedor);
        jRBProveedor.setText("Proveedor");
        jRBProveedor.setEnabled(false);
        jRBProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBProveedorActionPerformed(evt);
            }
        });
        jPanel4.add(jRBProveedor);

        jPanel2.add(jPanel4);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Ci/Ruc:");
        jPanel2.add(jLabel3);

        jTFCiRuc.setPreferredSize(new java.awt.Dimension(10, 35));
        jTFCiRuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFCiRucFocusLost(evt);
            }
        });
        jTFCiRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFCiRucKeyPressed(evt);
            }
        });
        jPanel2.add(jTFCiRuc);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Nombres:");
        jPanel2.add(jLabel4);

        jTFNombres.setPreferredSize(new java.awt.Dimension(10, 30));
        jTFNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNombresKeyPressed(evt);
            }
        });
        jPanel2.add(jTFNombres);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Apellidos:");
        jPanel2.add(jLabel5);

        jTFApellidos.setPreferredSize(new java.awt.Dimension(10, 30));
        jTFApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFApellidosKeyPressed(evt);
            }
        });
        jPanel2.add(jTFApellidos);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Dirección:");
        jPanel2.add(jLabel6);

        jTFDireccion.setPreferredSize(new java.awt.Dimension(10, 30));
        jTFDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFDireccionKeyPressed(evt);
            }
        });
        jPanel2.add(jTFDireccion);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Telf:");
        jPanel2.add(jLabel7);

        jTFTelf.setPreferredSize(new java.awt.Dimension(10, 30));
        jTFTelf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFTelfKeyPressed(evt);
            }
        });
        jPanel2.add(jTFTelf);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("Móvil:");
        jPanel2.add(jLabel8);

        jTFMovil.setPreferredSize(new java.awt.Dimension(10, 30));
        jTFMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFMovilKeyPressed(evt);
            }
        });
        jPanel2.add(jTFMovil);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Email:");
        jPanel2.add(jLabel9);

        jTFEmail.setPreferredSize(new java.awt.Dimension(10, 30));
        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });
        jTFEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFEmailKeyPressed(evt);
            }
        });
        jPanel2.add(jTFEmail);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(4, 1));

        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-save.png"))); // NOI18N
        jButtonSave.setText("Guardar");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSave);

        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-close_pane_filled.png"))); // NOI18N
        jButtonClose.setText("Cerrar");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonClose);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        parentFrame.afterCloseNewPersona();
        setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        logicaAdd();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jRBProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBProveedorActionPerformed

    private void jRBClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBClienteActionPerformed

    private void jTFCiRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCiRucKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                String ciRuc = this.jTFCiRuc.getText();
                if (ciRuc.trim().length() > 4) {
                    this.jTFNombres.requestFocus();                    
                }
            }

        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }//GEN-LAST:event_jTFCiRucKeyPressed

    private void jTFNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombresKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                this.jTFApellidos.requestFocus();
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }//GEN-LAST:event_jTFNombresKeyPressed

    private void jTFApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFApellidosKeyPressed

        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                this.jTFDireccion.requestFocus();
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }

    }//GEN-LAST:event_jTFApellidosKeyPressed

    private void jTFDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDireccionKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                this.jTFTelf.requestFocus();
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }//GEN-LAST:event_jTFDireccionKeyPressed

    private void jTFTelfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTelfKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                this.jTFMovil.requestFocus();
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }//GEN-LAST:event_jTFTelfKeyPressed

    private void jTFMovilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMovilKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                this.jTFEmail.requestFocus();
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }//GEN-LAST:event_jTFMovilKeyPressed

    private void jTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailActionPerformed

    }//GEN-LAST:event_jTFEmailActionPerformed

    private void jTFEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEmailKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                logicaAdd();
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }//GEN-LAST:event_jTFEmailKeyPressed

    private void jTFCiRucFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCiRucFocusLost

        String ciRuc = this.jTFCiRuc.getText();
        if (ciRuc.trim().length() > 4) {
            Clientes clienteFinded = clientesCntrl.findByCi(ciRuc);
            if (clienteFinded != null) {
                showMsg("Ya existe el registro con el número de ci/ruc (" + clienteFinded.getCliCi() + "," + clienteFinded.getCliNombres() + ")  ingresado, ingrese otro");
            } else {
                this.jTFNombres.requestFocus();
            }
        }

    }//GEN-LAST:event_jTFCiRucFocusLost

    public void logicaAdd() {
        try {
            //Validar que haya ingresado el numero de cedula y nombres
            if (jTFCiRuc.getText().trim().length() == 0) {
                showMsg("Por favor ingrese el numero de CI/RUC");
            } else if (jTFNombres.getText().trim().length() == 0) {
                showMsg("Por favor ingrese el nombre");
            } else {
                String ciruc = jTFCiRuc.getText().trim();
                //Verificar que el ci/ruc ingresado no este registraddo
                Clientes clienteFinded = clientesCntrl.findByCi(ciruc);
                if (clienteFinded != null) {
                    showMsg("Ya existe el registro con el número de ci/ruc (" + clienteFinded.getCliCi() + "," + clienteFinded.getCliNombres() + ")  ingresado, ingrese otro");
                } else {
                    //No esta registrado se procede ha crear
                    String nombres = jTFNombres.getText().trim().toUpperCase();
                    String apellidos = jTFApellidos.getText().trim().toUpperCase();
                    Integer tipo = 1;
                    if (jRBProveedor.isSelected()) {
                        tipo = 2;
                    }
                    String direccion = jTFDireccion.getText().trim().toUpperCase();
                    String telf = jTFTelf.getText().trim().toUpperCase();
                    String movil = jTFMovil.getText().trim().toUpperCase();
                    String email = jTFEmail.getText().trim().toUpperCase();

                    Clientes newCliente = new Clientes();

                    newCliente.setCliCi(ciruc);
                    newCliente.setCliNombres(nombres);
                    newCliente.setCliApellidos(apellidos);
                    newCliente.setCliDir(direccion);
                    newCliente.setCliTelf(telf);
                    newCliente.setCliMovil(movil);
                    newCliente.setCliEmail(email);
                    newCliente.setCliFechareg(new Date());
                    newCliente.setCliTipo(tipo);

                    clientesCntrl.create(newCliente);

                    SmartFactMain.showSystemTrayMsg("Registrado exitosamente");

                    parentFrame.afterCloseNewPersona();
                    setVisible(false);
                }
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRBCliente;
    private javax.swing.JRadioButton jRBProveedor;
    private javax.swing.JTextField jTFApellidos;
    private javax.swing.JTextField jTFCiRuc;
    private javax.swing.JTextField jTFDireccion;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFMovil;
    private javax.swing.JTextField jTFNombres;
    private javax.swing.JTextField jTFTelf;
    // End of variables declaration//GEN-END:variables
}
