/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIBRERIA;

import Controlador.Conexionlibre;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kt
 */
public class LoginLibreria extends javax.swing.JFrame {
    Conexionlibre cap=new Conexionlibre();
    Connection con=cap.Conexionlibredb();
    
    public LoginLibreria() {
        initComponents();
    }
    public void validarusuario(String cli,String cla){
         PreparedStatement op=null;
        ResultSet rs=null;
        try{
            
        op=con.prepareStatement("SELECT *FROM  Cliente WHERE Cli_nom ='"+cli+"'AND Cli_clave ='"+cla+"'");
        rs=op.executeQuery();
        if(rs.next()){
          Menulibreria pa=new Menulibreria();
            pa.setLocationRelativeTo(null);
            pa.setSize(800, 600);
             pa.setVisible(true);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null,"Datos no Validos");
        }
        }
        catch (Exception e){
            System.out.print("Error"+e);
        }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        contra = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INGRESO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 80, 100, 29);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("USUARIO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 140, 70, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("CLAVE");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 170, 60, 15);

        usu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuKeyTyped(evt);
            }
        });
        getContentPane().add(usu);
        usu.setBounds(130, 140, 113, 20);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 204));
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 210, 120, 49);

        contra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraKeyTyped(evt);
            }
        });
        getContentPane().add(contra);
        contra.setBounds(130, 170, 113, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/LOGIIN1.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 340, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cli,c;
    cli=usu.getText();
    c=contra.getText();
    validarusuario(cli, c);                         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuKeyTyped

    }//GEN-LAST:event_usuKeyTyped

    private void contraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraKeyTyped
    
    }//GEN-LAST:event_contraKeyTyped

    private void usuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuKeyPressed
    if(evt.getKeyCode()==evt.VK_ENTER){
  contra.requestFocus();
   }
    }//GEN-LAST:event_usuKeyPressed

    private void contraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jButton1.requestFocus();
        }
    }//GEN-LAST:event_contraKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
    if(evt.getKeyCode()==evt.VK_ENTER){
   jButton1.doClick();
   }
    }//GEN-LAST:event_jButton1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginLibreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginLibreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginLibreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginLibreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginLibreria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contra;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField usu;
    // End of variables declaration//GEN-END:variables
}
