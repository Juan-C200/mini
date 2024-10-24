/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Habitacion;
import modelo.Reserva;
import modelo.ReservaDao;
import modelo.Usuario;
import vista.MetodoDePagoV;
import vista.ResenaV;
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
    Date fechaActual = new Date();
    
    public ReservaC(ReservaV rv, Usuario u, Habitacion h){
        this.vista = rv;
        this.vista.aceptar.addActionListener(this);
        this.vista.cancelar.addActionListener(this);
        this.vista.continuar.addActionListener(this);
        
        this.usuario =u;
        this.habitacion = h;

        this.vista.nombre_habitacion.setText(habitacion.getNombreHabitacion().toString());
        this.vista.usuario.setText(usuario.getNombre1()+" "+usuario.getApellido1());
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
                     if (validarFechas()==1){
                         MetodoDePagoV mp = new MetodoDePagoV();
                MetodoDePagoC mpc = new MetodoDePagoC(mp, usuario, habitacion, vista.fechaInicio.getDate(), vista.fechaFin.getDate(),reserva);
                vista.setVisible(false);
                     }
                
                } else {
                     JOptionPane.showMessageDialog(vista, "Por favor acepta nuestras politicas");
                 }
            } else {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione ambas fechas.");
            }
           
        }
        if(e.getSource()==vista.cancelar){
            ResenaV rv = new ResenaV();
            ResenaC rc = new ResenaC(rv, usuario, habitacion);
            vista.setVisible(false);


        }
        
    }
    
    public void setAdd(){
       int r=1;
       
       int resultado=0;
       Date fechaI = vista.fechaInicio.getDate();
       Date fechaF = vista.fechaFin.getDate();
       String estado = "Confirmada";
       
       
       
       reserva.setIdReserva(id);
       reserva.setFechaInicio(fechaI);
       reserva.setFechaFin(fechaF);
       reserva.setEstado(estado);
       reserva.setUsuario(usuario);
       reserva.setHabitacion(habitacion);
       

       
//       if (r == 1) {
//            resultado = dao.setAgregar(reserva);
//        }
//
//        if (resultado == 1) {
//            JOptionPane.showMessageDialog(vista, "Reserva guardada");
//        } else {
//            JOptionPane.showMessageDialog(vista, "Error de insercion" + JOptionPane.ERROR_MESSAGE);
//        }
   }
    
    public int validarFechas() {
    int r = 1;  // Inicializamos en 1, que sería el código de éxito si las fechas son válidas
    Date fecha1 = vista.fechaInicio.getDate();  // Obtenemos fecha de inicio
    Date fecha2 =  vista.fechaFin.getDate();     // Obtenemos fecha de fin
    Date fechaActual = new Date();           // Fecha actual del sistema

    // Validamos si las fechas son null antes de comparar
    if (fecha1 == null || fecha2 == null) {
        JOptionPane.showMessageDialog(vista, "Por favor, seleccione ambas fechas.");
        return 0;  // Retornamos 0 si alguna de las fechas es nula
    }

    // Verificar si la fecha de inicio es después de la fecha de fin
    if (fecha1.after(fecha2)) {
        JOptionPane.showMessageDialog(vista, "La fecha de fin no puede ser menor a la fecha de inicio.");
        return 0;  // Retornamos 0 porque las fechas no son válidas
    }

    // Verificar si las fechas son iguales
    if (fecha1==fecha2) {
        JOptionPane.showMessageDialog(vista, "Las fechas no pueden ser iguales.");
        return 0;  // Retornamos 0 porque las fechas no pueden ser iguales
    }

    // Verificar si ambas fechas están en el pasado con respecto a la fecha actual
    if (fecha1.before(fechaActual) && fecha2.before(fechaActual)) {
        JOptionPane.showMessageDialog(vista, "Las fechas seleccionadas no pueden ser anteriores a la fecha actual.");
        return 0;  // Retornamos 0 si ambas fechas son anteriores a la actual
    }

    return r;  // Si pasa todas las validaciones, retornamos 1 (fechas válidas)
}

}
