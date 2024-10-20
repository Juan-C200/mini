/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import modelo.Habitacion;
import modelo.HabitacionDao;
import modelo.Hotel;
import modelo.HotelDao;
import modelo.Usuario;
import vista.RegistrarOfertaV;

/**
 *
 * @author Usuario
 */
public class RegistrarOfertaC implements ActionListener{
    RegistrarOfertaV registrarOfertaV = new RegistrarOfertaV();
    Usuario usuario = new Usuario();
    HabitacionDao habitacionDao = new HabitacionDao();
    HotelDao hotelDao = new HotelDao();
    List<Habitacion> habitaciones = new ArrayList<>();
    int idHotel;
    String[] listaH;
    String temp;
    public RegistrarOfertaC(RegistrarOfertaV registrarOfertaV, Usuario usuario) {
        this.usuario = usuario;
        this.registrarOfertaV = registrarOfertaV;
        List<Hotel> hoteles = hotelDao.listar();
        for(int i = 0; i < hoteles.size(); i++) {
            if(hoteles.get(i).getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                this.habitaciones = habitacionDao.listarPorHotel(hoteles.get(i).getIdHotel());
                break;
            }
        }
        
        listaH = new String[habitaciones.size()];
        
        
        for(int x=0;x<habitaciones.size();x++){
            
            temp = habitaciones.get(x).getNombreHabitacion()+" - "+habitaciones.get(x).getHotel().getNombreHotel();
            listaH[x] = temp;
        }
        System.out.println("tamaño "+listaH.length);
        this.registrarOfertaV.lista = new JComboBox(listaH);
        
        this.registrarOfertaV.panelCentro.add(this.registrarOfertaV.lista);
        this.registrarOfertaV.bcancelar.addActionListener(this);
        this.registrarOfertaV.bagregar.addActionListener(this);

        
        this.registrarOfertaV.setExtendedState(6);
        this.registrarOfertaV.setVisible(true);
        this.registrarOfertaV.setDefaultCloseOperation(3);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
