/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Habitacion;
import modelo.Usuario;
import vista.PagoV;
import vista.TarjetaV;

/**
 *
 * @author estud
 */
public class PagoC implements ActionListener{
    public PagoV pV = new PagoV();
    private Usuario usuario = new Usuario();
    private Habitacion habitacion = new Habitacion();
    
    public PagoC(PagoV p, Usuario u, Habitacion h, String s){
        this.pV = p;
        this.pV.cancelar.addActionListener(this);
        this.pV.continuar.addActionListener(this);
        this.pV.agregarTarjeta.addActionListener(this);
        this.pV.listaTarjetas.addActionListener(this);
         this.pV.setExtendedState(6);
        this.pV.setVisible(true);
        this.pV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==pV.agregarTarjeta){
            TarjetaV tv = new TarjetaV();
            TarjetaC tc = new TarjetaC(tv, usuario, habitacion);
        }
    }
}
