/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.PagoV;

/**
 *
 * @author estud
 */
public class PagoC implements ActionListener{
    public PagoV pV = new PagoV();
    public PagoC(PagoV p){
        this.pV = p;
        this.pV.cancelar.addActionListener(this);
        this.pV.continuar.addActionListener(this);
        this.pV.listaTarjetas.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
