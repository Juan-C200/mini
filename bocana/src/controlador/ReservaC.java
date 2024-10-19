/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import static java.time.LocalDateTime.now;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Habitacion;
import modelo.Reserva;
import modelo.ReservaDao;
import modelo.Usuario;
import vista.PagoV;
import vista.ReservaV;

/**
 *
 * @author estud
 */
public class ReservaC implements ActionListener{
    ReservaV vista = new ReservaV();
    Reserva reserva = new Reserva();
    ReservaDao dao = new ReservaDao();
    Usuario usuario = new Usuario();
    Habitacion habitacion = new Habitacion();
    int id = dao.ultimoId()+1;
    
    public ReservaC(ReservaV rv, Usuario u, Habitacion h){
        this.vista = rv;
        
        this.vista.aceptar.addActionListener(this);
        this.vista.cancelar.addActionListener(this);
        this.vista.continuar.addActionListener(this);
        
        this.usuario =u;
        this.habitacion = h;

        this.vista.nombre_habitacion.setText(habitacion.getNombreHabitacion().toString());
        this.vista.monto.setText(Double.toString(habitacion.getTarifa()));
        this.vista.usuario.setText(usuario.getNombre1()+""+usuario.getApellido1());
        this.vista.setExtendedState(6);
        this.vista.setVisible(true);
        this.vista.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.continuar){
            if(!vista.fechaInicio.getDate().toString().isBlank() 
                    || !vista.fechaInicio.getDate().toString().isBlank()){
                 if(vista.aceptar.isSelected()){
                PagoV pv = new PagoV();
                PagoC pc = new PagoC(pv);
                vista.setVisible(false);
                } else {
                     JOptionPane.showMessageDialog(vista, "Por favor acepta nuestras politicas");
                 }
            } else {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione ambas fechas.");
            }
           
        }
        if(e.getSource()==vista.cancelar){
            
        }
        
    }
    
    public void setAdd(){
       int r=1;
       Date fechaActual = new Date();
       int resultado=0;
       Date fechaI = vista.fechaInicio.getDate();
       Date fechaF = vista.fechaFin.getDate();
       String estado = "Confirmado";
       
       
       
       
       if (vista.fechaInicio.getDate() == null || vista.fechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione ambas fechas.");
            r=0;
        }
       
       if (vista.fechaInicio.getDate().after(vista.fechaFin.getDate())) {
            JOptionPane.showMessageDialog(null, "La Fecha de inicio no puede ser mayor que la Fecha de fin.");
            r=0;
        }
       
       if (vista.fechaInicio.getDate().before(fechaActual) || vista.fechaFin.getDate().before(fechaActual)) {
            JOptionPane.showMessageDialog(null, "Las fechas de inicio y fin deben ser mayores o iguales a la fecha actual.");
            r = 0;
        }
       
       reserva.setIdReserva(id);
       reserva.setFechaInicio(fechaI);
       reserva.setFechaFin(fechaF);
       reserva.setEstado(estado);
       reserva.setUsuario(usuario);
       reserva.setHabitacion(habitacion);
       

       
       if (r == 1) {
            resultado = dao.setAgregar(reserva);
        }

        if (resultado == 1) {
            JOptionPane.showMessageDialog(vista, "Reserva guardada");
        } else {
            JOptionPane.showMessageDialog(vista, "Error de insercion" + JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}