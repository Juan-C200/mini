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
public class HotelDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
    public List listar() {
        ArrayList<Hotel> datosHotel = new ArrayList<Hotel>();
        String sql = "SELECT h.idHotel, h.nit, h.nombreHotel, h.direccion, h.numeroHabitaciones, h.idOfertaEspecial, h.idUsuario, "
           + "u.documento, u.nombre1, u.nombre2, u.apellido1, u.apellido2, u.correo, u.telefono, u.direccion, u.contrasena, u.idRol "
           + "FROM hoteles h JOIN usuarios u ON h.idUsuario = u.idUsuario";


        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Hotel h = new Hotel();
                Usuario u = new Usuario();
                h.setIdHotel(rs.getInt(1));
                h.setNit(rs.getInt(2));
                h.setNombreHotel(rs.getString(3));
                h.setDireccion(rs.getString(4));
                h.setNumeroHabitaciones(rs.getInt(5));
                h.setOfertaEspecial(rs.getInt(6));
                
                
                u.setIdUsuario(rs.getInt(7));
                u.setDocumento(rs.getInt(8));
                u.setNombre1(rs.getString(9));
                u.setNombre2(rs.getString(10));
                u.setApellido1(rs.getString(11));
                u.setApellido2(rs.getString(12));
                u.setCorreo(rs.getString(13));
                u.setTelefono(rs.getString(14));
                u.setDireccion(rs.getString(15));
                u.setContrasena(rs.getString(16));
                u.setIdRol(rs.getInt(17));
                
                h.setUsuario(u);
                
                
                ArrayList<TipoServicio> servicios = new ArrayList<TipoServicio>();
                
                String sqlS = "SELECT ts.idTipoServicio, ts.descripcion FROM tipos_servicios ts " +
                              "JOIN hoteles_tipos_servicios hts ON ts.idTipoServicio = hts.idTipoServicio " +
                              "WHERE hts.idHotel = " + h.getIdHotel();
                
                PreparedStatement psS = con.prepareStatement(sqlS);
                ResultSet rsS = psS.executeQuery();

                while (rsS.next()) {
                    TipoServicio tp = new TipoServicio();
                    tp.setIdTipoServicio(rsS.getInt(1));
                    tp.setDescripcion(rsS.getString(2));
                    servicios.add(tp);
                }

                
                h.setServicios(servicios);

                
                datosHotel.add(h);

                
                rsS.close();
                psS.close();
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
        
        
       
        return datosHotel;
    }
    
    public int setAgregar (Hotel h){
       String sql = "INSERT INTO hoteles VALUES (?, ?, ?, ?, ?, ?, ?)";
       
       try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           

            ps.setInt(1, h.getIdHotel());
            ps.setInt(2, h.getNit());
            ps.setString(3, h.getNombreHotel());
            ps.setString(4, h.getDireccion());
            ps.setInt(5, h.getNumeroHabitaciones());
            ps.setInt(6, 1);
            ps.setInt(7, h.getUsuario().getIdUsuario());
           
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
    
    public int setAgregarServicios (int idHotel, int idTipoServicio){
       String sql = "INSERT INTO hoteles_tipos_servicios VALUES (?,?)";
       
       try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           

            ps.setInt(1, idHotel);
            ps.setInt(2, idTipoServicio);
           
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
        String sql = "SELECT COUNT(*) FROM hoteles";
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
}
