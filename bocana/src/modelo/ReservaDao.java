/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
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
public class ReservaDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarPorUsuario(int idUsuario) {
        ArrayList<Reserva> datosReserva = new ArrayList<>();
        String sql = "SELECT r.idReserva, r.fechaInicio, r.fechaFin, r.estado, r.idUsuario, r.idHabitacion, "
                + "u.documento, u.nombre1, u.nombre2, u.apellido1 , u.apellido2, u.correo, u.telefono, u.direccion, u.contrasena, u.idRol, "
                + "h.nombreHabitacion, h.estado, h.tarifa, h.descripcionBreve, h.descripcionDetallada, h.idTipoHabitacion, tp.descripcion , h.idHotel, "
                + "ho.nit, ho.nombreHotel, ho.direccion, ho.numeroHabitaciones FROM reservas r "
                + "JOIN usuarios u ON u.idUsuario = r.idUsuario "
                + "JOIN habitaciones h ON h.idHabitacion = r.idHabitacion "
                + "JOIN hoteles ho ON ho.idHotel = h.idHotel "
                + "JOIN tipos_habitaciones tp ON tp.idTipoHabitacion = h.idTipoHabitacion WHERE r.idUsuario = "+idUsuario;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reserva r = new Reserva();
                Habitacion h = new Habitacion();
                Hotel ho = new Hotel();
                Usuario u = new Usuario();
                r.setIdReserva(rs.getInt(1));
                r.setFechaInicio(rs.getDate(2));
                r.setFechaFin(rs.getDate(3));
                r.setEstado(rs.getString(4));
                
                
                
                u.setIdUsuario(rs.getInt(5));
                h.setIdHabitacion(rs.getInt(6));
                u.setDocumento(rs.getInt(7));
                u.setNombre1(rs.getString(8));
                u.setNombre2(rs.getString(9));
                u.setApellido1(rs.getString(10));
                u.setApellido2(rs.getString(11));
                u.setCorreo(rs.getString(12));
                u.setTelefono(rs.getString(13));
                u.setDireccion(rs.getString(14));
                u.setContrasena(rs.getString(15));
                u.setIdRol(rs.getInt(16));
                
                r.setUsuario(u);
                
                
                h.setNombreHabitacion(rs.getString(17));
                h.setEstado(rs.getString(18));
                h.setTarifa(rs.getDouble(19));
                h.setDescripcionBreve(rs.getString(20));
                h.setDescripcionDetallada(rs.getString(21));
                
                TipoHabitacion tp = new TipoHabitacion();
                tp.setIdTipoHabitacion(rs.getInt(22));
                tp.setDescripcion(rs.getString(23));
                
                h.setTipoHabitacion(tp);
                
                ho.setIdHotel(rs.getInt(24));
                ho.setNit(rs.getInt(25));
                ho.setNombreHotel(rs.getString(26));
                ho.setDireccion(rs.getString(27));
                ho.setNumeroHabitaciones(rs.getInt(28));

                
                ArrayList<TipoServicio> servicios = new ArrayList<TipoServicio>();
                
                String sqlS = "SELECT ts.idTipoServicio, ts.descripcion FROM tipos_servicios ts " +
                              "JOIN hoteles_tipos_servicios hts ON ts.idTipoServicio = hts.idTipoServicio " +
                              "WHERE hts.idHotel = " + ho.getIdHotel();
                
                PreparedStatement psS = con.prepareStatement(sqlS);
                ResultSet rsS = psS.executeQuery();

                while (rsS.next()) {
                    TipoServicio tps = new TipoServicio();
                    tps.setIdTipoServicio(rsS.getInt(1));
                    tps.setDescripcion(rsS.getString(2));
                    servicios.add(tps);
                }
                
                ho.setServicios(servicios);
                
                
                h.setHotel(ho);
                
                r.setUsuario(u);
                r.setHabitacion(h);
                

                datosReserva.add(r);
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
        return datosReserva;
    }
    
    public List listarPorHotel(int idHotel) {
        ArrayList<Reserva> datosReserva = new ArrayList<>();
        String sql = "SELECT r.idReserva, r.fechaInicio, r.fechaFin, r.estado, r.idUsuario, r.idHabitacion, "
            + "u.documento, u.nombre1, u.nombre2, u.apellido1, u.apellido2, u.correo, u.telefono, u.direccion, u.contrasena, u.idRol, "
            + "h.nombreHabitacion, h.estado, h.tarifa, h.descripcionBreve, h.descripcionDetallada, h.idTipoHabitacion, tp.descripcion, h.idHotel, "
            + "ho.nit, ho.nombreHotel, ho.direccion, ho.numeroHabitaciones"
            + "FROM reservas r "
            + "JOIN usuarios u ON u.idUsuario = r.idUsuario "
            + "JOIN habitaciones h ON h.idHabitacion = r.idHabitacion "
            + "JOIN hoteles ho ON ho.idHotel = h.idHotel "
            + "JOIN tipos_habitaciones tp ON tp.idTipoHabitacion = h.idTipoHabitacion "
            + "WHERE h.idHotel = "+idHotel;

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Reserva r = new Reserva();
                Habitacion h = new Habitacion();
                Hotel ho = new Hotel();
                Usuario u = new Usuario();
                r.setIdReserva(rs.getInt(1));
                r.setFechaInicio(rs.getDate(2));
                r.setFechaFin(rs.getDate(3));
                r.setEstado(rs.getString(4));
                
                
                
                u.setIdUsuario(rs.getInt(5));
                h.setIdHabitacion(rs.getInt(6));
                u.setDocumento(rs.getInt(7));
                u.setNombre1(rs.getString(8));
                u.setNombre2(rs.getString(9));
                u.setApellido1(rs.getString(10));
                u.setApellido2(rs.getString(11));
                u.setCorreo(rs.getString(12));
                u.setTelefono(rs.getString(13));
                u.setDireccion(rs.getString(14));
                u.setContrasena(rs.getString(15));
                u.setIdRol(rs.getInt(16));
                
                r.setUsuario(u);
                
                
                h.setNombreHabitacion(rs.getString(17));
                h.setEstado(rs.getString(18));
                h.setTarifa(rs.getDouble(19));
                h.setDescripcionBreve(rs.getString(20));
                h.setDescripcionDetallada(rs.getString(21));
                
                TipoHabitacion tp = new TipoHabitacion();
                tp.setIdTipoHabitacion(rs.getInt(22));
                tp.setDescripcion(rs.getString(23));
                
                h.setTipoHabitacion(tp);
                
                ho.setIdHotel(rs.getInt(24));
                ho.setNit(rs.getInt(25));
                ho.setNombreHotel(rs.getString(26));
                ho.setDireccion(rs.getString(27));
                ho.setNumeroHabitaciones(rs.getInt(28));

                
                ArrayList<TipoServicio> servicios = new ArrayList<TipoServicio>();
                
                String sqlS = "SELECT ts.idTipoServicio, ts.descripcion FROM tipos_servicios ts " +
                              "JOIN hoteles_tipos_servicios hts ON ts.idTipoServicio = hts.idTipoServicio " +
                              "WHERE hts.idHotel = " + ho.getIdHotel();
                
                PreparedStatement psS = con.prepareStatement(sqlS);
                ResultSet rsS = psS.executeQuery();

                while (rsS.next()) {
                    TipoServicio tps = new TipoServicio();
                    tps.setIdTipoServicio(rsS.getInt(1));
                    tps.setDescripcion(rsS.getString(2));
                    servicios.add(tps);
                }
                
                ho.setServicios(servicios);
                
                
                h.setHotel(ho);
                
                
                r.setHabitacion(h);
                

                datosReserva.add(r);
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
        return datosReserva;
    }
    
    
    public int setAgregar (Reserva r){
        String sql = "INSERT INTO reservas(id, fechaInicio, fechaFin, estado, idUsuario, idHabitacion) VALUES (?,?,?,?,?,?)";
       
        try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           

           ps.setInt(1, r.getIdReserva());
           ps.setDate(2, new java.sql.Date(r.getFechaInicio().getTime()));
           ps.setDate(3, new java.sql.Date(r.getFechaFin().getTime()));
           ps.setString(4,r.getEstado());
           ps.setInt(5, r.getUsuario().getIdUsuario());
           ps.setInt(6, r.getHabitacion().getIdHabitacion());

           
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
    
    public int setActualizar(Reserva r){
        String sql="UPDATE reservas SET fechaInicio=?, fechaFin=?, estado=?, idUsuario=?, idHabitacion=? WHERE idReserva=?";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setDate(1, (Date) r.getFechaInicio());
            ps.setDate(2, (Date) r.getFechaFin());
            ps.setString(3,r.getEstado());
            ps.setInt(4, r.getUsuario().getIdUsuario());
            ps.setInt(5, r.getHabitacion().getIdHabitacion());
            ps.setInt(6,r.getIdReserva());

            
            ps.executeUpdate();
            return 1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(),"Error de actualizacion"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
            return 0;
        }finally{
            try{
                if(con!=null){
                    con.close();
                }
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
            
        }
    }
    
    public int ultimoId() {
        String sql = "SELECT COUNT(*) FROM reservas";
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
