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
public class TipoHabitacionDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
    public List listar() {
        ArrayList<TipoHabitacion> datosTipoHabitacion = new ArrayList<TipoHabitacion>();
        String sql = "SELECT * FROM tipos_habitaciones";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoHabitacion th = new TipoHabitacion();
                th.setIdTipoHabitacion(rs.getInt(1));
                th.setDescripcion(rs.getString(2));
                
                datosTipoHabitacion.add(th);
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
        return datosTipoHabitacion;
    }
}
