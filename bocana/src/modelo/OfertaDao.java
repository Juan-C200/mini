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
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author estud
 */
public class OfertaDao {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int setAgregar(Oferta o) {
        try {
            String sql = "INSERT INTO ofertas_especiales(idOfertaEspecial, descuento, fechaInicio, fechaFin) VALUES (?,?,?,?)";
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, o.getIdOfertaEspecial());
            ps.setInt(2, o.getDescuento());
            ps.setDate(3, (Date) o.getFechaInicio());
            ps.setDate(4, (Date) o.getFechaFin());

            ps.executeUpdate();
            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de insercion" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
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

    public int ultimoId() {
        String sql = "SELECT COUNT(*) FROM ofertas_especiales";
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
