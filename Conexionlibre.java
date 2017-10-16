/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author kt
 */
public class Conexionlibre {

   Connection con=null;
   public  Connection Conexionlibredb(){
       try {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/Libreria","root","");
            JOptionPane.showMessageDialog(null,"Conexion Exitosa" );   
       } catch (Exception e) {
        System.out.println(e);   
       }
       return con;
   } 
    
    public static void main(String[] args) {
       Conexionlibre cap=new Conexionlibre();
       cap.Conexionlibredb();
    }
    
}
