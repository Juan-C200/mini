/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Usuario
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDao;
import vista.AlojamientosV;
import vista.HotelV;
import vista.IniciarSesionV;
import vista.RegistrarV;

public class IniciarSesionC implements ActionListener {
    IniciarSesionV iniciarSesionV = new IniciarSesionV();
    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usuario = new Usuario();
    
    public IniciarSesionC(IniciarSesionV iniciarSesionV) {
        this.iniciarSesionV = iniciarSesionV; 
        this.iniciarSesionV.biniciarSesion.addActionListener(this);
        this.iniciarSesionV.ver.addActionListener(this);
        this.iniciarSesionV.bregistrarse.addActionListener(this);
        this.iniciarSesionV.bcancelar.addActionListener(this);
        this.iniciarSesionV.setExtendedState(6);
        this.iniciarSesionV.setVisible(true);
        this.iniciarSesionV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == iniciarSesionV.biniciarSesion) {
            String correo = iniciarSesionV.tcorreo.getText();
            String contrasena = iniciarSesionV.tcontrasena.getText();
            System.out.println(contrasena.length());
            if (iniciarSesion(correo, contrasena) == 1) {
                AlojamientosV alojamientosV = new AlojamientosV();
                AlojamientosC alojamientosC = new AlojamientosC(alojamientosV,usuario);
                iniciarSesionV.setVisible(false);
            }
        }

        
        if(e.getSource()==iniciarSesionV.bregistrarse){
            RegistrarV registrarV = new RegistrarV();
            RegistrarC registrarC = new RegistrarC(registrarV);
            iniciarSesionV.setVisible(false);

              

            if(e.getSource()==iniciarSesionV.bcancelar){
                usuario.setIdRol(3);
                AlojamientosV alojamientosV = new AlojamientosV();
                AlojamientosC alojamientosC = new AlojamientosC(alojamientosV,usuario);
                iniciarSesionV.setVisible(false);
            }
            
        }
        if(iniciarSesionV.ver.isSelected()){
                iniciarSesionV.tcontrasena.setEchoChar((char) 0);
            } else {
                iniciarSesionV.tcontrasena.setEchoChar ('*');
            }
    }
    public int iniciarSesion(String correo, String contrasena) {
    List<Usuario> datosUsuario = usuarioDao.listar();
    
    for (int i = 0; i < datosUsuario.size(); i++) {
        
        Usuario u = datosUsuario.get(i);
        
        if (u.getCorreo().equals(correo) && u.getContrasena().equals(contrasena)) {
            usuario = u;
            return 1; 
        }
        
        if (u.getCorreo().equals(correo)) {
            JOptionPane.showMessageDialog(iniciarSesionV, "Contraseña incorrecta");
            return 0;
        }
    }

    JOptionPane.showMessageDialog(iniciarSesionV, "Usuario no encontrado");
    return 0;
}
}

