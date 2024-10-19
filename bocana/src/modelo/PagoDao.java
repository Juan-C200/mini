/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author estud
 */
public class PagoDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
     LocalDateTime fecha = LocalDateTime.now();
    
    public int setAgregar(Pago p){
        String sql = "INSERT INTO usuarios(documento, nombre1, nombre2, apellido1, apellido2, correo, telefono, direccion, contrasena, idRol) VALUES (?,?,?,?,?,?,?,?,?,?)";
       
       try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           
           
           
           ps.setDouble(1, p.getMonto());
           ps.setInt(2,p.getId_usuario());
           ps.setTimestamp(3, Timestamp.valueOf(fecha));
           ps.setInt(3,p.getId_habitacion());
           
           
           ps.executeUpdate();
           return 1;
              
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString(),"Error de insercion"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
           return 0;
       } finally {
           try{
               if(con!=null){
                   con.close();
               }
           } catch (SQLException sqle){
               JOptionPane.showMessageDialog(null, sqle.toString());
           }
       }
   }
    }

