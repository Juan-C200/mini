/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.RegistrarC.validarDireccion;
import static controlador.RegistrarC.validarEspaciosNumeros;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import modelo.Habitacion;
import modelo.HabitacionDao;
import modelo.Hotel;
import modelo.TipoHabitacionDao;
import modelo.TipoHabitacion;
import modelo.TipoServicioDao;
import modelo.Usuario;
import vista.FotosV;
import vista.RegistrarHabitacionV;

/**
 *
 * @author Usuario
 */
public class RegistrarHabitacionC implements ActionListener{
    RegistrarHabitacionV registrarHabitacionV = new RegistrarHabitacionV();
    
    
    FotosV fotosV;
    FotosC fotosC;
    
    Hotel hotel = new Hotel();
    public boolean flag = false;
    
    Usuario usuario = new Usuario();
    
    List<byte[]> imagenes = new ArrayList<>();
    List<JLabel> fotos = new ArrayList<>();
    
    TipoHabitacionDao tipoHabitacionDao = new TipoHabitacionDao();
    Habitacion habitacion = new Habitacion();
    HabitacionDao habitacionDao = new HabitacionDao();
    List<TipoHabitacion> datosTipoHabitacionDao = tipoHabitacionDao.listar();
    TipoHabitacion tipoHabitacion = new TipoHabitacion();
    
    public RegistrarHabitacionC(RegistrarHabitacionV registrarHabitacionV, Hotel hotel, Usuario usuario) {
        this.usuario = usuario;
        this.registrarHabitacionV = registrarHabitacionV;
        this.hotel=hotel;
        this.fotosV = new FotosV();
        
        if(fotos.size()==6){
            registrarHabitacionV.bfotos.setEnabled(false);
        }
        
        this.registrarHabitacionV.imagenes = imagenes;
        this.registrarHabitacionV.fotos = fotos;
        this.registrarHabitacionV.bcancelar.addActionListener(this);
        this.registrarHabitacionV.bregistrar.addActionListener(this);
        this.registrarHabitacionV.bfotos.addActionListener(this);
        this.fotosV.bcontinuar.addActionListener(this);
        
        this.registrarHabitacionV.setExtendedState(6);
        this.registrarHabitacionV.setVisible(true);
        this.registrarHabitacionV.setDefaultCloseOperation(3);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()== registrarHabitacionV.bfotos){
            
            fotosC = new FotosC(fotosV, fotos, imagenes, usuario);
        }
        
        if(e.getSource() == fotosV.bcontinuar){
            if(fotosC.flag){
                fotos = fotosC.getFotos();
                imagenes = fotosC.getImagenes();
                registrarHabitacionV.migrid = new GridLayout(fotos.size(),4,5,5);
                registrarHabitacionV.panelFotos.setLayout(registrarHabitacionV.migrid);
                for(int i=0;i<fotos.size();i++){
                    registrarHabitacionV.panelFotos.add(fotos.get(i));
                }
                registrarHabitacionV.panelFotos.revalidate();
                registrarHabitacionV.panelFotos.repaint();
                
                fotosV.dispose();
                fotosV = new FotosV();
                fotosV.bcontinuar.addActionListener(this);

            }
        }
        
        if (e.getSource() == registrarHabitacionV.bregistrar) {

            if (!registrarHabitacionV.tdescripcionBreve.getText().isEmpty()
                    && !registrarHabitacionV.tdescripcionDetallada.getText().isEmpty()
                    && !registrarHabitacionV.ttarifa.getText().isEmpty()
                    && !registrarHabitacionV.lista.getSelectedItem().toString().isEmpty()
                    && !fotos.isEmpty()
                    ) {

                setAdd();
                
                

                JOptionPane.showMessageDialog(registrarHabitacionV, "Es bien");
                
                
            } else {

                JOptionPane.showMessageDialog(registrarHabitacionV, "Faltan datos por ingresar");

            }
        }
        
    }
    
    
    
    public void setAdd() {
        int resultado = 0;
        int r = 1;
        String estado = "Disponible";
        double tarifa=0;
        
        
        
        
        
        try {

            tarifa = Double.parseDouble(registrarHabitacionV.ttarifa.getText());

        } catch (NumberFormatException eN) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHabitacionV, "Error en los datos numéricos: " + eN.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        String descripcionBreve = "";
        String descripcionDetallada = "";

        try {
            descripcionBreve = registrarHabitacionV.tdescripcionBreve.getText();
            descripcionDetallada = registrarHabitacionV.tdescripcionDetallada.getText();
            //falta agregarle el numero maximo de palabras
            
        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHabitacionV, "Error: " + e.getMessage());
        }
        
        
        
        for(int i = 0;i<datosTipoHabitacionDao.size();i++){
            if(datosTipoHabitacionDao.get(i).getDescripcion().equals(registrarHabitacionV.lista.getSelectedItem().toString())){
                int idTipoHabitacion = datosTipoHabitacionDao.get(i).getIdTipoHabitacion();
                String descripcion = datosTipoHabitacionDao.get(i).getDescripcion();
                tipoHabitacion.setIdTipoHabitacion(idTipoHabitacion);
                tipoHabitacion.setDescripcion(descripcion);
            }
        }
        
        String nombreHabitacion = registrarHabitacionV.tnombreHabitacion.getText();
        
        if(nombreHabitacion.contains("!")
                || nombreHabitacion.contains("#")
                || nombreHabitacion.contains("$")
                || nombreHabitacion.contains("%")
                || nombreHabitacion.contains("&")
                || nombreHabitacion.contains("/")){
            JOptionPane.showMessageDialog(registrarHabitacionV, "El nombre de la habitacion no puede contener caracteres especiales");
        }else{
            habitacion.setNombreHabitacion(nombreHabitacion);
        }
        
        habitacion.setEstado(estado);
        habitacion.setTarifa(tarifa);
        habitacion.setDescripcionBreve(descripcionBreve);
        habitacion.setDescripcionDetallada(descripcionDetallada);
        habitacion.setTipoHabitacion(tipoHabitacion);
        habitacion.setHotel(hotel);
        habitacion.setImagenes(imagenes);
        habitacion.setFotos(fotos);
        

        if(r==1){
            flag=true;
        }else{
            flag=false;
        }

        
//        if(r == 1){
//            if (habitacionDao.setAgregar(habitacion)==1) {
//                if(habitacionDao.setAgregarImagenes(habitacion.getIdHabitacion(),habitacion.getImagenes())==1){
//                    JOptionPane.showMessageDialog(registrarHabitacionV, "Habitacion registrada");
//
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(registrarHabitacionV, "no se insertaron las imagenes");
//            }
//        }
        

    }
    
    public Habitacion getHabitacion() {
        return habitacion;
    }
    

}
