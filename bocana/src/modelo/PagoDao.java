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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    
    public int setAgregar(Pago p){
        String sql = "INSERT INTO pagos(idPago, descuento, monto,metodoPago, valorFinal, fecha, id_usuario) VALUES (?,?,?,?,?,?,?)";
       
       try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           
           
           ps.setInt(1, p.getIdPago());
           ps.setDouble(2, p.getDescuento());
           ps.setDouble(3, p.getMonto());
           ps.setString(4, p.getMetodo());
           ps.setInt(5,p.getId_usuario());
           ps.setDate(6,  new java.sql.Date(p.getFecha().getTime()));
           ps.setInt(7, p.getId_usuario());
           
           
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
    
    public Oferta buscarOferta(int id) {
        try {
            String sql = "SELECT * FROM ofertas_especiales WHERE idOfertaEspecial=" + id;
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            Oferta o = new Oferta();
            rs = ps.executeQuery();
            while (rs.next()) {
                o.setIdOfertaEspecial(rs.getInt(1));
                o.setDescuento(rs.getDouble(2));
                o.setFechaInicio(rs.getDate(3));
                o.setFechaFin(rs.getDate(4));
            }

            return o;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de insercion" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return null;
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
    
    public int ultimoId() {
        String sql = "SELECT COUNT(*) FROM pagos";
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
    
    public ArrayList buscarTarjeta(int id_usu){
       String tarjeta="", nombre, apellido;
       String numT;
       String sql = "SELECT tarjeta.numTarjeta, tarjeta.nombrePropietario, tarjeta.apellidoPropietario FROM tarjeta JOIN usuarios ON tarjeta.idUsuario=usuarios.idUsuario WHERE usuarios.idUsuario="+id_usu;
       ArrayList <String> tarjetas  = new ArrayList<String>();
       
       try{
                con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
                 while(rs.next()){
           
           numT=(rs.getString(1));
           nombre=(rs.getString(2));
           apellido=(rs.getString(3));
           
           tarjeta = numT + " - " + nombre + " " + apellido;
           
           tarjetas.add(tarjeta);
                 }

              
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString(),"Error de busqueda"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
           
       } finally {
           try{
               if(con!=null){
                   con.close();
               }
           } catch (SQLException sqle){
               JOptionPane.showMessageDialog(null, sqle.toString());
               
           }
       }
            return tarjetas;
   }
    
    }

