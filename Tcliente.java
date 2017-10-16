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
public class Tcliente extends javax.swing.JInternalFrame {

    Conexionlibre cap=new Conexionlibre();
    Connection con=cap.Conexionlibredb();
    PreparedStatement op=null;
    ResultSet rs=null;
    
    public Tcliente() {
        initComponents();
      mesc.addItem("Seleccione");
      mesc.addItem("Enero");
      mesc.addItem("Febrero");
      mesc.addItem("Marzo");
      mesc.addItem("Abril");
      mesc.addItem("Mayo");
      mesc.addItem("Junio");
      mesc.addItem("Julio");
      mesc.addItem("Agosto");
      mesc.addItem("Septiembre");
      mesc.addItem("Octubre");
      mesc.addItem("Noviembre");
      mesc.addItem("Diciembre");
      // DEPARTAMENTOS DE COLOMBIA
       DE.addItem("SELECCIONE");
      DE.addItem("Amazonas");
      DE.addItem(" Antioquia");
      DE.addItem(" Arauca");
      DE.addItem(" Atlántico");
      DE.addItem("  Bogotá");
      DE.addItem("Bolívar");
      DE.addItem(" Boyacá");
      DE.addItem(" Caldas");
      DE.addItem(" Caquetá");
      DE.addItem(" Casanare");
      DE.addItem(" Cauca");
      DE.addItem(" Cesar");
      DE.addItem(" Chocó");
      DE.addItem("Córdoba");
      DE.addItem("Cundinamarca");
      DE.addItem("Guainía");
      DE.addItem("Guaviare");
      DE.addItem("Huila");
      DE.addItem("La Guajira");
       DE.addItem("Magdalena");
      DE.addItem("Meta");
       DE.addItem("Nariño");
      DE.addItem("Norte de Santander");
       DE.addItem("Putumayo");
      DE.addItem("Quindío");
       DE.addItem("Risaralda");
      DE.addItem("San Andrés y Providencia");
       DE.addItem("Santander");
      DE.addItem("Sucre");
      DE.addItem("Tolima");
      DE.addItem("Valle del Cauca");
      DE.addItem("Vaupés");
      DE.addItem("Vichada");
        cargatcliente();
    }
public void cargatcliente(){
    DefaultTableModel tabla=new DefaultTableModel ();
        tabla.addColumn("Documento  ");
        tabla.addColumn("Nombre Cliente  ");
        tabla.addColumn("Apellido  ");
        tabla.addColumn("Direccion  ");
        tabla.addColumn("Departamento  ");
        tabla.addColumn("Mes cumpleaños  ");
        tabla.addColumn("Clave  ");
        cliente.setModel(tabla);
        String datos[]=new String[7];
        
        try{
         op=con.prepareStatement("SELECT *FROM Cliente");
         rs=op.executeQuery();
         while (rs.next()){
           datos[0]=rs.getString(1);
           datos[1]=rs.getString(2);
           datos[2]=rs.getString(3);
           datos[3]=rs.getString(4);
           datos[4]=rs.getString(5);
           datos[5]=rs.getString(6);
           datos[6]=rs.getString(7);
           tabla.addRow(datos);
         }
        } catch (Exception e) {
            System.out.print(e);
        }
}
     public void listardatos(){
     
      int lis=cliente.getSelectedRow();
     if(lis>=0){ 
     DOC.setText(cliente.getValueAt(lis,0).toString());
     NOM.setText(cliente.getValueAt(lis,1).toString());
     APE.setText(cliente.getValueAt(lis,2).toString());
     DIR.setText(cliente.getValueAt(lis,3).toString());
     DE.setSelectedItem(cliente.getValueAt(lis,4).toString());
     mesc.setSelectedItem(cliente.getValueAt(lis,5).toString());
    CLAVE.setText(cliente.getValueAt(lis,6).toString());
     }
     }
     public void filtrar(){
    DefaultTableModel tabla=new DefaultTableModel ();
        tabla.addColumn("Documento  ");
        tabla.addColumn("Nombre Cliente  ");
        tabla.addColumn("Apellido  ");
        tabla.addColumn("Direccion  ");
        tabla.addColumn("Departamento  ");
        tabla.addColumn("Mes cumpleaños  ");
        tabla.addColumn("Clave  ");
        cliente.setModel(tabla);
        String datos[]=new String[7];
        
        try{
         op=con.prepareStatement("SELECT *FROM Cliente where Cli_id like '%"+filtro.getText()+"%' or  Cli_Nom like '%"+filtro.getText()+"%' or  Cli_Apell like '%"+filtro.getText()+"%' or  Cli_Dir like '%"+filtro.getText()+"%' or Cli_Dep like '%"+filtro.getText()+"%' or  Cli_mes_cum like '%"+filtro.getText()+"%' or CLi_clave like '%"+filtro.getText()+"%'");
         rs=op.executeQuery();
         while (rs.next()){
           datos[0]=rs.getString(1);
           datos[1]=rs.getString(2);
           datos[2]=rs.getString(3);
           datos[3]=rs.getString(4);
           datos[4]=rs.getString(5);
           datos[5]=rs.getString(6);
           datos[6]=rs.getString(7);
           tabla.addRow(datos);
         }
        } catch (Exception e) {
            System.out.print(e);
        }
}
  public void Registrar(){
        try {
            op=con.prepareStatement("INSERT INTO Cliente (Cli_id , Cli_Nom , Cli_Apell , Cli_Dir ,Cli_Dep , Cli_mes_cum,CLi_clave) Values(?,?,?,?,?,?,?)");  
              op.setString(1,DOC.getText());
              op.setString(2,NOM.getText());
              op.setString(3,APE.getText());
              op.setString(4,DIR.getText());
              op.setString(5,DE.getSelectedItem().toString());
              op.setString(6, mesc.getSelectedItem().toString());
              op.setString(7,CLAVE.getText());  
             op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=con.prepareStatement("DELETE from Cliente where Cli_id ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
      public void modificar(String doc ,String nom, String ape,String dir,String dep,String mes,String cla){
        
          
        try {
         op=con.prepareStatement("UPDATE  Cliente set  Cli_Nom='"+nom+"',Cli_Apell='"+ape+"',Cli_Dir='"+dir+"' ,Cli_Dep='"+dep+"', Cli_mes_cum='"+mes+"',CLi_clave='"+cla+"' where Cli_id='"+doc+"'");
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
        cliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DOC = new javax.swing.JTextField();
        NOM = new javax.swing.JTextField();
        APE = new javax.swing.JTextField();
        DIR = new javax.swing.JTextField();
        CLAVE = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        mesc = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        filtro = new javax.swing.JTextField();
        DE = new javax.swing.JComboBox<>();
        DEPAR = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CLIENTES");
        getContentPane().setLayout(null);

        cliente.setBackground(new java.awt.Color(255, 204, 255));
        cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cliente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 320, 727, 150);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DOCUMENTO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 50, 120, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 80, 120, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("APELLIDO  ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 110, 120, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DIRECCION");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 150, 120, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DEPARTAMENTO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 190, 120, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MES  CUMPLEAÑOS");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(110, 230, 120, 15);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CLAVE");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(110, 270, 120, 20);

        DOC.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        DOC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DOC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DOCKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DOCKeyPressed(evt);
            }
        });
        getContentPane().add(DOC);
        DOC.setBounds(250, 50, 160, 21);

        NOM.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        NOM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NOM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NOMKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NOMKeyPressed(evt);
            }
        });
        getContentPane().add(NOM);
        NOM.setBounds(250, 80, 160, 21);

        APE.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        APE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        APE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                APEKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                APEKeyPressed(evt);
            }
        });
        getContentPane().add(APE);
        APE.setBounds(250, 110, 160, 21);

        DIR.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        DIR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DIR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DIRKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DIRKeyPressed(evt);
            }
        });
        getContentPane().add(DIR);
        DIR.setBounds(250, 150, 160, 21);

        CLAVE.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        CLAVE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(CLAVE);
        CLAVE.setBounds(250, 270, 160, 21);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 0, 100, 20);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 0, 90, 20);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 51, 51));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(280, 0, 90, 20);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 51, 51));
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(100, 0, 95, 20);

        getContentPane().add(mesc);
        mesc.setBounds(250, 230, 160, 20);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 0, 51));
        jButton5.setText("BUSCAR");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton5KeyReleased(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(370, 0, 90, 20);
        getContentPane().add(filtro);
        filtro.setBounds(470, 0, 250, 20);

        getContentPane().add(DE);
        DE.setBounds(250, 180, 160, 30);

        DEPAR.setForeground(new java.awt.Color(255, 102, 255));
        DEPAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/limm.jpg"))); // NOI18N
        getContentPane().add(DEPAR);
        DEPAR.setBounds(0, 0, 750, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    DOC.setText(null);
    NOM.setText(null);
    APE.setText(null);
    DIR.setText(null);
    DE.removeAllItems();
   mesc.removeAllItems();
    CLAVE.setText(null);
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Registrar();
    cargatcliente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String dat=DOC.getText();
        Eliminar(dat);
        cargatcliente();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String d, n, a,di,de,m,cl;
        d=DOC.getText();
        n=NOM.getText();
        a=APE.getText();
        di=DIR.getText();
        de=DE.getSelectedItem().toString();
        m=mesc.getSelectedItem().toString();
        cl=CLAVE.getText();
        modificar(d, n, a,di, de, m, cl);
        
        cargatcliente();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void DOCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DOCKeyPressed
     if(evt.getKeyCode()==evt.VK_ENTER){
        NOM.requestFocus();
    }//GEN-LAST:event_DOCKeyPressed
    }
    private void NOMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMKeyPressed
     if(evt.getKeyCode()==evt.VK_ENTER){
        APE.requestFocus();
    }//GEN-LAST:event_NOMKeyPressed
    }
    private void APEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_APEKeyPressed
    if(evt.getKeyCode()==evt.VK_ENTER){
        DIR.requestFocus();
    }//GEN-LAST:event_APEKeyPressed
    }
    private void DIRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DIRKeyPressed
  if(evt.getKeyCode()==evt.VK_ENTER){
        DE.requestFocus();
    }//GEN-LAST:event_DIRKeyPressed
    }     

    private void NOMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMKeyTyped
     String texto= NOM.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
      NOM.setText(texto);
     

    }//GEN-LAST:event_NOMKeyTyped
      
        char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }                     
    }
    private void APEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_APEKeyTyped
   String texto= APE.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
        APE.setText(texto);

    }//GEN-LAST:event_APEKeyTyped
      
        char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }                     
    }
    private void DIRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DIRKeyTyped
      String texto= DIR.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
        DIR.setText(texto);
    }   

    }//GEN-LAST:event_DIRKeyTyped

    private void DOCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DOCKeyTyped
         
        char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }                     
    }//GEN-LAST:event_DOCKeyTyped

    private void clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteMouseClicked
    listardatos();
    }//GEN-LAST:event_clienteMouseClicked

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
       filtrar();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyReleased
      filtrar();
    }//GEN-LAST:event_jButton5KeyReleased
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField APE;
    private javax.swing.JTextField CLAVE;
    private javax.swing.JComboBox<String> DE;
    private javax.swing.JLabel DEPAR;
    private javax.swing.JTextField DIR;
    private javax.swing.JTextField DOC;
    private javax.swing.JTextField NOM;
    private javax.swing.JTable cliente;
    private javax.swing.JTextField filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> mesc;
    // End of variables declaration//GEN-END:variables
}
