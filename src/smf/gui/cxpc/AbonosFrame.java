/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smf.gui.cxpc;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import smf.controller.ArticulosJpaController;
import smf.controller.CatCajasJpaController;
import smf.controller.FacturasJpaController;
import smf.controller.MovtransaccJpaController;
import smf.entity.Facturas;
import smf.gui.BaseFrame;
import smf.gui.SmartFactMain;
import smf.util.DatosUserSesion;
import smf.util.datamodels.rows.FilaCXCP;
import smf.util.NumbersUtil;
import smf.util.datamodels.DetallesFactDataModel;
import smf.util.datamodels.rows.FilaCatCaja;
import smf.util.form.AbonoForm;

/**
 *
 * @author mjapon
 */
public class AbonosFrame extends BaseFrame {
    
    private FilaCXCP fila;
    private CuentasXCBPFrame parentFrame;
    private MovtransaccJpaController controller;
    private ArticulosJpaController articulosJpaController;
    private CatCajasJpaController catCajaJpaController;
    private Integer tra_codigo;//3 cuentas x cobrar, 4-cuentas x pagar
    private DetallesFactDataModel dataModel;
    private FacturasJpaController facturaController;
    private DatosUserSesion datosUserSesion;

    /**
     * Creates new form AbonosFrame
     */
    public AbonosFrame(FilaCXCP fila, Integer tra_codigo) {
        super();
        initComponents();
        this.tra_codigo = tra_codigo;
        this.fila = fila;        
        this.jTFValorPend.setText( NumbersUtil.round(fila.getDeuda(), 2).toPlainString() );
        this.jTFValorPend.setEditable(false);
        
        controller = new MovtransaccJpaController(em);
        catCajaJpaController = new CatCajasJpaController(em);
        facturaController = new FacturasJpaController(em);
        articulosJpaController = new ArticulosJpaController(em);

        this.datosUserSesion = SmartFactMain.getDatosUserSesion();
        
        dataModel = new DetallesFactDataModel(this.tra_codigo, articulosJpaController);
        
        jLabelRefer.setText(fila.getReferente());
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de la factura Nro:" + fila.getNumFactura() ));
        
        loadCajas(); 
        loadDetallesFact();
    }
    
    public void loadDetallesFact(){
        
        try{
            dataModel = new DetallesFactDataModel(this.tra_codigo, this.articulosJpaController);
            List<Object[]> detalles = facturaController.listarDetalles(this.fila.getCodFactura(),true);
            Facturas factura = facturaController.buscar(this.fila.getCodFactura());

            dataModel.loadItems(detalles);

            float[] widths = {10.0f, 30.0f,5.0f,10.0f,10.0f,10.0f,10.0f,5.0f,10.0f};
            dataModel.setupWidths(widths, jTableMain);

            dataModel.setJtable(jTableMain);

            dataModel.fireTableDataChanged(); 
            
            jTableMain.setModel(dataModel);
            jTableMain.updateUI();
            
            
            
             List<Object[]> pagosList  = facturaController.getPagos(this.fila.getCodFactura());
        
        jTFEfectivo.setText("0.0");
        jTFCredito.setText("0.0");
        jTFTotalFact.setText( NumbersUtil.round2ToStr(factura.getFactTotal()) );
        
        if (pagosList != null){
            for (Object[] filaPago: pagosList){
                BigDecimal monto = (BigDecimal)filaPago[1]; 
                BigDecimal saldo = (BigDecimal)filaPago[2]; 
                //Integer spId =  (Integer)filaPago[4];
                Integer fpId =  (Integer)filaPago[5];
                String observ  = (String)filaPago[3];
                String estadoPago = (String)filaPago[7];

                if (fpId == 1){
                    jTFEfectivo.setText( NumbersUtil.round(monto, 2).toPlainString() );
                }
                else if (fpId == 2){
                   
                    jTFCredito.setText(NumbersUtil.round(monto, 2).toPlainString());
                    
                    String texto = NumbersUtil.round(saldo, 2).toPlainString()+" "+ estadoPago;
                  
                    jTFValorPendPie.setText( texto );
                    jTextAreaObs.setText(observ);
                }
            }
            
        }
        
        }
        catch(Throwable ex){
            showMsgError(ex);
        }
    }

    public void loadCajas(){
        List<FilaCatCaja> catCajasList = catCajaJpaController.listForGrid();
        
        FilaCatCaja[] cajasv = new FilaCatCaja[catCajasList.size()];
        int i = 0;
        for (FilaCatCaja fila: catCajasList){
            cajasv[i] = fila;
            i++;
        }
        
        ComboBoxModel cmbmodel = new DefaultComboBoxModel(cajasv);
        
        jCBCajaId.setModel(cmbmodel );
        jCBCajaId.updateUI();
        
        jCBCajaId.addItemListener(e -> {
            FilaCatCaja c = (FilaCatCaja) e.getItem();

          });
        
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFValorPend = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFValorAbono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObs = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jCBCajaId = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabelRefer = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMain = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTFTotalFact = new javax.swing.JTextField();
        jTFEfectivo = new javax.swing.JTextField();
        jTFCredito = new javax.swing.JTextField();
        jTFValorPendPie = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("REGISTRAR ABONO");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.GridLayout(4, 1));

        jButtonGuardar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-save.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonGuardar);

        jButtonCerrar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-close_pane_filled.png"))); // NOI18N
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCerrar);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("VALOR PENDIENTE:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("MONTO DEL ABONO:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("OBSERVACIÓN:");

        jTextAreaObs.setColumns(20);
        jTextAreaObs.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObs);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("CAJA AFECTADA:");

        jCBCajaId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GENERAL", "CHANCADO", "SERVICIOS PROF." }));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Referente:");

        jLabelRefer.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelRefer.setText("Referente:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFValorPend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFValorAbono, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jCBCajaId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelRefer, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jTFValorPend, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabelRefer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTFValorAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCBCajaId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2);

        jPanel5.setPreferredSize(new java.awt.Dimension(431, 200));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de la factura"));
        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jTableMain.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jTableMain.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTableMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableMain.setRowHeight(20);
        jScrollPane2.setViewportView(jTableMain);

        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new java.awt.GridLayout(2, 4));

        jLabel6.setText("TOTAL FACT:");
        jPanel6.add(jLabel6);

        jLabel7.setText("EFECTIVO:");
        jPanel6.add(jLabel7);

        jLabel8.setText("CRÉDITO:");
        jPanel6.add(jLabel8);

        jLabel9.setText("VALOR PEND:");
        jPanel6.add(jLabel9);

        jTFTotalFact.setEditable(false);
        jTFTotalFact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTFTotalFact);

        jTFEfectivo.setEditable(false);
        jTFEfectivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTFEfectivo);

        jTFCredito.setEditable(false);
        jTFCredito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTFCredito);

        jTFValorPendPie.setEditable(false);
        jTFValorPendPie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(jTFValorPendPie);

        jPanel5.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jPanel4.add(jPanel5);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        
        try{            
            Integer pagoId = this.fila.getCodPago();        
            BigDecimal monto = new BigDecimal(this.jTFValorAbono.getText());
            String observacion = this.jTextAreaObs.getText();
            Integer factId = this.fila.getCodFactura();
            
            //0-general, 1-chancado, 2-servicios prof
            //Integer cajaId = this.jCBCajaId.getSelectedItem();
            
            FilaCatCaja catCaja = (FilaCatCaja)this.jCBCajaId.getSelectedItem();
            AbonoForm form = new AbonoForm(pagoId, monto, observacion, factId, this.tra_codigo, catCaja.getCatCajaId());
        
            controller.guardarAbono(form, datosUserSesion.getTdvId());
            this.parentFrame.logicaBuscar();
            
            BigDecimal deuda = new BigDecimal(this.jTFValorPend.getText());
            
            if (monto.compareTo(deuda)==0){
                JOptionPane.showMessageDialog(null, "Abono Registrado, La Factura ha sido CANCELADA en su totalidad");
            }
            else{
                JOptionPane.showMessageDialog(null, "Abono Registrado, queda un saldo pendiente aún por cancelar");
            }            
            setVisible(false);
        }
        catch(Throwable ex){
            System.out.println("Error al tratar de registrar el abono:"+ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar el abono:"+ex.getMessage());
        }
        
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTFValorAbono.requestFocus();
        
    }//GEN-LAST:event_formWindowOpened

    public CuentasXCBPFrame getParentFrame() {
        return parentFrame;
    }

    public void setParentFrame(CuentasXCBPFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jCBCajaId;
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
    private javax.swing.JLabel jLabelRefer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFCredito;
    private javax.swing.JTextField jTFEfectivo;
    private javax.swing.JTextField jTFTotalFact;
    private javax.swing.JTextField jTFValorAbono;
    private javax.swing.JTextField jTFValorPend;
    private javax.swing.JTextField jTFValorPendPie;
    private javax.swing.JTable jTableMain;
    private javax.swing.JTextArea jTextAreaObs;
    // End of variables declaration//GEN-END:variables
}
