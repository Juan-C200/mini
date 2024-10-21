/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Habitacion;
import modelo.HabitacionDao;
import modelo.Hotel;
import modelo.TipoHabitacion;
import modelo.TipoHabitacionDao;
import modelo.Usuario;
import vista.EditarAlojamientoV;
import vista.FotosV;
import vista.RegistrarHabitacionV;

/**
 *
 * @author Usuario
 */
public class EditarAlojamientoC implements ActionListener{
    EditarAlojamientoV registrarHabitacionV = new EditarAlojamientoV();
    
    
    FotosV fotosV;
    FotosC fotosC;
    
    
    
    
    Usuario usuario = new Usuario();
    
    List<byte[]> imagenes = new ArrayList<>();
    List<JLabel> fotos = new ArrayList<>();
    
    TipoHabitacionDao tipoHabitacionDao = new TipoHabitacionDao();
    Habitacion habitacion = new Habitacion();
    HabitacionDao habitacionDao = new HabitacionDao();
    List<TipoHabitacion> datosTipoHabitacionDao = tipoHabitacionDao.listar();
    TipoHabitacion tipoHabitacion = new TipoHabitacion();
    
    public EditarAlojamientoC(EditarAlojamientoV registrarHabitacionV, Usuario usuario, Habitacion habitacion) {
        this.usuario = usuario;
        this.registrarHabitacionV = registrarHabitacionV;
        this.habitacion=habitacion;
        this.fotosV = new FotosV();
        this.registrarHabitacionV.imagenes = habitacion.getImagenes();
        this.registrarHabitacionV.fotos = habitacion.getFotos();
        
//        if(this.habitacion.getFotos().size()==6){
//            registrarHabitacionV.bfotos.setEnabled(false);
//        }
        this.registrarHabitacionV.tdescripcionBreve.setText(habitacion.getDescripcionBreve());
        this.registrarHabitacionV.tdescripcionDetallada.setText(habitacion.getDescripcionDetallada());
        this.registrarHabitacionV.tnombreHabitacion.setText(habitacion.getNombreHabitacion());
        this.registrarHabitacionV.ttarifa.setText(Double.toString(habitacion.getTarifa()));
        this.registrarHabitacionV.lista.setSelectedIndex(habitacion.getTipoHabitacion().getIdTipoHabitacion());
        this.registrarHabitacionV.listaEstado.setSelectedItem(habitacion.getEstado());
                
                
        
        this.registrarHabitacionV.bcancelar.addActionListener(this);
        this.registrarHabitacionV.beditar.addActionListener(this);
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
        
        if (e.getSource() == registrarHabitacionV.beditar) {

            if (!registrarHabitacionV.tdescripcionBreve.getText().isEmpty()
                    && !registrarHabitacionV.tdescripcionDetallada.getText().isEmpty()
                    && !registrarHabitacionV.ttarifa.getText().isEmpty()
                    && !registrarHabitacionV.lista.getSelectedItem().toString().isEmpty()
                    && !registrarHabitacionV.listaEstado.getSelectedItem().toString().isEmpty()
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
        
        habitacion.setEstado(registrarHabitacionV.lista.getSelectedItem().toString());
        habitacion.setTarifa(tarifa);
        habitacion.setDescripcionBreve(descripcionBreve);
        habitacion.setDescripcionDetallada(descripcionDetallada);
        habitacion.setTipoHabitacion(tipoHabitacion);
        habitacion.setHotel(habitacion.getHotel());
        habitacion.setImagenes(imagenes);
        habitacion.setFotos(fotos);
        


        
        if(r == 1){
            if (habitacionDao.setActualizar(habitacion)==1) {
                if(habitacionDao.setActualizarImagenes(habitacion.getIdHabitacion(),habitacion.getImagenes())==1){
                    JOptionPane.showMessageDialog(registrarHabitacionV, "Habitacion Editada");

                }

            } else {
                JOptionPane.showMessageDialog(registrarHabitacionV, "no se insertaron las imagenes");
            }
        }
        

    }
    
}
