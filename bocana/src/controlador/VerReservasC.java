/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Hotel;
import modelo.HotelDao;
import modelo.Reserva;
import modelo.ReservaDao;
import modelo.Usuario;
import vista.UsuarioV;
import vista.VerReservasV;

/**
 *
 * @author Usuario
 */
public class VerReservasC implements ActionListener{
    VerReservasV verReservasV = new VerReservasV();
    Usuario usuario = new Usuario();
    Hotel hotel = new Hotel();
    HotelDao hotelDao = new HotelDao();
    ReservaDao reservaDao = new ReservaDao();
    Reserva reserva;
    List<Reserva> reservas;
    
    public VerReservasC(VerReservasV verReservasV, Usuario usuario){
        this.verReservasV = verReservasV;
        this.usuario = usuario;
        this.reserva = new Reserva();
        reservas = new ArrayList<>();  

        
        if(usuario.getIdRol() == 4) {
            List<Hotel> hoteles = hotelDao.listar();
            for(int i = 0; i < hoteles.size(); i++) {
                if(hoteles.get(i).getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                    reservas = reservaDao.listarPorHotel(hoteles.get(i).getIdHotel());
                    break;
                }
            }
        } else {
            reservas = reservaDao.listarPorUsuario(usuario.getIdUsuario());
        }

    

        
        JPanel panel = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(2, 10, 2, 20);
        gbc.anchor = GridBagConstraints.WEST;
        
        JPanel panelPosicion = new JPanel();
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
        panelPosicion.setLayout(flow);
        panelPosicion.setPreferredSize(new Dimension(200,100));
        
        JLabel lposicion = new JLabel();
        lposicion.setText("Posicion");
        lposicion.setFont(new Font("Times New Roman", 1, 30));
        
        panelPosicion.add(lposicion);
        gbc.gridx = 0;
        panel.add(panelPosicion,gbc);

        JPanel panelfechaInicio = new JPanel();
        flow = new FlowLayout(FlowLayout.LEFT);
        panelfechaInicio.setLayout(flow);
        panelfechaInicio.setPreferredSize(new Dimension(200,100));
        
        JLabel lfechaInicio = new JLabel();
        lfechaInicio.setText("Fecha inicio");
        lfechaInicio.setFont(new Font("Times New Roman", 1, 30));
        
        panelfechaInicio.add(lfechaInicio);
        gbc.gridx = 1;
        panel.add(panelfechaInicio,gbc);
        
        JPanel panelfechaFin = new JPanel();
        flow = new FlowLayout(FlowLayout.LEFT);
        panelfechaFin.setLayout(flow);
        panelfechaFin.setPreferredSize(new Dimension(200,100));

        JLabel lfechaFin = new JLabel();
        lfechaFin.setText("Fecha fin");
        lfechaFin.setFont(new Font("Times New Roman", 1, 30));

        panelfechaFin.add(lfechaFin);
        gbc.gridx = 2;
        panel.add(panelfechaFin,gbc);
        
        this.verReservasV.panelestado = new JPanel();
        flow = new FlowLayout(FlowLayout.LEFT);
        this.verReservasV.panelestado.setLayout(flow);
        this.verReservasV.panelestado.setPreferredSize(new Dimension(200,100));
        
        JLabel lestado = new JLabel();
        lestado.setText("Estado");
        lestado.setFont(new Font("Times New Roman", 1, 30));

       this.verReservasV. panelestado.add(lestado);
        gbc.gridx = 3;
        panel.add(this.verReservasV.panelestado,gbc);
        
        JPanel panelhabitacion = new JPanel();
        flow = new FlowLayout(FlowLayout.LEFT);
        panelhabitacion.setLayout(flow);
        panelhabitacion.setPreferredSize(new Dimension(200,100));
        
        JLabel lhabitacion = new JLabel();
        lhabitacion.setText("Habitacion");
        lhabitacion.setFont(new Font("Times New Roman", 1, 30));
        
        panelhabitacion.add(lhabitacion);

        gbc.gridx = 4;
        panel.add(panelhabitacion,gbc);
        
        if(usuario.getIdRol()==4){
            JPanel panelUsuario = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelUsuario.setLayout(flow);
            panelUsuario.setPreferredSize(new Dimension(200,100));

            JLabel lusuario = new JLabel();
            lusuario.setText("Usuario");
            lusuario.setFont(new Font("Times New Roman", 1, 30));

            panelUsuario.add(lusuario);
            
            gbc.gridx = 5;
            panel.add(panelUsuario,gbc);
        }else{
            JPanel panelhotel = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelhotel.setLayout(flow);
            panelhotel.setPreferredSize(new Dimension(200,100));

            JLabel lhotel = new JLabel();
            lhotel.setText("Hotel");
            lhotel.setFont(new Font("Times New Roman", 1, 30));

            panelhotel.add(lhotel);

            gbc.gridx = 5;
            panel.add(panelhotel,gbc);
        }
        JPanel panelBoton = new JPanel();
        flow = new FlowLayout(FlowLayout.LEFT);
        panelBoton.setLayout(flow);
        panelBoton.setPreferredSize(new Dimension(200,100));
        
        JLabel lboton = new JLabel();
        lboton.setText("Cancelar");
        lboton.setFont(new Font("Times New Roman", 1, 30));
        
        
        panelBoton.add(lboton);
        
        gbc.gridx = 6;
        panel.add(panelBoton,gbc);
        gbc.gridy = 0;
        gbc.gridx = 0;
        this.verReservasV.panelReservas.add(panel,gbc);
        
        for(int i =0;i<reservas.size();i++){
            panel = new JPanel();
            gridbag = new GridBagLayout();
            panel.setLayout(gridbag);
            
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.insets = new Insets(2, 10, 2, 10);
            gbc.anchor = GridBagConstraints.CENTER;
            
            panelPosicion = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelPosicion.setLayout(flow);
            panelPosicion.setPreferredSize(new Dimension(200,100));
            
            lposicion = new JLabel();
            int p = i+1;
            lposicion.setText(Integer.toString(p));
            lposicion.setFont(new Font("Times New Roman", 0, 25));
            
            panelPosicion.add(lposicion);
            
            gbc.gridx = 0;
            gbc.gridy = p;
            panel.add(panelPosicion,gbc);
            
            panelfechaInicio = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelfechaInicio.setLayout(flow);
            panelfechaInicio.setPreferredSize(new Dimension(200,100));
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
            String fechaComoString = formato.format(reservas.get(i).getFechaInicio());
            
            lfechaInicio = new JLabel();
            lfechaInicio.setText(fechaComoString);
            lfechaInicio.setFont(new Font("Times New Roman", 0, 25));
            
            panelfechaInicio.add(lfechaInicio);
            
            gbc.gridx = 1;
            gbc.gridy = p;
            panel.add(panelfechaInicio,gbc);
            
            panelfechaFin  = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelfechaFin.setLayout(flow);
            panelfechaFin.setPreferredSize(new Dimension(200,100));
            
            String fechaComoStringfin = formato.format(reservas.get(i).getFechaFin());
            
            lfechaFin = new JLabel();
            lfechaFin.setText(fechaComoStringfin);
            lfechaFin.setFont(new Font("Times New Roman", 0, 25));
            
            panelfechaFin.add(lfechaFin);
            
            gbc.gridx = 2;
            gbc.gridy = p;
            panel.add(panelfechaFin,gbc);
            
            this.verReservasV.panelestado  = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            this.verReservasV.panelestado.setLayout(flow);
            this.verReservasV.panelestado.setPreferredSize(new Dimension(200,100));
            
            lestado = new JLabel();
            lestado.setText(reservas.get(i).getEstado());
            lestado.setFont(new Font("Times New Roman", 0, 25));
            
            this.verReservasV.panelestado.add(lestado);
            
            gbc.gridx = 3;
            gbc.gridy = p;
            panel.add(this.verReservasV.panelestado,gbc);
            
            panelhabitacion  = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelhabitacion.setLayout(flow);
            panelhabitacion.setPreferredSize(new Dimension(200,100));
            
            lhabitacion = new JLabel();
            lhabitacion.setText(reservas.get(i).getHabitacion().getNombreHabitacion());
            lhabitacion.setFont(new Font("Times New Roman", 0, 25));
            
            panelhabitacion.add(lhabitacion);
            
            gbc.gridx = 4;
            gbc.gridy = p;
            panel.add(panelhabitacion,gbc);
            
            if(usuario.getIdRol()==4){
                JPanel panelUsuario  = new JPanel();
                flow = new FlowLayout(FlowLayout.LEFT);
                panelUsuario.setLayout(flow);
                panelUsuario.setPreferredSize(new Dimension(200,100));

                JLabel lusuario = new JLabel();
                lusuario.setText(reservas.get(i).getUsuario().getNombre1()+" "+reservas.get(i).getUsuario().getApellido1());
                lusuario.setFont(new Font("Times New Roman", 0, 25));

                panelUsuario.add(lusuario);

                gbc.gridx = 5;
                gbc.gridy = p;
                panel.add(panelUsuario,gbc);
            }else{
                JLabel panelhotel  = new JLabel();
                flow = new FlowLayout(FlowLayout.LEFT);
                panelhotel.setLayout(flow);
                panelhotel.setPreferredSize(new Dimension(200,100));

                JLabel lhotel = new JLabel();
                lhotel.setText(reservas.get(i).getHabitacion().getHotel().getNombreHotel());
                lhotel.setFont(new Font("Times New Roman", 0, 25));

                panelhotel.add(lhotel);

                gbc.gridx = 5;
                gbc.gridy = p;
                panel.add(panelhotel,gbc);
            }
            
            panelBoton = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelBoton.setLayout(flow);
            panelBoton.setPreferredSize(new Dimension(200,100));

            JButton boton = new JButton("Cancelar");
            boton.setFont(new Font("Times New Roman", 0, 20));
            boton.addActionListener(this);
            boton.setContentAreaFilled(false);
            boton.setForeground(Color.BLACK);
            boton.putClientProperty("valor", reservas.get(i).getIdReserva());

            panelBoton.add(boton);

            if(reservas.get(i).getEstado().equals("Cancelada")){
                boton.setEnabled(false);
            }
            
            gbc.gridx = 6;
            panel.add(panelBoton,gbc);

                gbc.gridx = 0;
                gbc.gridy = p;
                gbc.insets = new Insets(2, 10, 2, 10);
                this.verReservasV.panelReservas.add(panel,gbc);
            }
        
        
        this.verReservasV.bvolver.putClientProperty("valor", 0);
        this.verReservasV.bvolver.addActionListener(this);
        this.verReservasV.setExtendedState(6);
        this.verReservasV.setVisible(true);
        this.verReservasV.setDefaultCloseOperation(3);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) { // Verifica si el evento es una instancia de JButton
            JButton boton = (JButton) e.getSource();

            if (boton.getClientProperty("valor").equals(0)) {
                UsuarioV usuarioV = new UsuarioV();
                UsuarioC usuarioC = new UsuarioC(usuarioV, usuario);
                verReservasV.setVisible(false);
            } else {
                Integer idReserva = (Integer) boton.getClientProperty("valor");
                for (Reserva r : reservas) {
                    if (r.getIdReserva()==idReserva) {
                        r.setEstado("Cancelada");
                        reservaDao.setActualizar(r);
                        boton.setEnabled(false);
                        break;
                    }
                }

                actualizarPanelReservas();
            }
        }
    }

    private void actualizarPanelReservas() {
       
        verReservasV.panelReservas.removeAll();

        
        GridBagLayout gridbag = new GridBagLayout();
        verReservasV.panelReservas.setLayout(gridbag);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 2, 10);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;

        
        JPanel panelPosicion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPosicion.setPreferredSize(new Dimension(200, 100));
        JLabel lposicion = new JLabel("Posición");
        lposicion.setFont(new Font("Times New Roman", 1, 30));
        panelPosicion.add(lposicion);
        gbc.gridx = 0;
        gbc.gridy = 0;
        verReservasV.panelReservas.add(panelPosicion, gbc);

        JPanel panelfechaInicio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelfechaInicio.setPreferredSize(new Dimension(200, 100));
        JLabel lfechaInicio = new JLabel("Fecha Inicio");
        lfechaInicio.setFont(new Font("Times New Roman", 1, 30));
        panelfechaInicio.add(lfechaInicio);
        gbc.gridx = 1;
        verReservasV.panelReservas.add(panelfechaInicio, gbc);

        JPanel panelfechaFin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelfechaFin.setPreferredSize(new Dimension(200, 100));
        JLabel lfechaFin = new JLabel("Fecha Fin");
        lfechaFin.setFont(new Font("Times New Roman", 1, 30));
        panelfechaFin.add(lfechaFin);
        gbc.gridx = 2;
        verReservasV.panelReservas.add(panelfechaFin, gbc);

        JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEstado.setPreferredSize(new Dimension(200, 100));
        JLabel lestado = new JLabel("Estado");
        lestado.setFont(new Font("Times New Roman", 1, 30));
        panelEstado.add(lestado);
        gbc.gridx = 3;
        verReservasV.panelReservas.add(panelEstado, gbc);

        JPanel panelHabitacion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHabitacion.setPreferredSize(new Dimension(200, 100));
        JLabel lhabitacion = new JLabel("Habitación");
        lhabitacion.setFont(new Font("Times New Roman", 1, 30));
        panelHabitacion.add(lhabitacion);
        gbc.gridx = 4;
        verReservasV.panelReservas.add(panelHabitacion, gbc);

        if (usuario.getIdRol() == 4) {
            JPanel panelUsuario = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelUsuario.setPreferredSize(new Dimension(200, 100));
            JLabel lusuario = new JLabel("Usuario");
            lusuario.setFont(new Font("Times New Roman", 1, 30));
            panelUsuario.add(lusuario);
            gbc.gridx = 5;
            verReservasV.panelReservas.add(panelUsuario, gbc);
        } else {
            JPanel panelHotel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelHotel.setPreferredSize(new Dimension(200, 100));
            JLabel lhotel = new JLabel("Hotel");
            lhotel.setFont(new Font("Times New Roman", 1, 30));
            panelHotel.add(lhotel);
            gbc.gridx = 5;
            verReservasV.panelReservas.add(panelHotel, gbc);
        }

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBoton.setPreferredSize(new Dimension(200, 100));
        JLabel lboton = new JLabel("Cancelar");
        lboton.setFont(new Font("Times New Roman", 1, 30));
        panelBoton.add(lboton);
        gbc.gridx = 6;
        verReservasV.panelReservas.add(panelBoton, gbc);

        
        for (int i = 0; i < reservas.size(); i++) {
            gbc.gridy = i + 1; // Desplazar hacia abajo para las filas de datos

            
            panelPosicion = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelPosicion.setPreferredSize(new Dimension(200, 100));
            lposicion = new JLabel(String.valueOf(i + 1));
            lposicion.setFont(new Font("Times New Roman", 0, 25));
            panelPosicion.add(lposicion);
            gbc.gridx = 0;
            verReservasV.panelReservas.add(panelPosicion, gbc);

            
            panelfechaInicio = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelfechaInicio.setPreferredSize(new Dimension(200, 100));
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
            String fechaComoString = formato.format(reservas.get(i).getFechaInicio());
            
            lfechaInicio = new JLabel(fechaComoString);
            lfechaInicio.setFont(new Font("Times New Roman", 0, 25));
            panelfechaInicio.add(lfechaInicio);
            gbc.gridx = 1;
            verReservasV.panelReservas.add(panelfechaInicio, gbc);

            
            panelfechaFin = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelfechaFin.setPreferredSize(new Dimension(200, 100));
            
            String fechaComoStringfin = formato.format(reservas.get(i).getFechaFin());
            
            lfechaFin = new JLabel(fechaComoStringfin);
            lfechaFin.setFont(new Font("Times New Roman", 0, 25));
            panelfechaFin.add(lfechaFin);
            gbc.gridx = 2;
            verReservasV.panelReservas.add(panelfechaFin, gbc);

            panelEstado = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelEstado.setPreferredSize(new Dimension(200, 100));
            lestado = new JLabel(reservas.get(i).getEstado());
            lestado.setFont(new Font("Times New Roman", 0, 25));
            panelEstado.add(lestado);
            gbc.gridx = 3;
            verReservasV.panelReservas.add(panelEstado, gbc);

            
            panelHabitacion = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelHabitacion.setPreferredSize(new Dimension(200, 100));
            lhabitacion = new JLabel(reservas.get(i).getHabitacion().getNombreHabitacion());
            lhabitacion.setFont(new Font("Times New Roman", 0, 25));
            panelHabitacion.add(lhabitacion);
            gbc.gridx = 4;
            verReservasV.panelReservas.add(panelHabitacion, gbc);

            
            if (usuario.getIdRol() == 4) {
                JPanel panelUsuario = new JPanel(new FlowLayout(FlowLayout.LEFT));
                panelUsuario.setPreferredSize(new Dimension(200, 100));
                JLabel lusuario = new JLabel(reservas.get(i).getUsuario().getNombre1() + " " + reservas.get(i).getUsuario().getApellido1());
                lusuario.setFont(new Font("Times New Roman", 0, 25));
                panelUsuario.add(lusuario);
                gbc.gridx = 5;
                verReservasV.panelReservas.add(panelUsuario, gbc);
            } else {
                JPanel panelHotel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                panelHotel.setPreferredSize(new Dimension(200, 100));
                JLabel lhotel = new JLabel(reservas.get(i).getHabitacion().getHotel().getNombreHotel());
                lhotel.setFont(new Font("Times New Roman", 0, 25));
                panelHotel.add(lhotel);
                gbc.gridx = 5;
                verReservasV.panelReservas.add(panelHotel, gbc);
            }

            
            panelBoton = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelBoton.setPreferredSize(new Dimension(200, 100));
            JButton boton = new JButton("Cancelar");
            boton.setFont(new Font("Times New Roman", 0, 20));
            boton.addActionListener(this);
            boton.setContentAreaFilled(false);
            boton.setForeground(Color.BLACK);
            boton.putClientProperty("valor", reservas.get(i).getIdReserva());
            panelBoton.add(boton);
            if (reservas.get(i).getEstado().equals("Cancelada")) {
                boton.setEnabled(false);
            }
            gbc.gridx = 6;
            verReservasV.panelReservas.add(panelBoton, gbc);
        }

        
        verReservasV.panelReservas.revalidate();
        verReservasV.panelReservas.repaint();
    }




}
