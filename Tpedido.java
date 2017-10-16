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
public class Tpedido extends javax.swing.JInternalFrame {

    Conexionlibre cap=new Conexionlibre();
    Connection con=cap.Conexionlibredb();
    PreparedStatement op=null;
    ResultSet rs=null;
    public Tpedido() {
        initComponents();
        cargatpedido();
        cargarcombo();
    }

    public void cargatpedido(){
    DefaultTableModel tabla=new DefaultTableModel ();
        tabla.addColumn("id pedido  ");
        tabla.addColumn("Doc. Cliente ");
        tabla.addColumn("Fecha pedido ");
        tabla.addColumn("Valor pedido ");
        pedido.setModel(tabla);
        String datos[]=new String[4];
        
        try{
         op=con.prepareStatement("SELECT *FROM pedido");
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
    public void Registrar(){
        try {
            op=con.prepareStatement("INSERT INTO Pedido(Ped_Id ,Cli_id_Ped ,Ped_Fech ,Ped_Val ) Values (?,?,?,?)");  
              op.setInt(1,Integer.parseInt(PED.getText()));
              op.setString(2,DOC.getSelectedItem().toString());
              op.setString(3,FECHA.getText());
              op.setInt(4,Integer.parseInt(VALOR.getText()));
             op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
      public void listardatos(){
     
      int lis=pedido.getSelectedRow();
     if(lis>=0){ 
     PED.setText(pedido.getValueAt(lis,0).toString());
    DOC.setSelectedItem(pedido.getValueAt(lis,1).toString());
     FECHA.setText(pedido.getValueAt(lis,2).toString());
     VALOR.setText(pedido.getValueAt(lis,3).toString());
     }
      }
     public void Eliminar(String dat){
    try {
   op=con.prepareStatement("DELETE from Pedido where Ped_Id ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
      public void modificar(String ped ,String doc, String fe,String val){
        
        try {
         op=con.prepareStatement("UPDATE  Pedido set Cli_id_Ped='"+doc+"',Ped_Fech ='"+fe+"' ,Ped_Val='"+val+"'  where Ped_Id ='"+ped+"'");
           op.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("eee"+e);  
        }
    }
     public void cargarcombo(){
        try {
            DOC.removeAll();
            DOC.addItem("SELECCIONE DOCUMENTO");
          op=con.prepareStatement("Select Cli_id from  Cliente ");
          rs=op.executeQuery();
         while(rs.next()){
             String aux=rs.getString("Cli_id");
             this.DOC.addItem(aux);
         }
  
        } catch (Exception e) {
        }
     } 
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PED = new javax.swing.JTextField();
        FECHA = new javax.swing.JTextField();
        VALOR = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        DOC = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("PEDIDOS");
        getContentPane().setLayout(null);

        pedido.setBackground(new java.awt.Color(255, 204, 255));
        pedido.setForeground(new java.awt.Color(0, 0, 255));
        pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pedido);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 260, 670, 130);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID PEDIDO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(42, 40, 130, 30);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DOCUMENTO CLIENTE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 80, 140, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FECHA PEDIDO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 120, 110, 30);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("VALOR PEDIDO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 160, 110, 30);

        PED.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        PED.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PED.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PEDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PEDKeyTyped(evt);
            }
        });
        getContentPane().add(PED);
        PED.setBounds(200, 40, 170, 30);

        FECHA.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        FECHA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FECHA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FECHAKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FECHAKeyTyped(evt);
            }
        });
        getContentPane().add(FECHA);
        FECHA.setBounds(200, 120, 170, 30);

        VALOR.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        VALOR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        VALOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                VALORKeyTyped(evt);
            }
        });
        getContentPane().add(VALOR);
        VALOR.setBounds(200, 160, 170, 30);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 204));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(410, 10, 120, 60);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 204));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(410, 130, 120, 60);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 204));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(410, 190, 120, 60);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 51, 204));
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(410, 70, 120, 60);

        DOC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DOCKeyPressed(evt);
            }
        });
        getContentPane().add(DOC);
        DOC.setBounds(200, 80, 170, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/limm.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 680, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Registrar();
       cargatpedido();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     String dat=PED.getText();
        Eliminar(dat);
        cargatpedido();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PED.setText(null);
        DOC.removeAllItems();
        cargarcombo();
        FECHA.setText(null);
        VALOR.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String p, d,f,v;
        p=PED.getText();
        d=DOC.getSelectedItem().toString();
        f=FECHA.getText();
        v=VALOR.getText();
        modificar(p, d, f, v);
        cargatpedido();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void PEDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PEDKeyTyped
      char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }                       
    }//GEN-LAST:event_PEDKeyTyped

    private void FECHAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHAKeyTyped
        char caracter=evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) &&(caracter !='-')){ 
              evt.consume();
        }             
    }//GEN-LAST:event_FECHAKeyTyped

    private void VALORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VALORKeyTyped
      char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }                       
    }//GEN-LAST:event_VALORKeyTyped

    private void PEDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PEDKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
    DOC.requestFocus();
    }//GEN-LAST:event_PEDKeyPressed
    }
    private void DOCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DOCKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
    FECHA.requestFocus();
    }//GEN-LAST:event_DOCKeyPressed
    }
    private void FECHAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHAKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
    VALOR.requestFocus();
    }//GEN-LAST:event_FECHAKeyPressed
    }
    private void pedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pedidoMouseClicked
      listardatos();
    }//GEN-LAST:event_pedidoMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DOC;
    private javax.swing.JTextField FECHA;
    private javax.swing.JTextField PED;
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
    private javax.swing.JTable pedido;
    // End of variables declaration//GEN-END:variables
}
