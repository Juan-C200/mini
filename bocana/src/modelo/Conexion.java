/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Aprendiz
 */
public class Conexion {
    
    Connection con;
    String url="jdbc:mysql://localhost:3306/alojamientos";
    String pass="";
    String user="root";
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
//            JOptionPane.showMessageDialog(null,"Conexion exitosa");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Problema de conexion "+e.toString());
        }
        
        return con;
        
        
        
    }
    
    
}
