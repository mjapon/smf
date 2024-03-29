/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smf.gui;

import org.jfree.chart.ChartPanel;
import smf.controller.*;
import smf.entity.Empresa;
import smf.entity.Ttpdv;
import smf.util.DatosUserSesion;
import smf.util.graphics.CodBarraVentasUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author mjapon
 */
public class HomeFrame extends BaseFrame {

    private SmartFactMain appMain;
    private EmpresaJpaController empresaController;
    private FacturasJpaController facturasController;
    private TtpdvJpaController ttpdvJpaController;
    private DatosUserSesion datosUserSesion;

    /**
     * Creates new form HomeFrame
     */
    public HomeFrame() {
        super();
        initComponents();
        empresaController = new EmpresaJpaController(em);
        facturasController = new FacturasJpaController(em);
        ttpdvJpaController = new TtpdvJpaController(em);
        datosUserSesion = SmartFactMain.getDatosUserSesion();
        loadDatosEmpresa();
        loadLogo();
        loadBGImage();
        loadInfoResumen();
    }

    public void setFarmaAppMain(SmartFactMain appMain) {
        this.appMain = appMain;
    }


    public void updateGraphics() {
        buildGraphics();
    }

    public void loadLogo() {
        try {
            Empresa empresa = empresaController.getDatosEmpresa();
            String path = null;
            if (empresa != null && empresa.getEmpLogo() != null && empresa.getEmpLogo().trim().length() > 0) {
                path = empresa.getEmpLogo().trim();
            }

            Image img = null;
            if (path != null) {
                img = ImageIO.read(new File(path));
            } else {
                img = ImageIO.read(SmartFactMain.class.getResource("/smf/gui/icons/deftimg.jpg"));
            }

            Image dimg = img.getScaledInstance(jLabelLogo.getWidth(), jLabelLogo.getHeight(),
                    Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            jLabelLogo.setIcon(imageIcon);
        } catch (Throwable e) {
            logError(e);
        }
    }

    public void loadDatosEmpresa() {
        try {
            Empresa empresa = empresaController.getDatosEmpresa();

            Ttpdv ttpdv = ttpdvJpaController.findById(datosUserSesion.getTdvId());
            if (ttpdv == null) {
                System.out.println("Error no pude leer el punto de emision asignado");
            }

            if (empresa != null) {
                jLabelNombreEmpresa.setText(empresa.getNombreComercial() + "         PUNTO:"+ttpdv.getTdvNum());
                jLabelRucEmpresa.setText(empresa.getEmpRuc());
                jLabelRazonSocial.setText(empresa.getEmpRazonsocial());
                jLabelDireccion.setText(empresa.getEmpDireccion());
            }
        } catch (Throwable ex) {
            logError(ex);
        }
    }

    public void loadBGImage() {
        /*
        try {
            URL resource = SmartFactMain.class.getResource("fondoveterinaria.jpg");
            BufferedImage img = ImageIO.read(resource);
            Image dimg = img.getScaledInstance(getWidth(), getHeight(),
            Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            setContentPane(new JLabel(imageIcon));
        } catch (Throwable e) {
            logError(e);
        }
        */
    }

    public void buildGraphics() {
        try {
            Map<Integer, BigDecimal> mapVentas = facturasController.getVentasSemana();
            ChartPanel chartPanel = CodBarraVentasUtil.getChart("", mapVentas);
            jPanelVentSem.removeAll();
            jPanelVentSem.add(chartPanel);
            this.pack();
        } catch (Throwable ex) {
            showMsgError(ex, "Error al tratar de crear gráfica de ventas");
        }
    }

    public void loadInfoResumen() {
        try {
            ResumenEmpCntrl cntrl = new ResumenEmpCntrl(em);
            Map<String, BigDecimal> resultMap = cntrl.getResumen();

            BigDecimal ninv = resultMap.get("INV");
            BigDecimal ninvB = resultMap.get("INV_B");
            BigDecimal ninvS = resultMap.get("INV_S");

            BigDecimal nartXExp = resultMap.get("ARTXEXP");
            BigDecimal nartExp = resultMap.get("ARTEXP");

            jLabelArtExp.setText(String.valueOf(nartExp.intValue()));
            jLabelArtXExp.setText(String.valueOf(nartXExp.intValue()));

            jLabelNumArt.setText(String.valueOf(ninvB.intValue()));
            jLabelNumServ.setText(String.valueOf(ninvS.intValue()));
        } catch (Throwable ex) {
            logError(ex);
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
        jLabelNombreEmpresa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelRucEmpresa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelRazonSocial = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanelResumen = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelNumArt = new javax.swing.JLabel();
        jLabelNumServ = new javax.swing.JLabel();
        jLabelArtExp = new javax.swing.JLabel();
        jLabelArtXExp = new javax.swing.JLabel();
        jPanelVentas = new javax.swing.JPanel();
        jPanelVentSem = new javax.swing.JPanel();
        jPanelInv = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonFact = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelNombreEmpresa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelNombreEmpresa.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ruc:");

        jLabelRucEmpresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRucEmpresa.setText("RUC:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Razon Social:");

        jLabelRazonSocial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRazonSocial.setText("RUC:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Dirección:");

        jLabelDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDireccion.setText("RUC:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelNombreEmpresa)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelRucEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelNombreEmpresa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabelRucEmpresa))
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabelRazonSocial))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabelDireccion))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        jPanelResumen.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen"));

        jLabel4.setText("Artículos registrados:");

        jLabel5.setText("Servicios registrados");

        jLabel6.setText("Artículos expirados:");

        jLabel7.setText("Artículos por expirar:");

        jLabelNumArt.setText("jLabel8");

        jLabelNumServ.setText("jLabel8");

        jLabelArtExp.setText("jLabel8");

        jLabelArtXExp.setText("jLabel8");

        javax.swing.GroupLayout jPanelResumenLayout = new javax.swing.GroupLayout(jPanelResumen);
        jPanelResumen.setLayout(jPanelResumenLayout);
        jPanelResumenLayout.setHorizontalGroup(
                jPanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelResumenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelResumenLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelNumArt))
                                        .addGroup(jPanelResumenLayout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelArtXExp))
                                        .addGroup(jPanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelResumenLayout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelArtExp))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelResumenLayout.createSequentialGroup()
                                                        .addComponent(jLabel5)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelNumServ))))
                                .addContainerGap(249, Short.MAX_VALUE))
        );
        jPanelResumenLayout.setVerticalGroup(
                jPanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelResumenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabelNumArt))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabelNumServ))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabelArtExp))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabelArtXExp))
                                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel3.add(jPanelResumen);

        jPanelVentas.setLayout(new java.awt.GridLayout(1, 2));

        jPanelVentSem.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventas de la semana"));
        jPanelVentSem.setLayout(new java.awt.BorderLayout());
        jPanelVentas.add(jPanelVentSem);

        jPanelInv.setLayout(new java.awt.BorderLayout());
        jPanelVentas.add(jPanelInv);

        jPanel3.add(jPanelVentas);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setMinimumSize(new java.awt.Dimension(200, 441));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 441));
        jPanel4.setLayout(new java.awt.GridLayout(6, 2));

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/Purchase Order_32px.png"))); // NOI18N
        jButton1.setText("Facturar");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jButtonFact.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonFact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-view_details.png"))); // NOI18N
        jButtonFact.setText("Facturas");
        jButtonFact.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFactActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonFact);

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/Cash Counter_32px.png"))); // NOI18N
        jButton3.setText("Abrir Caja");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jButton8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-request_money_1.png"))); // NOI18N
        jButton8.setText("Cuentas por cobrar");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8);

        jButton6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/Cash Counter_close32px.png"))); // NOI18N
        jButton6.setText("Cerrar Caja");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);

        jButton9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-initiate_money_transfer.png"))); // NOI18N
        jButton9.setText("Cuentas por pagar");
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9);

        jButton7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/Data Sheet_32px.png"))); // NOI18N
        jButton7.setText("Inventarios");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);

        jButton11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/User_32px.png"))); // NOI18N
        jButton11.setText("Clientes");
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11);

        jButton13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/Manager_32px.png"))); // NOI18N
        jButton13.setText("Proveedores");
        jButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13);

        jButton12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/Increase_32px.png"))); // NOI18N
        jButton12.setText("Reportes");
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton12);

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/icons8-giving_tickets.png"))); // NOI18N
        jButton2.setText("Tickets");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        jButton10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smf/gui/icons/Exit Sign_32px.png"))); // NOI18N
        jButton10.setText("Sair");
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton10);

        jPanel2.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        appMain.showNewFacturaFrame();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        appMain.showAperturaCajaNewVer();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        appMain.showCierreCajaNV();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        appMain.showInventarios();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        appMain.showCuentasXCobrar();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        appMain.showCuentasXPagar();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        appMain.exitApp();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        appMain.showClientesFrame();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        appMain.showReportesFrame();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        appMain.showProveedoresFrame();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        appMain.showTicketsFrame();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFactActionPerformed
        appMain.showListaVentas();
    }//GEN-LAST:event_jButtonFactActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonFact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelArtExp;
    private javax.swing.JLabel jLabelArtXExp;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombreEmpresa;
    private javax.swing.JLabel jLabelNumArt;
    private javax.swing.JLabel jLabelNumServ;
    private javax.swing.JLabel jLabelRazonSocial;
    private javax.swing.JLabel jLabelRucEmpresa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelInv;
    private javax.swing.JPanel jPanelResumen;
    private javax.swing.JPanel jPanelVentSem;
    private javax.swing.JPanel jPanelVentas;
    // End of variables declaration//GEN-END:variables
}
