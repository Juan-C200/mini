/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Dimension;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class HabitacionDao {
    
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar() {
        ArrayList<Habitacion> datosHabitaciones = new ArrayList<Habitacion>();
        String sql = "SELECT h.idHabitacion, h.nombreHabitacion, h.estado, h.tarifa, h.descripcionBreve, h.descripcionDetallada, h.idTipoHabitacion, tp.descripcion , h.idHotel,"
                + " ho.nit, ho.nombreHotel, ho.direccion, ho.numeroHabitaciones, h.idOfertaEspecial, oe.descuento, oe.fechaInicio, oe.fechaFin"
                + " FROM habitaciones h "
                + "JOIN tipos_habitaciones tp ON tp.idTipoHabitacion = h.idTipoHabitacion "
                + "JOIN hoteles ho ON ho.idHotel = h.idHotel "
                + "LEFT JOIN ofertas_especiales oe ON oe.idOfertaEspecial = h.idOfertaEspecial";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Habitacion h = new Habitacion();
                Hotel ho = new Hotel();
                h.setIdHabitacion(rs.getInt(1));
                h.setNombreHabitacion(rs.getString(2));
                h.setEstado(rs.getString(3));
                h.setTarifa(rs.getDouble(4));
                h.setDescripcionBreve(rs.getString(5));
                h.setDescripcionDetallada(rs.getString(6));
                
                TipoHabitacion tp = new TipoHabitacion();
                tp.setIdTipoHabitacion(rs.getInt(7));
                tp.setDescripcion(rs.getString(8));
                
                h.setTipoHabitacion(tp);
                
                ho.setIdHotel(rs.getInt(9));
                ho.setNit(rs.getInt(10));
                ho.setNombreHotel(rs.getString(11));
                ho.setDireccion(rs.getString(12));
                ho.setNumeroHabitaciones(rs.getInt(13));
                
                Oferta o = new Oferta();
                
                o.setIdOfertaEspecial(rs.getInt(14));
                o.setDescuento(rs.getInt(15));
                o.setFechaInicio(rs.getDate(16));
                o.setFechaFin(rs.getDate(17));
                
                h.setOferta(o);
                
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
                
                

                datosHabitaciones.add(h);
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
        return datosHabitaciones;
    }
    
    public List listarPorHotel(int idHotel) {
        ArrayList<Habitacion> datosHabitaciones = new ArrayList<Habitacion>();
        String sql = "SELECT h.idHabitacion, h.nombreHabitacion, h.estado, h.tarifa, h.descripcionBreve, h.descripcionDetallada, h.idTipoHabitacion, tp.descripcion , h.idHotel,"
                + " ho.nit, ho.nombreHotel, ho.direccion, ho.numeroHabitaciones, h.idOfertaEspecial, oe.descuento, oe.fechaInicio, oe.fechaFin"
                + " FROM habitaciones h "
                + "JOIN tipos_habitaciones tp ON tp.idTipoHabitacion = h.idTipoHabitacion "
                + "JOIN hoteles ho ON ho.idHotel = h.idHotel "
                + "LEFT JOIN ofertas_especiales oe ON oe.idOfertaEspecial = h.idOfertaEspecial WHERE h.idHotel = "+idHotel;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Habitacion h = new Habitacion();
                Hotel ho = new Hotel();
                h.setIdHabitacion(rs.getInt(1));
                h.setNombreHabitacion(rs.getString(2));
                h.setEstado(rs.getString(3));
                h.setTarifa(rs.getDouble(4));
                h.setDescripcionBreve(rs.getString(5));
                h.setDescripcionDetallada(rs.getString(6));
                
                TipoHabitacion tp = new TipoHabitacion();
                tp.setIdTipoHabitacion(rs.getInt(7));
                tp.setDescripcion(rs.getString(8));
                
                h.setTipoHabitacion(tp);
                
                ho.setIdHotel(rs.getInt(9));
                ho.setNit(rs.getInt(10));
                ho.setNombreHotel(rs.getString(11));
                ho.setDireccion(rs.getString(12));
                ho.setNumeroHabitaciones(rs.getInt(13));
                
                Oferta o = new Oferta();
                
                o.setIdOfertaEspecial(rs.getInt(14));
                o.setDescuento(rs.getInt(15));
                o.setFechaInicio(rs.getDate(16));
                o.setFechaFin(rs.getDate(17));
                
                h.setOferta(o);
                
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
                
                

                datosHabitaciones.add(h);
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
        return datosHabitaciones;
    }
    
    public List listarImagenes(int idHabitacion) {
        ArrayList<JLabel> fotos = new ArrayList<JLabel>();
        String sql = "SELECT imagen FROM imagenes WHERE idHabitacion = "+idHabitacion;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                byte[] imagenBytes = rs.getBytes("imagen");
                
                JLabel foto = new JLabel();
                foto.setSize(170, 100);
                
                // Convertir el array de bytes a un objeto Image
                InputStream in = new ByteArrayInputStream(imagenBytes);
                ImageIcon ima = new ImageIcon(in.readAllBytes());
                Image imagenEscalada = ima.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
                foto.setIcon(new ImageIcon(imagenEscalada));               
                
                fotos.add(foto);
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
        return fotos;
    }
    
    public List listarImagenesByte(int idHabitacion) {
        ArrayList<byte[]> imagenes = new ArrayList<byte[]>();
        String sql = "SELECT imagen FROM imagenes WHERE idHabitacion = "+idHabitacion;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                byte[] imagenBytes = rs.getBytes("imagen");
                         
                
                imagenes.add(imagenBytes);
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
        return imagenes;
    }
    
    
    public int setAgregar (Habitacion h){
       String sql = "INSERT INTO habitaciones VALUES (? ,?, ?, ?, ?, ?, ?, ?, ?)";
       
       try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           

           ps.setInt(1, h.getIdHabitacion());
           ps.setString(2, h.getNombreHabitacion());
           ps.setString(3, h.getEstado());
           ps.setDouble(4,h.getTarifa());
           ps.setString(5,h.getDescripcionBreve());
           ps.setString(6, h.getDescripcionDetallada());
           ps.setInt(7, h.getTipoHabitacion().getIdTipoHabitacion());
           ps.setInt(8, h.getOferta().getIdOfertaEspecial());
           ps.setInt(9, h.getHotel().getIdHotel());
           
           
           
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
    
    
    public int setActualizarOferta(int idHabitacion, int idOferta){
        String sql="UPDATE habitaciones SET idOfertaEspecial=? WHERE idHabitacion=?";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1,idOferta);
            ps.setInt(2,idHabitacion);

            
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
    
    
    public int setActualizar(Habitacion h){
        String sql="UPDATE habitaciones SET nombreHabitacion=?, estado=?, tarifa=?, descripcionBreve=?, descripcionDetallada=?, idTipoHabitacion=?, idHotel=? WHERE idHabitacion=?";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1,h.getNombreHabitacion());
            ps.setString(2,h.getEstado());
            ps.setDouble(3,h.getTarifa());
            ps.setString(4,h.getDescripcionBreve());
            ps.setString(5,h.getDescripcionDetallada());
            ps.setInt(6,h.getTipoHabitacion().getIdTipoHabitacion());
            ps.setInt(7,h.getHotel().getIdHotel());
            ps.setInt(8,h.getIdHabitacion());


            
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
    
    
    public int setAgregarImagenes(int idHabitacion, List<byte[]> imagenes){
        String sql = "INSERT INTO imagenes (idHabitacion, imagen) VALUES (?, ?)";
       
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            for (byte[] imagen : imagenes) {
                ps.setInt(1, idHabitacion);
                ps.setBytes(2, imagen); //dato binario
                ps.addBatch(); // Añadir al batch
            }
            
            ps.executeBatch();
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
    
    public int setActualizarImagenes(int idHabitacion, List<byte[]> imagenes) {
        String sqlDelete = "DELETE FROM imagenes WHERE idHabitacion = ?";
        String sqlInsert = "INSERT INTO imagenes (idHabitacion, imagen) VALUES (?, ?)";

        try {
            con = conectar.getConnection();
            con.setAutoCommit(false); // para asegurarse de que, si ocurre algún error durante la eliminación o la inserción de las nuevas imágenes, se puede hacer un rollback para mantener la consistencia de los datos.

           
            ps = con.prepareStatement(sqlDelete);
            ps.setInt(1, idHabitacion);
            ps.executeUpdate();

            
            ps = con.prepareStatement(sqlInsert);
            for (byte[] imagen : imagenes) {
                ps.setInt(1, idHabitacion);
                ps.setBytes(2, imagen);
                ps.addBatch();
            }

            ps.executeBatch();
            con.commit(); // Confirmar transacción
            return 1;

        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback(); // Revertir cambios en caso de error
                }
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(null, rollbackEx.toString(), "Error de rollback", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, e.toString(), "Error de actualización", JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString(), "Error al cerrar conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
     public int ultimoId() {
        String sql = "SELECT COUNT(*) FROM habitaciones";
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
