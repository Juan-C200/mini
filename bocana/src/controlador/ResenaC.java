/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import modelo.Habitacion;
import modelo.HabitacionDao;
import modelo.Hotel;
import modelo.Resena;
import modelo.ResenaDao;
import modelo.TipoServicio;
import modelo.Usuario;
import vista.AlojamientosV;
import vista.MetodoDePagoV;
import vista.ResenaV;

/**
 *
 * @author Usuario
 */
public class ResenaC implements ActionListener{
    
    ResenaV resenaV = new ResenaV();
    
    Usuario usuario = new Usuario();
    Habitacion habitacion = new Habitacion();
    HabitacionDao habitacionDao = new HabitacionDao();
    Resena resena = new Resena();
    ResenaDao resenaDao = new ResenaDao();
    List<TipoServicio> servicios = new ArrayList<>();
    List<JLabel> fotos =  new ArrayList<>();
    List<Resena> resenas = new ArrayList<>();
    
    int numero = 1;
    
    public ResenaC(ResenaV resenaV, Usuario usuario, Habitacion habitacion) {
        this.resenaV = resenaV;
        this.usuario=usuario;
        this.habitacion=habitacion;
        
        this.servicios=habitacion.getHotel().getServicios();
        this.fotos=habitacionDao.listarImagenes(habitacion.getIdHabitacion());
        
        
        this.resenaV.lnombreHotel.setText(habitacion.getHotel().getNombreHotel());
        
        String tipoHabitacion = habitacion.getTipoHabitacion().getDescripcion();
        
        ImageIcon icon=new ImageIcon(tipoHabitacion+".png");
        Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        icon=new ImageIcon(img);
        
        this.resenaV.ltipoHabitacion.setIcon(icon);
        this.resenaV.ltipoHabitacion.setText(tipoHabitacion);


        this.resenaV.ldescripcionDetallada.setText(habitacion.getDescripcionDetallada());
        
        GridLayout grid = new GridLayout(3,3,20,20);
        this.resenaV.panelServicios.setLayout(grid);
        for(int i = 0; i<servicios.size();i++){
            
            
            String servicioDescripcion = servicios.get(i).getDescripcion();
            
            JLabel servicio = new JLabel(servicioDescripcion);
            
            ImageIcon icons=new ImageIcon(servicioDescripcion+".png");
            Image imgs = icons.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            icons=new ImageIcon(imgs);
            
            servicio.setIcon(icons);
            
            this.resenaV.panelServicios.add(servicio);
            
        }
        
        GridLayout grid2 = new GridLayout(2,3,20,20);
        this.resenaV.panelFotos.setLayout(grid2);
        
        for(int i = 0; i<fotos.size();i++){
            this.resenaV.panelFotos.add(fotos.get(i));
            
        }
        
        mostrarResenas(this.habitacion.getHotel().getIdHotel());
        
        
        this.resenaV.bmas.addActionListener(this);
        this.resenaV.bmenos.addActionListener(this);
        this.resenaV.bpublicar.addActionListener(this);
        this.resenaV.breservar.addActionListener(this);
        this.resenaV.bcancelar.addActionListener(this);
        
        
        this.resenaV.setExtendedState(6);
        this.resenaV.setVisible(true);
        this.resenaV.setDefaultCloseOperation(3);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resenaV.bmas){
            
            numero = numero + 1;
            
            if(numero>5){
                numero = 5;
                
            }
            
            resenaV.lnumero.setText(Integer.toString(numero));

        }
        
        if(e.getSource() == resenaV.bmenos){

            numero = numero - 1;
            
            if(numero<1){
                numero = 1;
                
            }
            
            resenaV.lnumero.setText(Integer.toString(numero));
        }
        
        if (e.getSource() == resenaV.bpublicar) {

            if (!resenaV.tresena.getText().isBlank() ) {

                setAdd();
                
                

                JOptionPane.showMessageDialog(resenaV, "Es bien");
                
                
            } else {

                JOptionPane.showMessageDialog(resenaV, "Faltan datos por ingresar");

            }
        }
        
        if(e.getSource() == resenaV.breservar){

            MetodoDePagoV metodoDePagoV = new MetodoDePagoV();
            MetodoDePagoC metodoDePagoC = new MetodoDePagoC(metodoDePagoV,usuario,habitacion);
            resenaV.setVisible(false);
        }
        
        if(e.getSource() == resenaV.bcancelar){

            AlojamientosV alojamientosV = new AlojamientosV();
            AlojamientosC alojamientosC = new AlojamientosC(alojamientosV,usuario);
            resenaV.setVisible(false);
        }
    }
    
    
    
    public void setAdd(){
        int idResena=resenaDao.ultimoId()+1;
        int calificacion = Integer.parseInt(resenaV.lnumero.getText());
        String comentario = resenaV.tresena.getText();
                 
        
        
        resena.setIdResena(idResena);
        resena.setCalificacion(calificacion);
        resena.setComentario(comentario);
        resena.setUsuario(usuario);
        resena.setHotel(habitacion.getHotel());
        
        if(resenaDao.setAgregar(resena)==1){
            resenaV.panelResenas.removeAll();
            mostrarResenas(habitacion.getHotel().getIdHotel());

        }else{
            System.out.println("no agrego");
        }
                
        
    }

    public void mostrarResenas(int idHotel){
        resenas=resenaDao.listar(idHotel);
        for(int i = 0; i<resenas.size();i++){
            GridLayout grid3 = new GridLayout(i+1,1,20,20);
            resenaV.panelResenas.setLayout(grid3);
            JPanel resena = new JPanel();
            resena.setLayout(new GridBagLayout());
            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(20, 20, 20, 30);
            
            JLabel foto = new JLabel();
            
            ImageIcon iconu=new ImageIcon("usuario.png");
            Image imgu = iconu.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            iconu=new ImageIcon(imgu);
            
            foto.setIcon(iconu);
            resena.add(foto,gbc);
            
            JLabel nombreUsuario = new JLabel(resenas.get(i).getUsuario().getNombre1());
            nombreUsuario.setFont(new Font("Times New Roman", 0, 20));
            
            gbc.gridx = 1;
            gbc.insets = new Insets(20, 20, 20, 5);
            resena.add(nombreUsuario,gbc);
            
            JLabel apellidoUsuario = new JLabel(resenas.get(i).getUsuario().getApellido1());
            apellidoUsuario.setFont(new Font("Times New Roman", 0, 20));
            
            gbc.gridx = 2;
            gbc.insets = new Insets(20, 5, 20, 30);
            resena.add(apellidoUsuario,gbc);
            
            JLabel calificacion = new JLabel("Calificacion: "+resenas.get(i).getCalificacion());
            calificacion.setFont(new Font("Times New Roman", 0, 20));
            
            gbc.gridy = 1;
            gbc.gridx = 0;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(10, 20, 20, 30);
            resena.add(calificacion,gbc);
            
            JLabel comentario = new JLabel(resenas.get(i).getComentario());
            comentario.setFont(new Font("Times New Roman", 0, 17));
            
            gbc.gridy = 2;
            gbc.gridx = 0;
            gbc.gridwidth = 3;
            resena.add(comentario,gbc);
            
            Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);  // Borde de línea negra de 3 píxeles
            resena.setBorder(lineBorder);
            
            resenaV.panelResenas.add(resena);
            
        }
        resenaV.panelResenas.revalidate();
        resenaV.panelResenas.repaint();
        
    }
    
}
