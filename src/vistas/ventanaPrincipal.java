package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Jorge
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    public ventanaPrincipal() {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        this.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ventanaPrincipal vp = new ventanaPrincipal();
        vp.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jpDatosEmpresa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jdpAreaTrabajo = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmConexion = new javax.swing.JMenu();
        jmiSalir = new javax.swing.JMenuItem();
        jmTareasOperador = new javax.swing.JMenu();
        jmiEmitirTicket = new javax.swing.JMenuItem();
        jmiCompletarTicket = new javax.swing.JMenuItem();
        jmiNuevaReclamacion = new javax.swing.JMenuItem();
        jmReportes = new javax.swing.JMenu();
        jmTareasSupervisor = new javax.swing.JMenu();
        jmiConsultarServicio = new javax.swing.JMenuItem();
        jmiConsultarCliente = new javax.swing.JMenuItem();
        jmiConsultarComprobante = new javax.swing.JMenuItem();
        jmiGenDemandaServicio = new javax.swing.JMenuItem();
        jmiGenTurnos = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("ESTACIONAMIENTO \"SAN JOSÉ\"");

        lblUsuario.setText("hola");

        javax.swing.GroupLayout jpDatosEmpresaLayout = new javax.swing.GroupLayout(jpDatosEmpresa);
        jpDatosEmpresa.setLayout(jpDatosEmpresaLayout);
        jpDatosEmpresaLayout.setHorizontalGroup(
            jpDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosEmpresaLayout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel1)
                .addGap(137, 137, 137)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jpDatosEmpresaLayout.setVerticalGroup(
            jpDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosEmpresaLayout.createSequentialGroup()
                .addGroup(jpDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdpAreaTrabajoLayout = new javax.swing.GroupLayout(jdpAreaTrabajo);
        jdpAreaTrabajo.setLayout(jdpAreaTrabajoLayout);
        jdpAreaTrabajoLayout.setHorizontalGroup(
            jdpAreaTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jdpAreaTrabajoLayout.setVerticalGroup(
            jdpAreaTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jmConexion.setText("Conexión");

        jmiSalir.setText("SALIR");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmConexion.add(jmiSalir);

        jMenuBar1.add(jmConexion);

        jmTareasOperador.setText("Tareas");

        jmiEmitirTicket.setText("Nuevo Ingreso");
        jmiEmitirTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEmitirTicketActionPerformed(evt);
            }
        });
        jmTareasOperador.add(jmiEmitirTicket);

        jmiCompletarTicket.setText("Registrar Salida");
        jmiCompletarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCompletarTicketActionPerformed(evt);
            }
        });
        jmTareasOperador.add(jmiCompletarTicket);

        jmiNuevaReclamacion.setText("Registrar Reclamo");
        jmiNuevaReclamacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevaReclamacionActionPerformed(evt);
            }
        });
        jmTareasOperador.add(jmiNuevaReclamacion);

        jMenuBar1.add(jmTareasOperador);

        jmReportes.setText("Reportes");
        jMenuBar1.add(jmReportes);

        jmTareasSupervisor.setText("Tareas");

        jmiConsultarServicio.setText("Consultar Servicio");
        jmiConsultarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultarServicioActionPerformed(evt);
            }
        });
        jmTareasSupervisor.add(jmiConsultarServicio);

        jmiConsultarCliente.setText("Consultar Cliente");
        jmiConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultarClienteActionPerformed(evt);
            }
        });
        jmTareasSupervisor.add(jmiConsultarCliente);

        jmiConsultarComprobante.setText("Consultar Comprobante");
        jmiConsultarComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultarComprobanteActionPerformed(evt);
            }
        });
        jmTareasSupervisor.add(jmiConsultarComprobante);

        jmiGenDemandaServicio.setText("Generar Demanda de Servicio");
        jmiGenDemandaServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGenDemandaServicioActionPerformed(evt);
            }
        });
        jmTareasSupervisor.add(jmiGenDemandaServicio);

        jmiGenTurnos.setText("Asignar turnos");
        jmiGenTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGenTurnosActionPerformed(evt);
            }
        });
        jmTareasSupervisor.add(jmiGenTurnos);

        jMenuBar1.add(jmTareasSupervisor);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDatosEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jdpAreaTrabajo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpDatosEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdpAreaTrabajo))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiEmitirTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEmitirTicketActionPerformed
        nuevoIngreso nuevIngre = new nuevoIngreso();
        nuevIngre.setVisible(true);
        jdpAreaTrabajo.add(nuevIngre);
        //this.setContentPane(conComp);
        try {
            nuevIngre.setSelected(true);
        } catch (java.beans.PropertyVetoException ej) {

        }
    }//GEN-LAST:event_jmiEmitirTicketActionPerformed

    private void jmiNuevaReclamacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevaReclamacionActionPerformed
        registrarReclamo regRecla = new registrarReclamo();
        regRecla.setVisible(true);
        jdpAreaTrabajo.add(regRecla);
        //this.setContentPane(conComp);
        try {
            regRecla.setSelected(true);
        } catch (java.beans.PropertyVetoException ej) {

        }
    }//GEN-LAST:event_jmiNuevaReclamacionActionPerformed

    private void jmiCompletarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCompletarTicketActionPerformed
        registrarSalida regSalida = new registrarSalida();
        regSalida.setVisible(true);
        jdpAreaTrabajo.add(regSalida);//this.setContentPane(conComp);
        try {
            regSalida.setSelected(true);
        } catch (java.beans.PropertyVetoException ej) {

        }
    }//GEN-LAST:event_jmiCompletarTicketActionPerformed

    private void jmiConsultarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultarServicioActionPerformed
        consultarServicio conServ = new consultarServicio();
        conServ.setVisible(true);
        jdpAreaTrabajo.add(conServ);//this.setContentPane(conComp);
        try {
            conServ.setSelected(true);
        } catch (java.beans.PropertyVetoException ej) {

        }
    }//GEN-LAST:event_jmiConsultarServicioActionPerformed

    private void jmiConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultarClienteActionPerformed
        consultarCliente conCli = new consultarCliente();
        conCli.setVisible(true);
        jdpAreaTrabajo.add(conCli);
        try {
            conCli.setSelected(true);
        } catch (java.beans.PropertyVetoException ej) {

        }
    }//GEN-LAST:event_jmiConsultarClienteActionPerformed

    private void jmiConsultarComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultarComprobanteActionPerformed
        consultarComprobante conComp = new consultarComprobante();
        conComp.setVisible(true);
        jdpAreaTrabajo.add(conComp);
        try {
            conComp.setSelected(true);
        } catch (java.beans.PropertyVetoException ej) {

        }
    }//GEN-LAST:event_jmiConsultarComprobanteActionPerformed

    private void jmiGenDemandaServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGenDemandaServicioActionPerformed
        genDemandaServicio nr = new genDemandaServicio();
        nr.setVisible(true);
        jdpAreaTrabajo.add(nr);
        try {
            nr.setSelected(true);
        } catch (java.beans.PropertyVetoException ej) {

        }
    }//GEN-LAST:event_jmiGenDemandaServicioActionPerformed

    private void jmiGenTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGenTurnosActionPerformed
        generarTurnos gt = new generarTurnos();
        gt.setVisible(true);
        jdpAreaTrabajo.add(gt);
        try {
            gt.setSelected(true);
        } catch (java.beans.PropertyVetoException ej) {

        }
    }//GEN-LAST:event_jmiGenTurnosActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JDesktopPane jdpAreaTrabajo;
    private javax.swing.JMenu jmConexion;
    private javax.swing.JMenu jmReportes;
    private javax.swing.JMenu jmTareasOperador;
    private javax.swing.JMenu jmTareasSupervisor;
    private javax.swing.JMenuItem jmiCompletarTicket;
    private javax.swing.JMenuItem jmiConsultarCliente;
    private javax.swing.JMenuItem jmiConsultarComprobante;
    private javax.swing.JMenuItem jmiConsultarServicio;
    private javax.swing.JMenuItem jmiEmitirTicket;
    private javax.swing.JMenuItem jmiGenDemandaServicio;
    private javax.swing.JMenuItem jmiGenTurnos;
    private javax.swing.JMenuItem jmiNuevaReclamacion;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JPanel jpDatosEmpresa;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
