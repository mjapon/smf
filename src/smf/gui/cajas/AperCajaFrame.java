/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smf.gui.cajas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import smf.controller.CajaJpaController;
import smf.entity.Caja;
import smf.gui.BaseFrame;
import smf.gui.SmartFactMain;
import smf.util.DatosUserSesion;
import smf.util.FechasUtil;
import smf.util.SelectingEditor;
import smf.util.datamodels.AperturaCajaDM;
import smf.util.datamodels.DefGSVCol;
import smf.util.datamodels.JTableColumn;
import smf.util.datamodels.rows.FilaDatosCaja;
/**
 *
 * @author mjapon
 */
public class AperCajaFrame extends BaseFrame {
    
    private CajaJpaController cajaCntrl;
    private AperturaCajaDM aperturaCajaDM;
    private List<JTableColumn> columns;
    private Date dia;
    private DatosUserSesion datosUserSesion;
    
    /**
     * Creates new form AperCajaFrame
     */
    public AperCajaFrame() {
        initComponents();
        
        cajaCntrl = new CajaJpaController(em);        
        initColumns();
        aperturaCajaDM = new AperturaCajaDM(columns, cajaCntrl);
        
        jTableMain.setModel(aperturaCajaDM);
        
        TableColumn colMonto = jTableMain.getColumnModel().getColumn( 1 );
        SelectingEditor selectingEditor = new SelectingEditor(new JTextField());
        colMonto.setCellEditor(selectingEditor);
        datosUserSesion = SmartFactMain.getDatosUserSesion();
        
    }

    public int initForm(){
        try{
            dia = new Date();
            dayName.setText(FechasUtil.getDayNameOfDate(dia));
            jTFFecha.setText( FechasUtil.format(dia) );

            if (cajaCntrl.existeCajaAbierta(dia, datosUserSesion.getTdvId())) {
                showMsg("Ya ha sido aperturada la caja para el día de hoy:" + FechasUtil.getDayNameOfDate(dia));
                setVisible(false);
                return -1;
            } else if (cajaCntrl.existeCajaAbiertaMenorFecha(dia, datosUserSesion.getTdvId())) {
                showMsg("No se puede abrir caja, existe una caja anterior que no ha sido cerrada aún, cierre esa caja para poder aperturar otra");
                setVisible(false);
                return -1;
            } else {
                //Cargar informacion de la caja anterior
                loadItems();
            }
            
            jTAObs.setText("");
            
            return 0;
        }
        catch(Throwable ex){
            showMsgError(ex);
        }
        
        return 0;
    }   
    
    public void initColumns(){
        columns = new ArrayList<>();
        columns.add(
                new JTableColumn<FilaDatosCaja>(
                        0, 
                        "CAJA", 
                        "nombre", 
                        String.class,
                        new DefGSVCol<FilaDatosCaja>() {
                            public Object getValueAt(FilaDatosCaja row, int rowIndex) {
                                return row.getNombreCaja();
                            }
                        }
                )
        );
        
        columns.add(
                new JTableColumn<FilaDatosCaja>(
                        1, 
                        "MONTO", 
                        "monto", 
                        BigDecimal.class,
                        new DefGSVCol<FilaDatosCaja>() {
                            public Object getValueAt(FilaDatosCaja row, int rowIndex) {
                                return row.getSaldoInicial();
                            }

                            @Override
                            public void setValueAt(FilaDatosCaja row, int rowIndex, Object value) {
                                try{
                                    row.setSaldoInicial(new BigDecimal(value.toString()));
                                }
                                catch(Throwable ex){
                                    row.setSaldoInicial(BigDecimal.ZERO);
                                }
                            }                            

                            @Override
                            public boolean isCellEditable(FilaDatosCaja row) {
                                return true;
                            }
                        }
                )
        );
        
    }
    
    public void loadItems(){
        Caja cajaAnt = cajaCntrl.getUltCajaCerrada( datosUserSesion.getTdvId() );
        aperturaCajaDM.setCajaAnt(cajaAnt);
        
        aperturaCajaDM.loadFromDataBase();
        aperturaCajaDM.fireTableDataChanged();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFFecha = new javax.swing.JFormattedTextField();
        dayName = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMain = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAObs = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(194, 100));
        setPreferredSize(new java.awt.Dimension(604, 500));
        setSize(new java.awt.Dimension(194, 400));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("APERTURA DE CAJA");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Fecha de apertura:");

        jTFFecha.setEditable(false);
        try {
            jTFFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTFFecha.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jTFFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFFechaActionPerformed(evt);
            }
        });

        dayName.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTFFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dayName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTFFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setPreferredSize(new java.awt.Dimension(462, 400));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SALDO INICIAL/ANTERIOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jTableMain.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        jTableMain.setRowHeight(25);
        jScrollPane1.setViewportView(jTableMain);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(497, 120));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Observación:");
        jPanel6.add(jLabel4, java.awt.BorderLayout.NORTH);

        jTAObs.setColumns(20);
        jTAObs.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTAObs.setRows(1);
        jTAObs.setTabSize(1);
        jTAObs.setPreferredSize(new java.awt.Dimension(300, 100));
        jScrollPane2.setViewportView(jTAObs);

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(5, 1));

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-save.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonGuardar);

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-close_pane_filled.png"))); // NOI18N
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCerrar);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFFechaActionPerformed

    }//GEN-LAST:event_jTFFechaActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        try{
            cajaCntrl.crearCaja(dia, jTAObs.getText(), aperturaCajaDM.getItems(), datosUserSesion.getTdvId());
            String dayName = FechasUtil.getDayNameOfDate(dia);
            SmartFactMain.showSystemTrayMsg("CAJA APERTURA PARA EL DIA DE HOY:" + dayName);
            setVisible(false);
        }
        catch(Throwable ex){
            showMsgError(ex);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dayName;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAObs;
    private javax.swing.JFormattedTextField jTFFecha;
    private javax.swing.JTable jTableMain;
    // End of variables declaration//GEN-END:variables
}
