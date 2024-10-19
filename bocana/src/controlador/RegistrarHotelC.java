/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.RegistrarC.validarDireccion;
import static controlador.RegistrarC.validarEspaciosNumeros;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Habitacion;
import modelo.HabitacionDao;
import modelo.Hotel;
import modelo.HotelDao;
import modelo.TipoServicio;
import modelo.TipoServicioDao;
import modelo.Usuario;
import modelo.UsuarioDao;
import vista.RegistrarHabitacionV;
import vista.RegistrarHotelV;
import vista.UsuarioV;

/**
 *
 * @author Usuario
 */
public class RegistrarHotelC implements ActionListener {

    RegistrarHotelV registrarHotelV = new RegistrarHotelV();
    Hotel hotel = new Hotel();
    HotelDao hotelDao = new HotelDao();
    Usuario usuario = new Usuario();
    UsuarioDao usuarioDao;
    
    HabitacionDao habitacionDao =  new HabitacionDao();
    TipoServicioDao tipoServicioDao = new TipoServicioDao();
    List<TipoServicio> datosTipoServicioDao = tipoServicioDao.listar();
    List<TipoServicio> servicios = new ArrayList<TipoServicio>();
    List<Habitacion> habitaciones = new ArrayList<Habitacion>();
    
    int idHotel = hotelDao.ultimoId()+1;
    int num;
    
    RegistrarHabitacionV registrarHabitacionV;
    RegistrarHabitacionC registrarHabitacionC;

    boolean flagwifi = true;
    boolean flaggym = true;
    boolean flagpiscina = true;
    boolean flagac = true;
    boolean flagrecepcion24horas = true;
    boolean flagrestaurante = true;
    boolean flagplaya = true;
    boolean flagsauna = true;
    boolean flagbar = true;

    public RegistrarHotelC(RegistrarHotelV registrarHotelV, Usuario usuario) {
        this.registrarHotelV = registrarHotelV;
        this.usuario = usuario;
        this.usuarioDao = new UsuarioDao();

        this.registrarHabitacionV= new RegistrarHabitacionV();
        this.registrarHotelV.bwifi.addActionListener(this);
        this.registrarHotelV.bgym.addActionListener(this);
        this.registrarHotelV.bpiscina.addActionListener(this);
        this.registrarHotelV.bac.addActionListener(this);
        this.registrarHotelV.brecepcion24horas.addActionListener(this);
        this.registrarHotelV.brestaurante.addActionListener(this);
        this.registrarHotelV.bplaya.addActionListener(this);
        this.registrarHotelV.bsauna.addActionListener(this);
        this.registrarHotelV.bbar.addActionListener(this);
        this.registrarHotelV.bcancelar.addActionListener(this);
        this.registrarHotelV.bagregar.addActionListener(this);
        this.registrarHotelV.beliminar.addActionListener(this);
        this.registrarHotelV.bregistrar.addActionListener(this);
        this.registrarHabitacionV.bregistrar.addActionListener(this);
        
        this.registrarHotelV.setExtendedState(6);
        this.registrarHotelV.setVisible(true);
        this.registrarHotelV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == registrarHotelV.bwifi) {
            
            if(seleccionarTipoServicio(flagwifi, registrarHotelV.bwifi)==1){
                flagwifi = false;
            }else{
                flagwifi = true;
            }
        }

        if (e.getSource() == registrarHotelV.bgym) {

            if(seleccionarTipoServicio(flaggym, registrarHotelV.bgym)==1){
                flaggym = false;
            }else{
                flaggym = true;
            }

        }

        if (e.getSource() == registrarHotelV.bpiscina) {

            if(seleccionarTipoServicio(flagpiscina, registrarHotelV.bpiscina)==1){
                flagpiscina = false;
            }else{
                flagpiscina = true;
            }
        }

        if (e.getSource() == registrarHotelV.bac) {

            if(seleccionarTipoServicio(flagac, registrarHotelV.bac)==1){
                flagac = false;
            }else{
                flagac = true;
            }
        }

        if (e.getSource() == registrarHotelV.brecepcion24horas) {

            if(seleccionarTipoServicio(flagrecepcion24horas, registrarHotelV.brecepcion24horas)==1){
                flagrecepcion24horas = false;
            }else{
                flagrecepcion24horas = true;
            }
        }

        if (e.getSource() == registrarHotelV.brestaurante) {

            if(seleccionarTipoServicio(flagrestaurante, registrarHotelV.brestaurante)==1){
                flagrestaurante = false;
            }else{
                flagrestaurante = true;
            }
        }

        if (e.getSource() == registrarHotelV.bplaya) {

            if(seleccionarTipoServicio(flagplaya, registrarHotelV.bplaya)==1){
                flagplaya = false;
            }else{
                flagplaya = true;
            }
        }

        if (e.getSource() == registrarHotelV.bsauna) {

            if(seleccionarTipoServicio(flagsauna, registrarHotelV.bsauna)==1){
                flagsauna = false;
            }else{
                flagsauna = true;
            }
        }

        if (e.getSource() == registrarHotelV.bbar) {

            if(seleccionarTipoServicio(flagbar, registrarHotelV.bbar)==1){
                flagbar = false;
            }else{
                flagbar = true;
            }
        }

        if(e.getSource() == registrarHotelV.bagregar){
            
             registrarHabitacionC = new RegistrarHabitacionC(registrarHabitacionV,hotel, usuario);
        
        }
        
        if (e.getSource() == registrarHotelV.beliminar) {
            try{
                 num=Integer.parseInt(JOptionPane.showInputDialog(registrarHotelV,"Ingrese el numero de la habitacion que desea eliminar"));
                 if(num>0 && num<=habitaciones.size()){
                    eliminar(num);
                } else {
                    JOptionPane.showMessageDialog(registrarHotelV, "El numero ingresado no coincide con la cantidad de habitaciones registradas");
                }
            } catch(NumberFormatException eN){
                JOptionPane.showMessageDialog(registrarHotelV, "Ingrese un numero"+ eN.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        if(e.getSource() == registrarHabitacionV.bregistrar){
            if(registrarHabitacionC.flag){
                Habitacion habitacion = registrarHabitacionC.getHabitacion();
                habitaciones.add(habitacion);
                System.out.println("size: " + habitaciones.size());

                mostrarHabitaciones();
                registrarHabitacionV.dispose();
                registrarHabitacionV = new RegistrarHabitacionV();
                registrarHabitacionV.bregistrar.addActionListener(this);

            }
        }
        
        if (e.getSource() == registrarHotelV.bregistrar) {

            if (!registrarHotelV.tnit.getText().isBlank()
                    && !registrarHotelV.tnombreHotel.getText().toString().isBlank()
                    && !registrarHotelV.tdireccion.getText().isBlank()
                    && !flagwifi == true
                    || !flaggym == true
                    || !flagpiscina == true
                    || !flagac == true
                    || !flagrecepcion24horas == true
                    || !flagrestaurante == true
                    || !flagplaya == true
                    || !flagsauna == true
                    || !flagbar == true) {

                setAdd();

                UsuarioV usuarioV = new UsuarioV();
                UsuarioC usuarioC = new UsuarioC(usuarioV, usuario);
                registrarHotelV.setVisible(false);
            } else {

                JOptionPane.showMessageDialog(registrarHotelV, "Faltan datos por ingresar");

            }
        }
        if(e.getSource()==registrarHotelV.bcancelar){
            UsuarioV usuarioV = new UsuarioV();
            UsuarioC usuarioC = new UsuarioC(usuarioV,usuario);
            registrarHotelV.setVisible(false);
        }

    }
    
    public int seleccionarTipoServicio(boolean flag, JButton boton){
        int r = 1;
        int i = (int) boton.getClientProperty("valor");
        
        if (flag) {

            boton.setBackground(Color.lightGray);
            servicios.add(datosTipoServicioDao.get(i));
            r=1;
        } else {
            boton.setBackground(Color.white);
            servicios.remove(datosTipoServicioDao.get(i));
            r=0;
        }
        
        return r;
    }
    
    public void setAdd() {
        int resultado = 0;
        int r = 1;
        int nit = 0;
        int numeroHabitaciones = 0;

        try {

            nit = Integer.parseInt(registrarHotelV.tnit.getText().toString());


        } catch (NumberFormatException eN) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHotelV, "Error en los datos numéricos: " + eN.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        String nombreHotel = "";

        try {
            nombreHotel = registrarHotelV.tnombreHotel.getText().toString();
            


        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHotelV, "Error: " + e.getMessage());
        }

        String direccion = "";
        try {
            direccion = registrarHotelV.tdireccion.getText().toString();
            validarDireccion(registrarHotelV.tdireccion.getText().toString());
            
            JOptionPane.showMessageDialog(registrarHotelV, "La direccion es valida");
        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHotelV, "Error: " + e.getMessage());
        }

        hotel.setIdHotel(idHotel);
        hotel.setNit(nit);
        hotel.setNombreHotel(nombreHotel);
        hotel.setDireccion(direccion);
        hotel.setHabitaciones(habitaciones);
        hotel.setNumeroHabitaciones(hotel.getHabitaciones().size());
        hotel.setServicios(servicios);
        hotel.setUsuario(usuario);
        


        if (r == 1) {
            if(hotelDao.setAgregar(hotel)==1){
                for(Habitacion habitacion : habitaciones){
                    int idHabitacion = habitacionDao.ultimoId()+1;
                    habitacion.setIdHabitacion(idHabitacion);
                    if(habitacionDao.setAgregar(habitacion)==1){
                        habitacionDao.setAgregarImagenes(idHabitacion, habitacion.getImagenes());
                    }
                }
                for(TipoServicio servicio : servicios){
                    hotelDao.setAgregarServicios(hotelDao.ultimoId(),servicio.getIdTipoServicio());
                }
                usuario.setIdRol(4);
                usuarioDao.setActualizar(usuario);
            }
            
            
        }

        

    }
    
    public void mostrarHabitaciones() {
        registrarHotelV.panelHabitaciones.removeAll();
        for (int i = 0; i < habitaciones.size(); i++) {
            int c = i + 1;

            registrarHotelV.migrid = new GridLayout(c,1,10,10);
            registrarHotelV.panelHabitaciones.setLayout(registrarHotelV.migrid);
            
            JPanel panelHabitacion = new JPanel();
            FlowLayout miflow = new FlowLayout(FlowLayout.LEFT);
            panelHabitacion.setLayout(miflow); 
            panelHabitacion.setPreferredSize(new Dimension(400, 110));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;

            
            JLabel foto = habitaciones.get(i).getFotos().get(0);

            JPanel panelImg = new JPanel();
            panelImg.setLayout(new FlowLayout());
            panelImg.setPreferredSize(new Dimension(100, 80));
            panelImg.add(foto);

            gbc.insets = new Insets(20, 20, 20, 30);
            panelHabitacion.add(panelImg, gbc);

            
            JPanel panelNombre = new JPanel();
            panelNombre.setLayout(new FlowLayout());
            panelNombre.setPreferredSize(new Dimension(200, 30));

            JLabel ltitulo = new JLabel("Habitación " + c); // Nueva instancia de JLabel
            ltitulo.setFont(new Font("Times New Roman", Font.BOLD, 18));
            panelNombre.add(ltitulo);

            gbc.gridx = 1;
            panelHabitacion.add(panelNombre, gbc);

            
            
            registrarHotelV.panelHabitaciones.add(panelHabitacion);

            
            
        }

        
        registrarHotelV.panelHabitaciones.revalidate();
        registrarHotelV.panelHabitaciones.repaint();
    }
    
    private void  eliminar(int num){
        
        registrarHotelV.panelHabitaciones.removeAll();
        habitaciones.remove(num-1);
        mostrarHabitaciones();
        

    }


}
