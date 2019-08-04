/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smf.gui.merc;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import smf.controller.ArticulosJpaController;
import smf.controller.CategoriasJpaController;
import smf.controller.ClientesJpaController;
import smf.controller.SecuenciasJpaController;
import smf.entity.Categorias;
import smf.entity.Clientes;
import smf.gui.BaseFrame;
import smf.gui.SmartFactMain;
import smf.util.datamodels.rows.FilaArticulo;

/**
 *
 * @author manuel.japon
 */
public class NewArtFrame extends BaseFrame {

    private CategoriasJpaController catsController;
    private SecuenciasJpaController secuenciasController;
    private List<Categorias> categorias;
    private ArticulosJpaController articulosController;
    private ClientesJpaController cliCntrl;

    private final String SEC_SERVS = "SEC_SERVS";
    private ParentNewArtFrame parentFrame;
    private List<Clientes> proveedores;

    /**
     * Creates new form NewArtFrame
     */
    public NewArtFrame(ParentNewArtFrame prFrame) {
        super();
        initComponents();
        parentFrame = prFrame;
        catsController = new CategoriasJpaController(em);
        secuenciasController = new SecuenciasJpaController(em);
        articulosController = new ArticulosJpaController(em);
        cliCntrl = new ClientesJpaController(em);
        clearForm();
        loadCats();
        setupTipoCB();
        loadProveedores();
        setupBien();
    }

    public void setupTipoCB() {
        jCBTipo.addItemListener((ev) -> {
            if (ev.getStateChange() == ItemEvent.SELECTED) {
                String item = (String) ev.getItem();
                if ("bien".equalsIgnoreCase(item)) {
                    setupBien();
                } else {
                    setupServicio();
                }
            }
        });
    }

    public void loadCats() {
        try {
            categorias = catsController.listar();
            for (Categorias categoria : categorias) {
                jCBCategoria.addItem(categoria);
            }
            /*
            Stream stream = categorias.stream().map(cat -> cat.getCatName());
            String[] catsArray = ArrayUtil.streamToStrArray(stream);
            jCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(catsArray));
             */

            Optional<Categorias> optCat = categorias.stream().filter(cat -> cat.getCatId().intValue() == -1).findFirst();
            if (optCat.isPresent()) {
                jCBCategoria.setSelectedItem(optCat.get());
                System.out.println("Se selecciono la categoria -1");
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }

    public void loadProveedores() {
        try {
            proveedores = cliCntrl.listarProveedores();
            for (Clientes cliente : proveedores) {
                jCBProveedor.addItem(cliente);
            }
            Optional<Clientes> optProv = proveedores.stream().filter(prov -> prov.getCliId().intValue() == -2).findFirst();
            if (optProv.isPresent()) {
                jCBProveedor.setSelectedItem(optProv.get());
                System.out.println("Se selecciono el proveedor -2");
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }

    public void setupServicio() {
        jTFInventario.setText("0");
        jTFInventario.setEnabled(false);
        jTFPrecioCompra.setText(BigDecimal.ZERO.toPlainString());
        jTFPrecioCompra.setEnabled(false);
        jCBProveedor.setEnabled(false);
        jTFFechaCadu.setEnabled(false);
        Integer secServ = secuenciasController.getSecuenciaValue(SEC_SERVS);
        if (secServ != null) {
            jTFCodBarra.setText("SERV_" + secServ);
        }
    }

    public void setupBien() {
        jTFInventario.setText("0");
        jTFPrecioMinimo.setText("0.0");
        jTFInventario.setEnabled(true);
        jTFCodBarra.setText("");
        jTFPrecioCompra.setText(BigDecimal.ZERO.toPlainString());
        jTFPrecioCompra.setEnabled(true);
        jCBProveedor.setEnabled(true);
        jTFFechaCadu.setEnabled(true);
    }

    public void clearForm() {
        jTFCodBarra.setText("");
        jTFNombre.setText("");
        jTFPrecioCompra.setText("");
        jTFPrecioVenta.setText("");
        jTFPrecioMinimo.setText("0.0");
        jTFInventario.setText("0");
        jCBIva.setSelected(false);
        jTFFechaCadu.setText("");
        jTFCodBarra.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jCBTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTFCodBarra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jCBProveedor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jCBIva = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFPrecioVenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFPrecioMinimo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFPrecioCompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTFInventario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFFechaCadu = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jButtonSave1 = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 1));

        jPanel6.setLayout(new java.awt.GridLayout(11, 2));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Tipo:");
        jLabel10.setPreferredSize(new java.awt.Dimension(31, 20));
        jPanel6.add(jLabel10);

        jCBTipo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BIEN", "SERVICIO" }));
        jCBTipo.setMinimumSize(new java.awt.Dimension(73, 35));
        jCBTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoActionPerformed(evt);
            }
        });
        jPanel6.add(jCBTipo);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Código:");
        jLabel2.setPreferredSize(new java.awt.Dimension(37, 20));
        jPanel6.add(jLabel2);

        jTFCodBarra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFCodBarra.setMinimumSize(new java.awt.Dimension(6, 40));
        jTFCodBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCodBarraActionPerformed(evt);
            }
        });
        jTFCodBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFCodBarraKeyPressed(evt);
            }
        });
        jPanel6.add(jTFCodBarra);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Categoría:");
        jPanel6.add(jLabel8);

        jCBCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel6.add(jCBCategoria);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("Proveedor:");
        jPanel6.add(jLabel11);

        jCBProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel6.add(jCBProveedor);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Graba IVA:");
        jPanel6.add(jLabel7);
        jPanel6.add(jCBIva);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel6.add(jLabel3);

        jTFNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFNombreMousePressed(evt);
            }
        });
        jTFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNombreKeyPressed(evt);
            }
        });
        jPanel6.add(jTFNombre);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Precio Venta:");
        jPanel6.add(jLabel4);

        jTFPrecioVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFPrecioVentaKeyPressed(evt);
            }
        });
        jPanel6.add(jTFPrecioVenta);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Precio Venta Mínimo:");
        jPanel6.add(jLabel5);

        jTFPrecioMinimo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFPrecioMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFPrecioMinimoKeyPressed(evt);
            }
        });
        jPanel6.add(jTFPrecioMinimo);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Precio Compra (sin iva):");
        jPanel6.add(jLabel6);

        jTFPrecioCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFPrecioCompraKeyPressed(evt);
            }
        });
        jPanel6.add(jTFPrecioCompra);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Inventario Actual");
        jPanel6.add(jLabel9);

        jTFInventario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFInventarioKeyPressed(evt);
            }
        });
        jPanel6.add(jTFInventario);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("Fecha Caducidad  dd/mm/aaaa");
        jPanel6.add(jLabel12);

        try {
            jTFFechaCadu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTFFechaCadu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTFFechaCadu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFFechaCaduActionPerformed(evt);
            }
        });
        jTFFechaCadu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFFechaCaduKeyPressed(evt);
            }
        });
        jPanel6.add(jTFFechaCadu);

        jPanel4.add(jPanel6);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridLayout(5, 1));

        jButtonSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-save.png"))); // NOI18N
        jButtonSave1.setText("Guardar");
        jButtonSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSave1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonSave1);

        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-save.png"))); // NOI18N
        jButtonSave.setText("Guardar y cerrar");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonSave);

        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-close_pane_filled.png"))); // NOI18N
        jButtonClose.setText("Cerrar");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonClose);

        jPanel1.add(jPanel5, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setMinimumSize(new java.awt.Dimension(120, 27));
        jPanel2.setPreferredSize(new java.awt.Dimension(120, 27));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabelTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTitle.setText("Nuevo Artículo");
        jPanel2.add(jLabelTitle);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        parentFrame.afterClose();
        setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    public void logicaAdd(boolean close) {
        try {
            Integer artId = 0;
            String codBarra = jTFCodBarra.getText();
            String nombre = jTFNombre.getText();

            String tipo = Character.toString(jCBTipo.getSelectedItem().toString().charAt(0));

            if (codBarra.trim().length() == 0) {
                showMsg("Por favor ingrese el código de barra");
                return;
            }
            
            if (jTFNombre.getText().trim().length() == 0){
                showMsg("Por favor ingrese el nombre del artículo");
                return;
            }

            if (this.jTFPrecioCompra.getText().trim().length() == 0) {
                if ("S".equalsIgnoreCase(tipo)) {
                    this.jTFPrecioCompra.setText("0");
                } else {
                    showMsg("Por favor ingrese el precio de compra");
                    return;
                }
            }

            if (this.jTFPrecioVenta.getText().trim().length() == 0) {
                showMsg("Por favor ingrese el precio de venta");
                return;
            }

            if (this.jTFInventario.getText().trim().length() == 0) {
                if ("S".equalsIgnoreCase(tipo)) {
                    this.jTFInventario.setText("0");
                } else {
                    showMsg("Por favor ingrese el inventario del artículo");
                    return;
                }
            }

            //BigDecimal valorIvaPC = BigDecimal.ZERO;
            BigDecimal precioCompra = new BigDecimal(this.jTFPrecioCompra.getText());
            boolean isIvaTrue = jCBIva.isSelected();

            /*
            if (isIvaTrue){
                valorIvaPC = precioCompra.multiply(new BigDecimal(CtesU.IVA)).setScale(2, RoundingMode.HALF_UP);
            }
             */
 /*
            BigDecimal precioCompraIva = BigDecimal.ZERO;
            
            if (jTFPrecioCompra.getText().trim().length()>0){
                precioCompraIva = new BigDecimal(jTFPrecioCompra.getText().trim()).add(valorIvaPC);
            }
                    
            BigDecimal precioCompraConIva = precioCompraIva;
             */
            BigDecimal precioVentaConIva = BigDecimal.ZERO;

            if (jTFPrecioVenta.getText().trim().length() > 0) {
                precioVentaConIva = new BigDecimal(jTFPrecioVenta.getText().trim());
            }

            BigDecimal precioMinConIva = BigDecimal.ZERO;

            if (jTFPrecioMinimo.getText().trim().length() > 0) {
                precioMinConIva = new BigDecimal(jTFPrecioMinimo.getText().trim());
            }

            BigDecimal inventario = BigDecimal.ZERO;
            if (jTFInventario.getText().trim().length() > 0) {
                inventario = new BigDecimal(jTFInventario.getText().trim());
            }

            boolean genCodbar = false;
            if (genCodbar) {
                codBarra = "CODGEN";
                
            }

            Categorias selectedCat = categorias.get(jCBCategoria.getSelectedIndex());

            FilaArticulo auxfilaArt = new FilaArticulo(artId, codBarra, nombre,
                    precioCompra, precioVentaConIva, precioMinConIva,
                    isIvaTrue, inventario, selectedCat.getCatName(), tipo,
                    selectedCat.getCatId(), selectedCat.getCatCaja());

            if (jCBProveedor.isEnabled()) {
                Clientes proveedor = (Clientes) jCBProveedor.getSelectedItem();
                if (proveedor != null) {
                    auxfilaArt.setProveedorId(proveedor.getCliId());
                }
            } else {
                auxfilaArt.setProveedorId(-1);
            }

            FilaArticulo filaArt = new FilaArticulo(artId,
                    codBarra,
                    nombre,
                    auxfilaArt.getPrecioCompra(),
                    auxfilaArt.getPrecioVentaSinIva(),
                    auxfilaArt.getPrecioMinSinIva(),
                    isIvaTrue,
                    inventario, selectedCat.getCatName(), tipo,
                    selectedCat.getCatId(), selectedCat.getCatCaja());

            filaArt.setProveedorId(auxfilaArt.getProveedorId());

            boolean valid = parentFrame.validateNewRow(filaArt);
            if (valid) {
                //Verificar codigo de barra y nombre de articulo
                if (!genCodbar && articulosController.yaExisteBarcode(codBarra)) {
                    showMsg("El código de barra:" + codBarra + " ya está registrado");
                    return;
                } else if (articulosController.yaExisteNombre(nombre)) {
                    showMsg("El artículo de nombre:" + nombre + " ya está registrado");
                    return;
                }

                filaArt.setFechaCaducidad(jTFFechaCadu.getText());
                articulosController.crearArticulo(filaArt, genCodbar);

                SmartFactMain.showSystemTrayMsg("El artículo fue registrado exitosamente");
                if (close) {
                    parentFrame.afterSuccessfulSaved();
                    setVisible(false);
                } else {
                    clearForm();
                }

            } else {
                showMsg("Los datos son incorrectos, verifica el codigo de barra, nombre del articulo ..");
            }
        } catch (Throwable ex) {
            showMsgError(ex);
        }
    }
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        logicaAdd(true);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jCBTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBTipoActionPerformed

    private void jTFCodBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCodBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCodBarraActionPerformed

    private void jTFCodBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCodBarraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String barcode = jTFCodBarra.getText();
            if (barcode.trim().length() > 0) {
                if (this.articulosController.yaExisteBarcode(barcode)) {
                    JOptionPane.showMessageDialog(null, "Ya esta registrado el artículo con código de barra:" + barcode + ", ingrese otro");
                } else {
                    jTFNombre.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_jTFCodBarraKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        jTFCodBarra.requestFocus();

    }//GEN-LAST:event_formWindowOpened

    private void jTFFechaCaduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFFechaCaduActionPerformed

    }//GEN-LAST:event_jTFFechaCaduActionPerformed

    private void jButtonSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSave1ActionPerformed
        logicaAdd(false);
    }//GEN-LAST:event_jButtonSave1ActionPerformed

    private void jTFNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNombreMousePressed


    }//GEN-LAST:event_jTFNombreMousePressed

    private void jTFNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTFPrecioVenta.requestFocus();
        }
    }//GEN-LAST:event_jTFNombreKeyPressed

    private void jTFPrecioVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioVentaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTFPrecioMinimo.requestFocus();
        }
    }//GEN-LAST:event_jTFPrecioVentaKeyPressed

    private void jTFPrecioMinimoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioMinimoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTFPrecioCompra.requestFocus();
        }
    }//GEN-LAST:event_jTFPrecioMinimoKeyPressed

    private void jTFPrecioCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrecioCompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTFInventario.requestFocus();
        }
    }//GEN-LAST:event_jTFPrecioCompraKeyPressed

    private void jTFInventarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFInventarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTFFechaCadu.requestFocus();
        }
    }//GEN-LAST:event_jTFInventarioKeyPressed

    private void jTFFechaCaduKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFFechaCaduKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            logicaAdd(false);
        }
    }//GEN-LAST:event_jTFFechaCaduKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSave1;
    private javax.swing.JComboBox<Categorias> jCBCategoria;
    private javax.swing.JCheckBox jCBIva;
    private javax.swing.JComboBox<Clientes> jCBProveedor;
    private javax.swing.JComboBox<String> jCBTipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTFCodBarra;
    private javax.swing.JFormattedTextField jTFFechaCadu;
    private javax.swing.JTextField jTFInventario;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFPrecioCompra;
    private javax.swing.JTextField jTFPrecioMinimo;
    private javax.swing.JTextField jTFPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
