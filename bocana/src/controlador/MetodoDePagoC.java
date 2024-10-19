/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Habitacion;
import modelo.Usuario;
import vista.AlojamientosV;
import vista.MetodoDePagoV;
import vista.ResenaV;
import vista.ReservaV;
import vista.TarjetaV;

/**
 *
 * @author estud
 */
public class MetodoDePagoC implements ActionListener {

    MetodoDePagoV metodoDePagoV = new MetodoDePagoV();
    String metodo;
    
    Usuario usuario = new Usuario();
    Habitacion habitacion = new Habitacion();

    public MetodoDePagoC(MetodoDePagoV metodoDePagoV, Usuario usuario, Habitacion habitacion) {
        this.metodoDePagoV = metodoDePagoV;
        this.usuario=usuario;
        this.habitacion=habitacion;
        
        this.metodoDePagoV.cancelar.addActionListener(this);
        this.metodoDePagoV.continuar.addActionListener(this);
        this.metodoDePagoV.setExtendedState(6);
        this.metodoDePagoV.setVisible(true);
        this.metodoDePagoV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (metodoDePagoV.lista.getSelectedItem().toString() != "") {
            if (e.getSource() == metodoDePagoV.continuar) {
                
                    if(metodoDePagoV.lista.getSelectedItem().toString().equals("Tarjeta")){
                        TarjetaV tarjetaV = new TarjetaV();
                        TarjetaC tarjetaC = new TarjetaC(tarjetaV,usuario,habitacion);
                        metodoDePagoV.setVisible(false);
                    }else if(metodoDePagoV.lista.getSelectedItem().toString().equals("Efectivo")){
                        ReservaV reservaV = new ReservaV();
                        ReservaC reservaC = new ReservaC(reservaV,usuario,habitacion);
                        metodoDePagoV.setVisible(false);
                    }
            } 
             
        }


        if (e.getSource() == metodoDePagoV.cancelar) {
                ResenaV resenaV = new ResenaV();
                ResenaC resenaC = new ResenaC(resenaV, usuario, habitacion);
                metodoDePagoV.setVisible(false);

        if (e.getSource() == metodoDePagoV.cancelar) {
            
//                        AlojamientosV aloja = new AlojamientosV();
//                        AlojamientosC al = new AlojamientosC(aloja);

                        
        }
    }
}
}