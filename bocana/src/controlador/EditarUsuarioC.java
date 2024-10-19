/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.RegistrarC.contieneSoloNumeros;
import static controlador.RegistrarC.validarContrasena;
import static controlador.RegistrarC.validarDireccion;
import static controlador.RegistrarC.validarEmail;
import static controlador.RegistrarC.validarEspaciosNumeros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDao;
import vista.EditarUsuarioV;
import vista.HotelV;
import vista.IniciarSesionV;
import vista.RegistrarV;
import vista.UsuarioV;

/**
 *
 * @author Usuario
 */
public class EditarUsuarioC implements ActionListener{
    EditarUsuarioV editarUsuarioV = new EditarUsuarioV();
    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usuario = new Usuario();
    public EditarUsuarioC(EditarUsuarioV editarUsuarioV, Usuario usuario){
        this.editarUsuarioV=editarUsuarioV;
        this.usuario=usuario;
        
        this.editarUsuarioV.tnombre1.setText(usuario.getNombre1());
        this.editarUsuarioV.tnombre2.setText(usuario.getNombre2());
        this.editarUsuarioV.tapellido1.setText(usuario.getApellido1());
        this.editarUsuarioV.tapellido2.setText(usuario.getApellido2());
        this.editarUsuarioV.tcorreo.setText(usuario.getCorreo());
        this.editarUsuarioV.ttelefono.setText(usuario.getTelefono());
        this.editarUsuarioV.tdireccion.setText(usuario.getDireccion());
        this.editarUsuarioV.tcontrasena.setText(usuario.getContrasena());
        
        
        this.editarUsuarioV.beditar.addActionListener(this);
        this.editarUsuarioV.bcancelar.addActionListener(this);
        this.editarUsuarioV.setExtendedState(6);
        this.editarUsuarioV.setVisible(true);
        this.editarUsuarioV.setDefaultCloseOperation(3);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editarUsuarioV.beditar) {

            if (!editarUsuarioV.tnombre1.getText().toString().isBlank()
                    && !editarUsuarioV.tnombre2.getText().toString().isBlank()
                    && !editarUsuarioV.tapellido1.getText().toString().isBlank()
                    && !editarUsuarioV.tapellido2.getText().toString().isBlank()
                    && !editarUsuarioV.tcorreo.getText().toString().isBlank()
                    && !editarUsuarioV.ttelefono.getText().toString().isBlank()
                    && !editarUsuarioV.tdireccion.getText().toString().isBlank()
                    && !editarUsuarioV.tcontrasena.getText().toString().isBlank()) {

                setActualizar();

                    UsuarioV usuarioV = new UsuarioV();
                    UsuarioC usuarioC = new UsuarioC(usuarioV, usuario);
                    editarUsuarioV.setVisible(false);
            } else {

                JOptionPane.showMessageDialog(editarUsuarioV, "Faltan datos por ingresar");

            }

        }
        
        if(e.getSource()==editarUsuarioV.bcancelar){
            UsuarioV usuarioV = new UsuarioV();
            UsuarioC usuarioC = new UsuarioC(usuarioV, usuario);
        }
    }
    
    public void setActualizar() {
        int resultado = 0;
        int r = 1;

        String correo = "";

        try {
            validarEmail(editarUsuarioV.tcorreo.getText().toString());
            correo = editarUsuarioV.tcorreo.getText().toString();

        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(editarUsuarioV, "Error: " + e.getMessage());
        }

        String nombre1 = "";
        String nombre2 = "";
        String apellido1 = "";
        String apellido2 = "";

        try {
            nombre1 = editarUsuarioV.tnombre1.getText().toString();
            nombre2 = editarUsuarioV.tnombre2.getText().toString();
            apellido1 = editarUsuarioV.tapellido1.getText().toString();
            apellido2 = editarUsuarioV.tapellido2.getText().toString();
            validarEspaciosNumeros(nombre1);
            validarEspaciosNumeros(nombre2);
            validarEspaciosNumeros(apellido1);
            validarEspaciosNumeros(apellido2);

        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(editarUsuarioV, "Error: " + e.getMessage());
        }

        String direccion = "";
        try {
            validarDireccion(editarUsuarioV.tdireccion.getText().toString());
            direccion = editarUsuarioV.tdireccion.getText().toString();

        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(editarUsuarioV, "Error: " + e.getMessage());
        }
        
        String telefono ="";
        telefono=editarUsuarioV.ttelefono.getText().toString();
        contieneSoloNumeros(telefono);

        String contrasena = "";
        try {
            contrasena = editarUsuarioV.tcontrasena.getText().toString();
            validarContrasena(contrasena);
        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(editarUsuarioV, "Error: " + e.getMessage());
        }

        usuario.setNombre1(nombre1);
        usuario.setNombre2(nombre2);
        usuario.setApellido1(apellido1);
        usuario.setApellido2(apellido2);
        usuario.setCorreo(correo);
        usuario.setTelefono(telefono);
        usuario.setDireccion(direccion);
        usuario.setContrasena(contrasena);

        if (r == 1) {
            resultado = usuarioDao.setActualizar(usuario);
        }

        if (resultado == 1) {
            JOptionPane.showMessageDialog(editarUsuarioV, "Se guardaron los cambios");
        } else {
            JOptionPane.showMessageDialog(editarUsuarioV, "Error de actualizacion" + JOptionPane.ERROR_MESSAGE);
        }

    }
}
