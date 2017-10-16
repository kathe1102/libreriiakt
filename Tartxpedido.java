/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIBRERIA;

import Controlador.Conexionlibre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kt
 */
public class Tartxpedido extends javax.swing.JInternalFrame {
 Conexionlibre cap=new Conexionlibre();
    Connection con=cap.Conexionlibredb();
    PreparedStatement op=null;
    ResultSet rs=null;
    
    public Tartxpedido() {
        initComponents();
        cargatXPEDIDO();
        cargarcodigo();
        cargarcombo();
    }
 public void cargatXPEDIDO(){
    DefaultTableModel tabla=new DefaultTableModel ();
        tabla.addColumn("Id pedido ");
        tabla.addColumn("Id articulo  ");
        tabla.addColumn("Cantidad de articulo  ");
        tabla.addColumn("Valor vendido  ");
       xpedido.setModel(tabla);
        String datos[]=new String[4];
        
        try{
         op=con.prepareStatement("SELECT *FROM articuloxpedido");
         rs=op.executeQuery();
         while (rs.next()){
           datos[0]=rs.getString(1);
           datos[1]=rs.getString(2);
           datos[2]=rs.getString(3);
           datos[3]=rs.getString(4);
           tabla.addRow(datos);
         }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
   public void Guardar(){
        try {
            op=con.prepareStatement("INSERT INTO Articuloxpedido(Artped_Ped_Id , Artped_Art_Id , Artped_Cant_Art ,Artped_Val_Ven ) Values (?,?,?,?)");  
              op.setString(1,IDP.getSelectedItem().toString());
              op.setString(2,IDART.getSelectedItem().toString());
              op.setInt(3,Integer.parseInt(CANT.getText()));
              op.setInt(4,Integer.parseInt(VALOR.getText()));
             op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=con.prepareStatement("DELETE from  Articuloxpedido where Artped_Ped_Id ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
          public void listardatos(){
     
      int lis=xpedido.getSelectedRow();
     if(lis>=0){ 
     IDP.setSelectedItem(xpedido.getValueAt(lis,0).toString());
    IDART.setSelectedItem(xpedido.getValueAt(lis,1).toString());
     CANT.setText(xpedido.getValueAt(lis,2).toString());
     VALOR.setText(xpedido.getValueAt(lis,3).toString());
     }
          }
     public void modificar(String doc ,String AR, String CA,String pre){
        
        try {
         op=con.prepareStatement("UPDATE   Articuloxpedido set Artped_Art_Id='"+AR+"',Artped_Cant_Art='"+CA+"' ,Artped_Val_Ven='"+pre+"' where Artped_Ped_Id ='"+doc+"'");
           op.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("eee"+e);  
        }
    }
      public void cargarcombo(){
        try {
            IDP.removeAll();
            IDP.addItem("SELECCIONE COD.PEDIDO");
          op=con.prepareStatement("Select Ped_Id  from  pedido ");
          rs=op.executeQuery();
         while(rs.next()){
             String aux=rs.getString("Ped_id");
             this.IDP.addItem(aux);
         }
  
        } catch (Exception e) {
        }
     }
       public void cargarcodigo(){
        try {
            IDART.removeAll();
           IDART.addItem("SELECCIONE COD.ARTICULO");
          op=con.prepareStatement("Select Art_Id from Articulos ");
          rs=op.executeQuery();
         while(rs.next()){
             String aux=rs.getString("Art_Id");
             this.IDART.addItem(aux);
         }
  
        } catch (Exception e) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        xpedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CANT = new javax.swing.JTextField();
        VALOR = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        IDP = new javax.swing.JComboBox<>();
        IDART = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ARTICULO X PEDIDO");
        getContentPane().setLayout(null);

        xpedido.setBackground(new java.awt.Color(255, 204, 255));
        xpedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        xpedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xpedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(xpedido);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 239, 603, 120);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID. PEDIDO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 30, 120, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID. ARTICULO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(104, 76, 120, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CANTIDAD ARTICULOS");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(104, 119, 130, 15);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("VALOR VENDIDO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(104, 169, 120, 15);

        CANT.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        CANT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CANT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CANTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CANTKeyTyped(evt);
            }
        });
        getContentPane().add(CANT);
        CANT.setBounds(250, 110, 150, 30);

        VALOR.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        VALOR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        VALOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                VALORKeyTyped(evt);
            }
        });
        getContentPane().add(VALOR);
        VALOR.setBounds(250, 160, 150, 30);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 255));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(470, 0, 100, 50);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 255));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(470, 120, 100, 50);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 51, 255));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(470, 180, 100, 50);

        IDP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        IDP.setForeground(new java.awt.Color(255, 0, 0));
        IDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDPActionPerformed(evt);
            }
        });
        IDP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IDPKeyPressed(evt);
            }
        });
        getContentPane().add(IDP);
        IDP.setBounds(250, 20, 150, 30);

        IDART.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        IDART.setForeground(new java.awt.Color(255, 0, 0));
        IDART.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IDARTKeyPressed(evt);
            }
        });
        getContentPane().add(IDART);
        IDART.setBounds(250, 60, 150, 30);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 51, 255));
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(470, 60, 100, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/libreee.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 640, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Guardar();
        cargatXPEDIDO();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String dat=IDP.getSelectedItem().toString();
        Eliminar(dat);
        cargatXPEDIDO();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       IDP.removeAllItems();
        cargarcombo();
       IDART.removeAllItems();
       cargarcodigo();
       CANT.setText(null);
       VALOR.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void CANTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CANTKeyTyped
        char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }                   
    }//GEN-LAST:event_CANTKeyTyped

    private void VALORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VALORKeyTyped
      char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }                   
    }//GEN-LAST:event_VALORKeyTyped

    private void IDPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDPKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
        IDART.requestFocus();
    }                            
    }//GEN-LAST:event_IDPKeyPressed

    private void IDARTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDARTKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
        CANT.requestFocus();
    }                            
    }//GEN-LAST:event_IDARTKeyPressed

    private void CANTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CANTKeyPressed
         if(evt.getKeyCode()==evt.VK_ENTER){
        VALOR.requestFocus();
    }                            
    }//GEN-LAST:event_CANTKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String p,a,c,v;
    p=IDP.getSelectedItem().toString();
    a=IDART.getSelectedItem().toString();
    c=CANT.getText();
    v=VALOR.getText();
        modificar(p, a, c, v);
        cargatXPEDIDO();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void IDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDPActionPerformed

    private void xpedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xpedidoMouseClicked
       listardatos();
    }//GEN-LAST:event_xpedidoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CANT;
    private javax.swing.JComboBox<String> IDART;
    private javax.swing.JComboBox<String> IDP;
    private javax.swing.JTextField VALOR;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable xpedido;
    // End of variables declaration//GEN-END:variables
}
