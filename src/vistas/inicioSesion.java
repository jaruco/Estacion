package vistas;

import conexion.Conexion;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author jruiz
 */
public class inicioSesion extends javax.swing.JFrame {

    private int intentos = 0;
    public Conexion conn;

    public inicioSesion() {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        this.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btnIngresoSs = new javax.swing.JButton();
        btnLimpiaInicioSs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña");

        btnIngresoSs.setText("Ingresar");
        btnIngresoSs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoSsActionPerformed(evt);
            }
        });

        btnLimpiaInicioSs.setText("Limpiar");
        btnLimpiaInicioSs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiaInicioSsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContrasenia)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnIngresoSs)
                        .addGap(46, 46, 46)
                        .addComponent(btnLimpiaInicioSs)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresoSs)
                    .addComponent(btnLimpiaInicioSs))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoSsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoSsActionPerformed
        int correcto;
        conn = new Conexion();

        try {
            
            conn.getConnection();
            if (conn != null) {
                correcto = conn.login(txtUsuario.getText(), Conexion.encriptaEnMD5(txtContrasenia.getText()));
                if (correcto == 1) {
                    JOptionPane.showMessageDialog(null, "Bienvenido al Sistema", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
//                    new ventanaPrincipal().setVisible(true);
                    ventanaPrincipal ventana = new ventanaPrincipal(txtUsuario.getText());
                    ventana.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Datos Ingresados no son correctos, intente otra vez", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                    intentos++;
                    if (intentos == 3) {
                        JOptionPane.showMessageDialog(null, "Se alcanzó máximo número de intentos de acceso", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error");
        }
    }//GEN-LAST:event_btnIngresoSsActionPerformed

    private void btnLimpiaInicioSsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiaInicioSsActionPerformed
            txtUsuario.setText("");
            txtContrasenia.setText("");
            txtUsuario.requestFocus();
    }//GEN-LAST:event_btnLimpiaInicioSsActionPerformed

    public static void main(String args[]) {
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresoSs;
    private javax.swing.JButton btnLimpiaInicioSs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
