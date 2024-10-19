/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ResenaDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
    public List listar(int idHotel) {
        ArrayList<Resena> resenas = new ArrayList<>();
        String sql = "SELECT r.idResena, r.calificacion, r.comentario, r.idUsuario, r.idHotel"
                + ", u.documento, u.nombre1, u.nombre2, u.apellido1 , u.apellido2, u.correo, u.telefono, u.direccion, u.contrasena, u.idRol,"
                + " h.nit, h.nombreHotel, h.direccion, h.numeroHabitaciones, h.idOfertaEspecial FROM resenas r "
                + "JOIN usuarios u ON r.idUsuario = u.idUsuario "
                + "JOIN hoteles h ON r.idHotel = h.idHotel WHERE r.idHotel = " + idHotel;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Resena r = new Resena();
                Usuario u = new Usuario();
                Hotel h = new Hotel();
                
                r.setIdResena(rs.getInt(1));
                r.setCalificacion(rs.getInt(2));
                r.setComentario(rs.getString(3));
                
                u.setIdUsuario(rs.getInt(4));
                h.setIdHotel(rs.getInt(5));
                
                u.setDocumento(rs.getInt(6));
                u.setNombre1(rs.getString(7));
                u.setNombre2(rs.getString(8));
                u.setApellido1(rs.getString(9));
                u.setApellido2(rs.getString(10));
                u.setCorreo(rs.getString(11));
                u.setTelefono(rs.getString(12));
                u.setDireccion(rs.getString(13));
                u.setContrasena(rs.getString(14));
                u.setIdRol(rs.getInt(15));
                r.setUsuario(u);
                
                
                h.setNit(rs.getInt(16));
                h.setNombreHotel(rs.getString(17));
                h.setDireccion(rs.getString(18));
                h.setNumeroHabitaciones(rs.getInt(19));
                h.setOfertaEspecial(rs.getInt(20));
                r.setHotel(h);
                
                
                resenas.add(r);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        finally {
            try {
                if (con != null) {
                    con.close();
                }
            }
            catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
        return resenas;
    }
    
   public int setAgregar (Resena r){
       String sql = "INSERT INTO resenas VALUES (?, ?, ?, ?, ?)";
       
       try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           

           
           ps.setInt(1, r.getIdResena());
           ps.setInt(2,r.getCalificacion());
           ps.setString(3,r.getComentario());
           ps.setInt(4, r.getUsuario().getIdUsuario());
           ps.setInt(5, r.getHotel().getIdHotel());

           
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
   
   public int ultimoId() {
        String sql = "SELECT COUNT(*) FROM resenas";
        int numero = 0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                numero = rs.getInt(1);
            }

            return numero;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error en la consulta " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
    }
   
   public double calificar(int idHotel) {
        String sql = "SELECT AVG(calificacion) FROM resenas WHERE idHotel ="+idHotel;
        double numero = 0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                numero = rs.getDouble(1);
            }
            numero = Math.round(numero * 10.0) / 10.0;
            return Math.round(numero * 10.0) / 10.0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error en la consulta " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
    }
}
