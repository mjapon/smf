/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smf.gui.facte;


import java.math.BigDecimal;
import smf.gui.BaseFrame;
import smf.gui.merc.unid.IListenerSelectUnity;
import smf.util.NumbersUtil;
import smf.util.StringUtil;
import smf.util.datamodels.rows.FilaFactura;

/**
 *
 * @author mjapon
 */
public class DescuentosFrame extends BaseFrame {

    private FilaFactura filaFactura;
    private IListenerSelectUnity listener;
    /**
     * Creates new form DescuentosFrame
     */
    public DescuentosFrame(FilaFactura fila) {
        initComponents();
        this.filaFactura = fila;
        
        loadInfo();
        updateDescuento();
    }
    
    public void loadInfo(){
        
        jLabelArtName.setText(filaFactura.getNombreArt() );
        jTFPrecioVenta.setText( NumbersUtil.round2(filaFactura.getPrecioUnitario()).toPlainString() );
        jTFPrecioCompra.setText( NumbersUtil.round2(filaFactura.getPrecioCompra()).toPlainString() );
        jTFPrecioMin.setText( NumbersUtil.round2(filaFactura.getPrecioMinimo()).toPlainString() );
        
        FilaFactura filaSinDesc = filaFactura.clonar();
        filaSinDesc.setDescuento(BigDecimal.ZERO);
        filaSinDesc.setDescuentoPorc(BigDecimal.ZERO);
        filaSinDesc.updateTotales();
        
        
        BigDecimal descuentoSugerido = NumbersUtil.round2(filaFactura.getPrecioUnitario().subtract(filaFactura.getPrecioMinimo()));
        jTFDescSugerido.setText( descuentoSugerido.toPlainString() );
        jTFDescAplicado.setText( this.filaFactura.getDescuento().toPlainString() );
        
        BigDecimal precioSinDesc = filaSinDesc.getTotal();
        jTFPrecioSinDesc.setText( NumbersUtil.round2(precioSinDesc).toPlainString() );
        
    }
    
    public void updateDescuento(){
        try{
            System.out.println("Descuecto calculado");
            FilaFactura newFilaFactura = filaFactura.clonar();
            String descaplicadotext = jTFDescAplicado.getText();
            BigDecimal descuentoAplicado = BigDecimal.ZERO;
            jTFPrecioConDesc.setText(NumbersUtil.round2(newFilaFactura.getTotal()).toPlainString()) ;
            if (StringUtil.isNotEmpty(descaplicadotext)){
                descuentoAplicado = new BigDecimal(descaplicadotext);
                newFilaFactura.setDescuento(descuentoAplicado);
                newFilaFactura.updateTotales();
                jTFPrecioConDesc.setText(NumbersUtil.round2(newFilaFactura.getTotal()).toPlainString()) ;
            }
        }
        catch(Throwable ex){
            showMsgError(ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabelArtName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFPrecioCompra = new javax.swing.JTextField();
        jTFPrecioMin = new javax.swing.JTextField();
        jTFPrecioVenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTFDescSugerido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFDescAplicado = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTFPrecioSinDesc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFPrecioConDesc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jBtnOK = new javax.swing.JButton();
        jBtnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("DESCUENTOS:");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Artículo"));

        jLabelArtName.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabelArtName.setText("artName");

        jLabel2.setText("Precio Compra:");

        jLabel3.setText("Precio Venta:");

        jLabel4.setText("Precio Min:");

        jTFPrecioCompra.setEditable(false);
        jTFPrecioCompra.setEnabled(false);

        jTFPrecioMin.setEditable(false);
        jTFPrecioMin.setEnabled(false);

        jTFPrecioVenta.setEditable(false);
        jTFPrecioVenta.setEnabled(false);

        jLabel13.setText("Descuento Sugerido:");

        jTFDescSugerido.setEditable(false);
        jTFDescSugerido.setEnabled(false);
        jTFDescSugerido.setPreferredSize(new java.awt.Dimension(10, 40));

        jLabel5.setText("Descuento Aplicado:");

        jTFDescAplicado.setPreferredSize(new java.awt.Dimension(10, 40));
        jTFDescAplicado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFDescAplicadoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelArtName)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFPrecioMin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFDescAplicado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFDescSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelArtName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTFDescSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTFDescAplicado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFPrecioMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setText("Precio Total Sin Descuentos");

        jTFPrecioSinDesc.setEditable(false);
        jTFPrecioSinDesc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTFPrecioSinDesc.setDisabledTextColor(new java.awt.Color(0, 153, 0));
        jTFPrecioSinDesc.setEnabled(false);
        jTFPrecioSinDesc.setPreferredSize(new java.awt.Dimension(10, 40));

        jLabel12.setText("Precio Total Con Descuentos");

        jTFPrecioConDesc.setEditable(false);
        jTFPrecioConDesc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTFPrecioConDesc.setForeground(new java.awt.Color(51, 153, 0));
        jTFPrecioConDesc.setDisabledTextColor(new java.awt.Color(51, 153, 0));
        jTFPrecioConDesc.setEnabled(false);
        jTFPrecioConDesc.setPreferredSize(new java.awt.Dimension(10, 40));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFPrecioSinDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFPrecioConDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPrecioSinDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPrecioConDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(4, 1));

        jBtnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-checked.png"))); // NOI18N
        jBtnOK.setText("Aceptar");
        jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOKActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnOK);

        jBtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-close_pane_filled.png"))); // NOI18N
        jBtnClose.setText("Cancelar");
        jBtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCloseActionPerformed(evt);
            }
        });
        jPanel3.add(jBtnClose);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jBtnCloseActionPerformed

    private void jTFDescAplicadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDescAplicadoKeyReleased
        updateDescuento();
    }//GEN-LAST:event_jTFDescAplicadoKeyReleased

    private void jBtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOKActionPerformed
        BigDecimal descuentoAplicado = BigDecimal.ZERO;
        try{
            descuentoAplicado = new BigDecimal(jTFDescAplicado.getText());
        }
        catch(Throwable ex){
            logError(ex);
        }
        filaFactura.setDescuento( descuentoAplicado );
        
        listener.doChangeDescuento(filaFactura);
        setVisible(false);
        
    }//GEN-LAST:event_jBtnOKActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        jTFDescAplicado.requestFocus();
        jTFDescAplicado.selectAll();
        
    }//GEN-LAST:event_formWindowOpened

    public IListenerSelectUnity getListener() {
        return listener;
    }

    public void setListener(IListenerSelectUnity listener) {
        this.listener = listener;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnClose;
    private javax.swing.JButton jBtnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelArtName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTFDescAplicado;
    private javax.swing.JTextField jTFDescSugerido;
    private javax.swing.JTextField jTFPrecioCompra;
    private javax.swing.JTextField jTFPrecioConDesc;
    private javax.swing.JTextField jTFPrecioMin;
    private javax.swing.JTextField jTFPrecioSinDesc;
    private javax.swing.JTextField jTFPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
