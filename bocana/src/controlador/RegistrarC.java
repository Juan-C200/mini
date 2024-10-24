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
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDao;
import vista.IniciarSesionV;
import vista.RegistrarV;

public class RegistrarC implements ActionListener {

    RegistrarV registrarV = new RegistrarV();
    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usuario = new Usuario();

    public RegistrarC(RegistrarV registrarV) {
        this.registrarV = registrarV;
        
        
        this.registrarV.bregistrar.addActionListener(this);
        this.registrarV.bcancelar.addActionListener(this);
        this.registrarV.setExtendedState(6);
        this.registrarV.setVisible(true);
        this.registrarV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarV.bregistrar) {

            if (!registrarV.tdocumento.getText().toString().isBlank()
                    && !registrarV.tnombre1.getText().toString().isBlank()
                    && !registrarV.tnombre2.getText().toString().isBlank()
                    && !registrarV.tapellido1.getText().toString().isBlank()
                    && !registrarV.tapellido2.getText().toString().isBlank()
                    && !registrarV.tcorreo.getText().toString().isBlank()
                    && !registrarV.ttelefono.getText().toString().isBlank()
                    && !registrarV.tdireccion.getText().toString().isBlank()
                    && !registrarV.tcontrasena.getText().toString().isBlank()) {

                setAdd();

                    IniciarSesionV iniciarSesionV = new IniciarSesionV();
                    IniciarSesionC iniciarSesionC = new IniciarSesionC(iniciarSesionV);
                    registrarV.setVisible(false);
            } else {

                JOptionPane.showMessageDialog(registrarV, "Faltan datos por ingresar");

            }

        }
        
        if(e.getSource()==registrarV.bcancelar){
            IniciarSesionV iniciarSesionV = new IniciarSesionV();
            IniciarSesionC iniciarSesionC = new IniciarSesionC(iniciarSesionV);
            registrarV.setVisible(false);
        }
    }

    private static final Pattern SIMPLE_EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public static void validarEmail(String email) {

        if (!SIMPLE_EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("El formato del correo electrónico es inválido.");
        }
    }

    private static final Pattern SIMPLE_ADDRESS_PATTERN = Pattern.compile("^[\\d\\w\\s.,-]+$");

    public static void validarDireccion(String direccion) {
        if (!SIMPLE_ADDRESS_PATTERN.matcher(direccion).matches()) {
            throw new IllegalArgumentException("El formato de la direccion es inválido.");
        }
    }

    private static final Pattern MEDIUM_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public static void validarContrasena(String contrasena) {
        if (!MEDIUM_PASSWORD_PATTERN.matcher(contrasena).matches()) {
            throw new IllegalArgumentException("La contraseña no cumple.");
        }
    }

    public static void validarEspaciosNumeros(String input) {
        if ((input.contains(" ") || input.matches(".\\d."))) {
            throw new IllegalArgumentException("El formato es inválido donde " + input);
        }

    }
    
    public static boolean contieneSoloNumeros(String cadena) {
        return cadena.matches("[0-9]+");
    }

     public void setAdd() {
        int resultado = 0;
        int r = 1;
        int documento = 0;

        int idRol = 2;

        try {

            documento = Integer.parseInt(registrarV.tdocumento.getText().toString());

        } catch (NumberFormatException eN) {
            r = 0;
            JOptionPane.showMessageDialog(registrarV, "Error en los datos numéricos: " + eN.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String correo = "";

        try {
            validarEmail(registrarV.tcorreo.getText().toString());
            correo = registrarV.tcorreo.getText().toString();

        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarV, "Error: " + e.getMessage());
        }

        String nombre1 = "";
        String nombre2 = "";
        String apellido1 = "";
        String apellido2 = "";

        try {
            nombre1 = registrarV.tnombre1.getText().toString();
            nombre2 = registrarV.tnombre2.getText().toString();
            apellido1 = registrarV.tapellido1.getText().toString();
            apellido2 = registrarV.tapellido2.getText().toString();
            validarEspaciosNumeros(nombre1);
            validarEspaciosNumeros(nombre2);
            validarEspaciosNumeros(apellido1);
            validarEspaciosNumeros(apellido2);

        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarV, "Error: " + e.getMessage());
        }

        String direccion = "";
        try {
            validarDireccion(registrarV.tdireccion.getText().toString());
            direccion = registrarV.tdireccion.getText().toString();

        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarV, "Error: " + e.getMessage());
        }
        
        String telefono ="";
        telefono=registrarV.ttelefono.getText().toString();
        contieneSoloNumeros(telefono);

        String contrasena = "";
        try {
            contrasena = registrarV.tcontrasena.getText().toString();
            validarContrasena(contrasena);
        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarV, "Error: " + e.getMessage());
        }

        usuario.setDocumento(documento);
        usuario.setNombre1(nombre1);
        usuario.setNombre2(nombre2);
        usuario.setApellido1(apellido1);
        usuario.setApellido2(apellido2);
        usuario.setCorreo(correo);
        usuario.setTelefono(telefono);
        usuario.setDireccion(direccion);
        usuario.setContrasena(contrasena);
        usuario.setIdRol(idRol);

        if (r == 1) {
            resultado = usuarioDao.setAgregar(usuario);
        }

        if (resultado == 1) {
            JOptionPane.showMessageDialog(registrarV, "Usuario registrado");
        } else {
            JOptionPane.showMessageDialog(registrarV, "Error de insercion" + JOptionPane.ERROR_MESSAGE);
        }

    }

}
