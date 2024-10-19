/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package index;

import controlador.AlojamientosC;
import controlador.IniciarSesionC;
import controlador.RegistrarC;
import controlador.RegistrarHotelC;

import vista.FotosV;
import controlador.FotosC;
import controlador.HotelC;
import controlador.MetodoDePagoC;
import controlador.RegistrarHabitacionC;
import controlador.ResenaC;
import controlador.TarjetaC;
import controlador.UsuarioC;
import controlador.VerReservasC;
import javax.swing.JFrame;

import modelo.Usuario;
import modelo.UsuarioDao;
import vista.AlojamientosV;
import vista.HotelV;
import vista.IniciarSesionV;
import vista.MetodoDePagoV;
import vista.PagoV;
import vista.RegistrarHabitacionV;
import vista.RegistrarHotelV;
import vista.RegistrarV;
import vista.ResenaV;
import vista.TarjetaV;
import vista.UsuarioV;
import vista.VerReservasV;

/**
 *
 * @author Usuario
 */
public class Index {

    public static void main(String[] args) {
//        RegistrarV registrarV = new RegistrarV();
//        RegistrarC registrarC = new RegistrarC(registrarV);

//        IniciarSesionV iniciarSesionV = new IniciarSesionV();
//        IniciarSesionC iniciarSesionC = new IniciarSesionC(iniciarSesionV);
    
        HotelV hotel = new HotelV();
        HotelC hot = new HotelC(hotel);

        //    MetodoDePagoV mp = new MetodoDePagoV();
        //    MetodoDePagoC mep = new MetodoDePagoC(mp);

//        TarjetaV tarjetaV = new TarjetaV();
//        TarjetaC tarjetaC = new TarjetaC(tarjetaV);
       
//         RegistrarHotelV registrarHotelV = new RegistrarHotelV();
//        RegistrarHotelC registrarC = new RegistrarHotelC(registrarHotelV);

        //FotosV fotos = new FotosV();
        //FotosC fotosc = new FotosC(fotos); 


//        Usuario usuario = new Usuario();
//        usuario.setIdRol(3);
//        AlojamientosV aloja = new AlojamientosV();
//        AlojamientosC al = new AlojamientosC(aloja, usuario);

//    
//        AlojamientosV aloja = new AlojamientosV();
//        AlojamientosC al = new AlojamientosC(aloja, usuario);

        

//        RegistrarHabitacionV registrarV = new RegistrarHabitacionV();
//        RegistrarHabitacionC registrarC = new RegistrarHabitacionC(registrarV,5);

//        ResenaV resenaV = new ResenaV();
//        ResenaC resenaC = new ResenaC(resenaV);


//        PagoV pV = new PagoV();
//        pV.setVisible(true);
//        pV.setExtendedState(6);
//        pV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
