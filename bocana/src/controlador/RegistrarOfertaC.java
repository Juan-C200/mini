/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Habitacion;
import modelo.HabitacionDao;
import modelo.Hotel;
import modelo.HotelDao;
import modelo.Oferta;
import modelo.OfertaDao;
import modelo.Usuario;
import vista.RegistrarOfertaV;
import vista.UsuarioV;

/**
 *
 * @author Usuario
 */
public class RegistrarOfertaC implements ActionListener{
    RegistrarOfertaV registrarOfertaV = new RegistrarOfertaV();
    Usuario usuario = new Usuario();
    HabitacionDao habitacionDao = new HabitacionDao();
    HotelDao hotelDao = new HotelDao();
    Oferta oferta = new Oferta();
    OfertaDao ofertaDao = new OfertaDao();
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
        
        if (e.getSource() == registrarOfertaV.bcancelar) {
            UsuarioV usuarioV = new UsuarioV();
            UsuarioC usuarioC = new UsuarioC(usuarioV, usuario);
            registrarOfertaV.setVisible(false);
        }
        
        if (e.getSource() == registrarOfertaV.bagregar) {

            if (!registrarOfertaV.tdescuento.getText().isBlank()
                && !registrarOfertaV.fechaInicio.getDate().toString().isBlank()
                && !registrarOfertaV.fechaFin.getDate().toString().isBlank()

                ) {

                setAdd();
                
                UsuarioV usuarioV = new UsuarioV();
                UsuarioC usuarioC = new UsuarioC(usuarioV, usuario);
                registrarOfertaV.setVisible(false);

                JOptionPane.showMessageDialog(registrarOfertaV, "Es bien");
                
                
            } else {

                JOptionPane.showMessageDialog(registrarOfertaV, "Faltan datos por ingresar");

            }
        }
    }
    
    public void setAdd() {
        int resultado = 0;
        int r = 1;
        double descuento=0;
        Date fechaInicio = registrarOfertaV.fechaInicio.getDate();
        Date fechaFin = registrarOfertaV.fechaFin.getDate();
        int idHabitacion = registrarOfertaV.lista.getSelectedIndex();
        
        
        
        try {

            descuento = Double.parseDouble(registrarOfertaV.tdescuento.getText());

        } catch (NumberFormatException eN) {
            r = 0;
            JOptionPane.showMessageDialog(registrarOfertaV, "Error en los datos numéricos: " + eN.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        int idOferta = ofertaDao.ultimoId()+1;
        
        oferta.setIdOfertaEspecial(idOferta);
        oferta.setDescuento(descuento);
        oferta.setFechaInicio(fechaInicio);
        oferta.setFechaFin(fechaFin);
        


        
        
        if (ofertaDao.setAgregar(oferta)==1) {
            JOptionPane.showMessageDialog(registrarOfertaV, "Se inserto la oferta");
            habitacionDao.setActualizarOferta(idHabitacion, idOferta);

        } else {
            JOptionPane.showMessageDialog(registrarOfertaV, "no se inserto la oferta");
        }
        
        

    }
}
