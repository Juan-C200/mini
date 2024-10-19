/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author estud
 */
public class TarjetaDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public int setAgregar(Tarjeta t){
        String sql = "INSERT INTO tarjeta (numTarjeta, cvv, nombrePropietario, apellidoPropietario, fechaVencimiento,tipoTarjeta, banco, tipoDebito, id_usuario) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           

            ps.setString(1, t.getNumTarjeta());
            ps.setString(2, t.getCvv());
            ps.setString(3, t.getNombrePropietario());
            ps.setString(4, t.getApellidoPropietario());
            ps.setString(5, t.getFechaVencimiento());
            ps.setString(6, t.getTipoTarjeta()); 
            ps.setString(7, t.getBanco());
            ps.setString(8, t.getTipoDebito());
            ps.setInt(9, t.getIdUsuario());
           
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
