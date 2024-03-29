/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smf.gui.tickets;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.SwingUtilities;
import smf.controller.ArticulosJpaController;
import smf.controller.CajaJpaController;
import smf.controller.ClientesJpaController;
import smf.controller.CtesJpaController;
import smf.controller.FacturasJpaController;
import smf.controller.SecuenciasJpaController;
import smf.controller.TicketsJpaController;
import smf.entity.Caja;
import smf.entity.Clientes;
import smf.gui.BaseFrame;
import smf.gui.SmartFactMain;
import smf.util.*;
import smf.util.datamodels.ProveedoresListModel;
import smf.util.datamodels.rows.TicketRow;

/**
 *
 * @author mjapon
 */
public class NewTicketFrame extends BaseFrame {
    
    private TicketsJpaController controller;
    private SecuenciasJpaController seccontroller;
    private ClientesJpaController clientesCntrl;
    private ArticulosJpaController articulosCntrl;
    private CtesJpaController ctesJpaController;
    private CajaJpaController cajaJpaController;    
    private Integer cliCodigo;
    private TicketsFrame ticketsFrame; 
    private Map<Character,ItemFusay> mapArticulos;
    private FacturasJpaController facturasCntrl;
    
    private ProveedoresListModel artsListModel;
    private DatosUserSesion datosUserSesion;

    /**
     * Creates new form NewTicketFrame
     */
    public NewTicketFrame() {
        initComponents();
        
        controller  = new TicketsJpaController(em);
        seccontroller = new SecuenciasJpaController(em);
        clientesCntrl = new ClientesJpaController(em);
        ctesJpaController = new CtesJpaController(em);
        articulosCntrl = new ArticulosJpaController(em);
        facturasCntrl = new FacturasJpaController(em);
        cajaJpaController = new CajaJpaController(em);

        datosUserSesion = SmartFactMain.getDatosUserSesion();

        initForm();
        
    }
    
     public boolean checkAperturaCaja(){
        boolean resultAperturaCaja = false;
        try{
            Date today = new Date();
            if (!cajaJpaController.existeCajaAbierta(today, datosUserSesion.getTdvId())) {

                if (cajaJpaController.existeCajaAbiertaMenorFecha(today,datosUserSesion.getTdvId())) {
                    Caja caja = cajaJpaController.getCajaAbiertaMenorFecha(today,datosUserSesion.getTdvId());
                    if (caja != null) {
                        showMsg(" Existe una caja anterior no cerrada (fecha:" + FechasUtil.format(caja.getCjFecaper()) + " ), debe cerrar esta caja antes de empezar el día ");
                    } else {
                        showMsg(" Existe una caja anterior no cerrada, debe cerrar esta caja antes de empezar el dia ");
                    }
                    resultAperturaCaja = false;
                } else {
                    showMsg("Primero debe hacer apertura de caja para empezar a vender");
                }
            } else {
                resultAperturaCaja = true;
            }
        }
        catch(Throwable ex){
            showMsgError(ex);
        }
        return resultAperturaCaja;
    }
    
    

    public void initForm(){
        jTFFecha.setText( FechasUtil.getFechaActual() );
        
        Integer currentSec =  seccontroller.getSecuenciaValue("TIKSEC");
        if (currentSec != null){
            jTFNroTicket.setText(currentSec.toString());
        }
        else{
            jTFNroTicket.setText("1");
        }
        
        cliCodigo = 0;
        jTFMonto.setText("1.0");
        
        jTFCi.setText("");
        jTFNomapel.setText("");
        jTFDireccion.setText("");
        
        /*
        try{
            mapArticulos = articulosCntrl.listarTiposFusay();
        }
        catch(Throwable ex){
            showMsgError(ex);
            logError(ex);
        }
        */
        
    }
    
    public void loadArticulos(){
        try{
            List<Object[]> reslist = articulosCntrl.listarSelectItems();
            for(Object[] item: reslist){
                Integer idArt =  (Integer)item[0];
                String codArts = (String)item[1];
                
                
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

        jPanel1 = new javax.swing.JPanel();
        jButtonGuardr1 = new javax.swing.JButton();
        jButtonGuardr = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAObs = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFNroTicket = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFCi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFNomapel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTFDireccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTFTelf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFMonto = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jCBKambo = new javax.swing.JCheckBox();
        jCBCeremonia = new javax.swing.JCheckBox();
        jCBTemascal = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(5, 1));

        jButtonGuardr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-search.png"))); // NOI18N
        jButtonGuardr1.setText("Buscar");
        jButtonGuardr1.setToolTipText("Buscar cliente por cedula");
        jButtonGuardr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardr1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGuardr1);

        jButtonGuardr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-save.png"))); // NOI18N
        jButtonGuardr.setText("Guardar");
        jButtonGuardr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardrActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGuardr);

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-close_pane_filled.png"))); // NOI18N
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCerrar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.EAST);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("Observación:");
        jPanel5.add(jLabel7, java.awt.BorderLayout.NORTH);

        jTAObs.setColumns(20);
        jTAObs.setRows(5);
        jScrollPane1.setViewportView(jTAObs);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5, java.awt.BorderLayout.SOUTH);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(7, 2));

        jLabel2.setText("Fecha:");
        jPanel4.add(jLabel2);

        jTFFecha.setEditable(false);
        jPanel4.add(jTFFecha);

        jLabel3.setText("Nro Ticket:");
        jPanel4.add(jLabel3);
        jPanel4.add(jTFNroTicket);

        jLabel4.setText("CI/RUC:");
        jPanel4.add(jLabel4);

        jTFCi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFCiFocusLost(evt);
            }
        });
        jTFCi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFCiKeyReleased(evt);
            }
        });
        jPanel4.add(jTFCi);

        jLabel5.setText("Nombres y Apellidos:");
        jPanel4.add(jLabel5);
        jPanel4.add(jTFNomapel);

        jLabel9.setText("Dirección:");
        jPanel4.add(jLabel9);
        jPanel4.add(jTFDireccion);

        jLabel10.setText("Telf/Movil:");
        jPanel4.add(jLabel10);
        jPanel4.add(jTFTelf);

        jLabel6.setText("Monto:");
        jPanel4.add(jLabel6);
        jPanel4.add(jTFMonto);

        jPanel6.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Servicios"))));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 93));
        jPanel7.setLayout(new java.awt.GridLayout(3, 1));

        jCBKambo.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jCBKambo.setText("Kambo");
        jPanel7.add(jCBKambo);

        jCBCeremonia.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jCBCeremonia.setText("Ceremonia");
        jPanel7.add(jCBCeremonia);

        jCBTemascal.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jCBTemascal.setText("Temascal");
        jPanel7.add(jCBTemascal);

        jPanel6.add(jPanel7, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("CREAR TICKET");
        jPanel3.add(jLabel1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    public void buscarCliente(){
        try{
            if (this.jTFCi.getText().trim().length()>2){
                Clientes cliente =  clientesCntrl.findByCi(this.jTFCi.getText().trim());
                if (cliente != null){
                    this.jTFNomapel.setText( cliente.getCliNombres() );
                    this.jTFDireccion.setText( cliente.getCliDir() );
                    this.jTFTelf.setText(cliente.getCliTelf());
                    this.cliCodigo = cliente.getCliId();
                }
                else{
                    this.jTFNomapel.setText( "" );
                    this.jTFDireccion.setText( "" );
                    this.jTFTelf.setText( "" );
                }
            }
            
        }
        catch(Throwable ex){
            showMsgError(ex);
        }        
    }
    
    private void jButtonGuardr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardr1ActionPerformed
        buscarCliente();
    }//GEN-LAST:event_jButtonGuardr1ActionPerformed

    private void jButtonGuardrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardrActionPerformed
        try{            
            //Validar que se ingrese el numero de cedula o el nombre del paciente
            if (StringUtil.isEmpty(this.jTFCi.getText())
                    && StringUtil.isEmpty(this.jTFNomapel.getText())  ){
                showMsg("Ingresa el nombre o el número de cédula del paciente");
                return;
            }
            else if(StringUtil.isEmpty(this.jTFMonto.getText())){
                showMsg("Ingresa el precio del ticket");
            }
            
            TicketRow ticketRow = new TicketRow();

            ticketRow.setCliId(this.cliCodigo);
            ticketRow.setCliCi(this.jTFCi.getText().trim());
            ticketRow.setCliNombres(this.jTFNomapel.getText().trim());
            ticketRow.setCliDireccion(this.jTFDireccion.getText());
            ticketRow.setCliDireccion(this.jTFDireccion.getText());
            ticketRow.setCliTelf(this.jTFTelf.getText());
            
            //ticketRow.setFechaCreacion(new Date());
            
            if (this.jTFMonto.getText().contains(",")){
                this.jTFMonto.setText(this.jTFMonto.getText().replaceAll(",", "."));
            }
            
            
            ticketRow.setMonto(new BigDecimal(this.jTFMonto.getText()));
            ticketRow.setTkNro( Integer.valueOf(this.jTFNroTicket.getText()) );
            ticketRow.setTkObs( this.jTAObs.getText() );            
            
            boolean isCheckKambo = jCBKambo.isSelected();
            boolean isCheckCeremonia = jCBCeremonia.isSelected();
            boolean isCheckTemazcal = jCBTemascal.isSelected();
            
            String servicios = String.format("%s:%d,%s:%d,%s:%d",
                    "K",isCheckKambo?1:0,
                    "C",isCheckCeremonia?1:0,
                    "T",isCheckTemazcal?1:0
                    );
            
            ticketRow.setTkServicios(servicios);
            
            Integer factId = facturasCntrl.crearTicket(ticketRow, datosUserSesion.getTdvId());
            ticketRow.setFactId(factId);
            
            Integer ticketid = controller.crear(ticketRow);

            //if (showConfirmMsg("Registro Satisfactorio, ¿Desea Imprimir?")){                    
                logicaImprimir(ticketid);
            //}        
            
            ticketsFrame.logicaBuscar();
            setVisible(false);
        }
        catch(Throwable ex){
            showMsgError(ex);
        }
        
        setVisible(false);
        
    }//GEN-LAST:event_jButtonGuardrActionPerformed

    private void jTFCiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCiKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarCliente();
        }
    }//GEN-LAST:event_jTFCiKeyReleased

    private void jTFCiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCiFocusLost
        buscarCliente();
    }//GEN-LAST:event_jTFCiFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        SwingUtilities.invokeLater(() -> {
            this.jTFCi.requestFocus();
        });
        
    }//GEN-LAST:event_formWindowOpened

    public void logicaImprimir(Integer ticketId){
        try{
            //String textToPrint = controller.getTicketTxT(ticketid);
            PrintFactUtil.imprimirTicketJasper(ctesJpaController, ticketId);
        }
        catch(Throwable ex){
            showMsgError(ex);
        }        
    }

    public TicketsFrame getTicketsFrame() {
        return ticketsFrame;
    }

    public void setTicketsFrame(TicketsFrame ticketsFrame) {
        this.ticketsFrame = ticketsFrame;
    }    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGuardr;
    private javax.swing.JButton jButtonGuardr1;
    private javax.swing.JCheckBox jCBCeremonia;
    private javax.swing.JCheckBox jCBKambo;
    private javax.swing.JCheckBox jCBTemascal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAObs;
    private javax.swing.JTextField jTFCi;
    private javax.swing.JTextField jTFDireccion;
    private javax.swing.JTextField jTFFecha;
    private javax.swing.JTextField jTFMonto;
    private javax.swing.JTextField jTFNomapel;
    private javax.swing.JTextField jTFNroTicket;
    private javax.swing.JTextField jTFTelf;
    // End of variables declaration//GEN-END:variables
}
