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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kt
 */
public class Tarticulo extends javax.swing.JInternalFrame {
    Conexionlibre cap=new Conexionlibre();
    Connection con=cap.Conexionlibredb();
    PreparedStatement op=null;
    ResultSet rs=null;
    
    public Tarticulo() {
        initComponents();
        cargatariculo();
        
    }

    public void cargatariculo(){
    DefaultTableModel tabla=new DefaultTableModel ();
        tabla.addColumn("id articulos  ");
        tabla.addColumn("Titulo articulo  ");
        tabla.addColumn("Autor  ");
        tabla.addColumn("Editorial  ");
        tabla.addColumn("Precio   ");
       articulo.setModel(tabla);
        String datos[]=new String[5];
        
        try{
         op=con.prepareStatement("SELECT *FROM articulos");
         rs=op.executeQuery();
         while (rs.next()){
           datos[0]=rs.getString(1);
           datos[1]=rs.getString(2);
           datos[2]=rs.getString(3);
           datos[3]=rs.getString(4);
           datos[4]=rs.getString(5);
           tabla.addRow(datos);
         }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
     public void listardatos(){
     
      int lis=articulo.getSelectedRow();
     if(lis>=0){ 
     ID.setText(articulo.getValueAt(lis,0).toString());
    TIT.setText(articulo.getValueAt(lis,1).toString());
     AUTOR.setText(articulo.getValueAt(lis,2).toString());
     EDI.setText(articulo.getValueAt(lis,3).toString());
     PREC.setText(articulo.getValueAt(lis,4).toString());
     }
     }
     public void Guardar(){
        try {
            op=con.prepareStatement("INSERT INTO Articulos(Art_Id ,Art_Tit , Art_Aut , Art_Edi , Art_Pre) Values (?,?,?,?,?)");  
              op.setInt(1,Integer.parseInt(ID.getText()));
              op.setString(2,TIT.getText());
              op.setString(3,AUTOR.getText());
                op.setString(4,EDI.getText());
              op.setInt(5,Integer.parseInt(PREC.getText()));
             op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=con.prepareStatement("DELETE from Articulos where Art_Id ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
      public void modificar(String doc ,String nom, String aut,String edi,String pre){
        
        try {
         op=con.prepareStatement("UPDATE  Articulos set  Art_Tit='"+nom+"', Art_Aut='"+aut+"',Art_Edi='"+edi+"' ,Art_Pre='"+pre+"' where Art_Id='"+doc+"'");
           op.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("eee"+e);  
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        articulo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        TIT = new javax.swing.JTextField();
        AUTOR = new javax.swing.JTextField();
        EDI = new javax.swing.JTextField();
        PREC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ARTICULOS");
        getContentPane().setLayout(null);

        articulo.setBackground(new java.awt.Color(255, 204, 255));
        articulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        articulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        articulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                articuloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(articulo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 260, 641, 150);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID. ARTICULO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 30, 90, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TITULO ARTICULO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 60, 110, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AUTOR");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 90, 90, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("EDITORIAL");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 120, 90, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PRECIO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 150, 90, 20);

        ID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IDKeyTyped(evt);
            }
        });
        getContentPane().add(ID);
        ID.setBounds(200, 30, 130, 20);

        TIT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TIT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TITKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TITKeyTyped(evt);
            }
        });
        getContentPane().add(TIT);
        TIT.setBounds(200, 60, 130, 20);

        AUTOR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        AUTOR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AUTOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AUTORKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AUTORKeyTyped(evt);
            }
        });
        getContentPane().add(AUTOR);
        AUTOR.setBounds(200, 90, 130, 20);

        EDI.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        EDI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EDIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EDIKeyTyped(evt);
            }
        });
        getContentPane().add(EDI);
        EDI.setBounds(200, 120, 130, 20);

        PREC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PREC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PREC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PRECKeyTyped(evt);
            }
        });
        getContentPane().add(PREC);
        PREC.setBounds(200, 150, 130, 21);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 10, 100, 50);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(450, 130, 100, 50);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(450, 190, 100, 50);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(204, 0, 0));
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(450, 70, 100, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/libreee.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 680, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Guardar();
        cargatariculo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String dat=ID.getText();
        Eliminar(dat);
        cargatariculo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      ID.setText(null);
      TIT.setText(null);
      AUTOR.setText(null);
      EDI.setText(null);
      PREC.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyTyped
          char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }                    
    }//GEN-LAST:event_IDKeyTyped

    private void TITKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TITKeyTyped
     String texto= TIT.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
       TIT.setText(texto);
      
    }                         
      char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }//GEN-LAST:event_TITKeyTyped
    }
    private void AUTORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AUTORKeyTyped
       String texto= AUTOR.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
        AUTOR.setText(texto);
   

    }                         
     char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }//GEN-LAST:event_AUTORKeyTyped
    }
    private void EDIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EDIKeyTyped
       String texto= EDI.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
        EDI.setText(texto);
       
    }                         
     char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }//GEN-LAST:event_EDIKeyTyped
    }
    private void PRECKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PRECKeyTyped
    char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }//GEN-LAST:event_PRECKeyTyped
    }
    private void IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
    TIT.requestFocus();
    }//GEN-LAST:event_IDKeyPressed
    }
    private void TITKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TITKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
    AUTOR.requestFocus();
    }//GEN-LAST:event_TITKeyPressed
    }
    private void AUTORKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AUTORKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
    EDI.requestFocus();
    }//GEN-LAST:event_AUTORKeyPressed
    }
    private void EDIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EDIKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
    PREC.requestFocus();
    }//GEN-LAST:event_EDIKeyPressed
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String c,t,a,e,p;
        c=ID.getText();
        t=TIT.getText();
        a=AUTOR.getText();
        e=EDI.getText();
        p=PREC.getText();
        modificar(c, t, a, e, p);
        cargatariculo();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void articuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_articuloMouseClicked
       listardatos();
    }//GEN-LAST:event_articuloMouseClicked
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AUTOR;
    private javax.swing.JTextField EDI;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField PREC;
    private javax.swing.JTextField TIT;
    private javax.swing.JTable articulo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
