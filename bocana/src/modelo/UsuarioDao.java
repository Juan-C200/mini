/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Usuario;

public class UsuarioDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
    public List listar() {
        ArrayList<Usuario> datosUsuario = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt(1));
                u.setDocumento(rs.getInt(2));
                u.setNombre1(rs.getString(3));
                u.setNombre2(rs.getString(4));
                u.setApellido1(rs.getString(5));
                u.setApellido2(rs.getString(6));
                u.setCorreo(rs.getString(7));
                u.setTelefono(rs.getString(8));
                u.setDireccion(rs.getString(9));
                u.setContrasena(rs.getString(10));
                u.setIdRol(rs.getInt(11));
                datosUsuario.add(u);
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
        return datosUsuario;
    }
    
    public int setAgregar (Usuario u){
        String sql = "INSERT INTO usuarios(documento, nombre1, nombre2, apellido1, apellido2, correo, telefono, direccion, contrasena, idRol) VALUES (?,?,?,?,?,?,?,?,?,?)";
       
        try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           

           
           ps.setInt(1, u.getDocumento());
           ps.setString(2,u.getNombre1());
           ps.setString(3,u.getNombre2());
           ps.setString(4, u.getApellido1());
           ps.setString(5, u.getApellido2());
           ps.setString(6, u.getCorreo());
           ps.setString(7, u.getTelefono());
           ps.setString(8, u.getDireccion());
           ps.setString(9, u.getContrasena());
           ps.setInt(10, u.getIdRol());
           
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
    
    public int setActualizar(Usuario u){
        String sql="UPDATE usuarios SET nombre1=?, nombre2=?, apellido1=?, apellido2=?, telefono=?, correo=?, direccion=?, contrasena=?, idRol=? WHERE idUsuario=?";
        
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1,u.getNombre1());
            ps.setString(2,u.getNombre2());
            ps.setString(3,u.getApellido1());
            ps.setString(4,u.getApellido2());
            ps.setString(5,u.getTelefono());
            ps.setString(6,u.getCorreo());
            ps.setString(7,u.getDireccion());
            ps.setString(8,u.getContrasena());
            ps.setInt(9,u.getIdRol());
            ps.setInt(10,u.getIdUsuario());
            
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
   
   public ArrayList buscarTarjeta(int id_usu){
       String tarjeta="", nombre, apellido;
       int id;
       String sql = "SELECT tarjeta.id, tarjeta.nombrePropietario, tarjeta.apellidoPropietario FROM tarjeta JOIN usuarios WHERE tarjeta.id_usuario=usuarios.idUsuario && usuarios.idUsuario="+id_usu;
       ArrayList <String> tarjetas  = new ArrayList<String>();
       
       try{
                con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
                 while(rs.next()){
           
           id=(rs.getInt(1));
           nombre=(rs.getString(2));
           apellido=(rs.getString(3));
           
           tarjeta = id + " - " + nombre + " " + apellido;
           
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

