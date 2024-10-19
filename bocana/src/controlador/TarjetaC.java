/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.RegistrarC.validarEspaciosNumeros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Habitacion;
import modelo.Tarjeta;
import modelo.TarjetaDao;
import modelo.Usuario;
import vista.MetodoDePagoV;
import vista.TarjetaV;

/**
 *
 * @author estud
 */
public class TarjetaC implements ActionListener {

    public TarjetaV tarjetaV = new TarjetaV();
    public Tarjeta tar = new Tarjeta();
    public TarjetaDao tarDao = new TarjetaDao();
    Usuario usuario = new Usuario();
    Habitacion habitacion = new Habitacion();
    int id=2, numT;
    boolean result;

    public TarjetaC(TarjetaV tarV,Usuario usuario, Habitacion habitacion) {
        this.tarjetaV = tarV;
        this.usuario= usuario;
        this.habitacion= habitacion;
        this.tarjetaV.cancelar.addActionListener(this);
        this.tarjetaV.continuar.addActionListener(this);
        this.tarjetaV.listaTipo.addActionListener(this);
        this.tarjetaV.listaBanco.addActionListener(this);
        this.tarjetaV.listaTipoDebito.addActionListener(this);
        this.tarjetaV.setExtendedState(6);
        this.tarjetaV.setVisible(true);
        this.tarjetaV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tarjetaV.listaTipo.getSelectedItem().toString().equals("Credito")) {
            tarjetaV.listaTipoDebito.setSelectedIndex(0);
            tarjetaV.listaTipoDebito.setEnabled(false);
        } else {
            tarjetaV.listaTipoDebito.setEnabled(true);
        }

        if (e.getSource() == tarjetaV.continuar) {
            
            if (!tarjetaV.tnumTarjeta.getText().toString().isEmpty()
                    && !tarjetaV.cvv.getText().toString().isEmpty()
                    && !tarjetaV.tnombrePropietario.getText().toString().isEmpty()
                    && !tarjetaV.tapellidoPropietario.getText().toString().isEmpty()
                    && !tarjetaV.listaTipo.getSelectedItem().toString().isEmpty()
                    && !tarjetaV.listaBanco.getSelectedItem().toString().isEmpty()
                    && !tarjetaV.listaTipoDebito.getSelectedItem().toString().isEmpty()) {
                            if(tarjetaV.guardar.isSelected()){
                                 setAdd();
                             }
                            result = validarDatos();
                            if(result=true){
                                System.out.print("Funciona loco");
                            }
            } else{
                 JOptionPane.showMessageDialog(tarjetaV, "Faltan datos por ingresar");
            }
        }
                
            
            
        

        if (e.getSource() == tarjetaV.cancelar) {
            MetodoDePagoV metodoPagoV = new MetodoDePagoV();
            MetodoDePagoC metodoPagoC = new MetodoDePagoC(metodoPagoV,usuario,habitacion);
        }
    }

    private static final Pattern DATE_PATTERN = Pattern.compile("^(0[1-9]|1[0-2])/(\\d{4})$");

    public static boolean validarFecha(String input) {
        Matcher matcher = DATE_PATTERN.matcher(input);
        if (!matcher.matches()) {
            return false; // Formato incorrecto
        }

        // Obtener el año y mes
        int year = Integer.parseInt(matcher.group(2));
        int month = Integer.parseInt(matcher.group(1));

        // Obtener la fecha actual
        LocalDate currentDate = LocalDate.now();
        
        // Calcular la fecha de vencimiento máxima (último día del mes)
        LocalDate fechaVencimiento = LocalDate.of(year, month, 1).plusMonths(1).minusDays(1);
        // Calcular los años válidos para la tarjeta (3 o 4 años)
        LocalDate fechaLimiteInferior = currentDate.plusYears(3).withDayOfMonth(1);
        LocalDate fechaLimiteSuperior = currentDate.plusYears(4).withDayOfMonth(1);

        // Validar que la fecha de vencimiento esté dentro del rango permitido
        return !fechaVencimiento.isBefore(currentDate) && (fechaVencimiento.isBefore(fechaLimiteSuperior) || fechaVencimiento.isEqual(fechaLimiteSuperior));
    

    }

    public void setAdd() {
        int r = 1, resultado=0;
        String tipoTarjeta = tarjetaV.listaTipo.getSelectedItem().toString();
        String tipoDebito = tarjetaV.listaTipoDebito.getSelectedItem().toString();
        String banco = tarjetaV.listaBanco.getSelectedItem().toString();
        
        String numTarjeta="", cvv="";


         if( tarjetaV.tnumTarjeta.getText().length() >= 13 &&  tarjetaV.tnumTarjeta.getText().length() <= 19 ){
             numTarjeta =tarjetaV.tnumTarjeta.getText().toString();
            cvv =tarjetaV.cvv.getText().toString();
         }

        
        if( tarjetaV.tnumTarjeta.getText().length() < 13 
                || tarjetaV.tnumTarjeta.getText().length() > 19 
                || tarjetaV.tnumTarjeta.getText().length() < 0){
            JOptionPane.showMessageDialog(tarjetaV, "Ingrese un numero valido para la tarjeta");
        r=0;
        }
        
        
        

        if (tarjetaV.cvv.getText().length() != 3) {
            JOptionPane.showMessageDialog(tarjetaV, "El CVV no puede ser menor o mayor a 3");
            r = 0;
        } 
        
        String fecha;
        fecha = tarjetaV.tvencimiento.getText().toString();

        if (validarFecha(fecha)) {
            System.out.println("Fecha válida: ");
        } else {
            JOptionPane.showMessageDialog(tarjetaV, "El formato de la fecha no coincide MM/AAAA :"+ fecha);
            System.out.println("Fecha inválida: " + fecha);
        }
        
        String nombrePropietario="", apellidoPropietario="";
        
        try {
            nombrePropietario = tarjetaV.tnombrePropietario.getText().toString();
            apellidoPropietario = tarjetaV.tapellidoPropietario.getText().toString();
            
            validarEspaciosNumeros(nombrePropietario);
            validarEspaciosNumeros(apellidoPropietario);

        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(tarjetaV, "Error: " + e.getMessage());
        }
        
        tar.setNumTarjeta(numTarjeta);
        tar.setCvv(cvv);
        tar.setNombrePropietario(nombrePropietario);
        tar.setApellidoPropietario(apellidoPropietario);
        tar.setFechaVencimiento(fecha);
        tar.setTipoTarjeta(tipoTarjeta);
        tar.setBanco(banco);
        tar.setTipoDebito(tipoDebito);
        tar.setIdUsuario(id);
        
        if (r == 1) {
            resultado = tarDao.setAgregar(tar);
        }

        if (resultado == 1) {
            JOptionPane.showMessageDialog(tarjetaV, "Tarjeta guardada");
        } else {
            JOptionPane.showMessageDialog(tarjetaV, "Error de insercion" + JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean validarDatos(){
        int r = 1, resultado=0;
        String tipoTarjeta = tarjetaV.listaTipo.getSelectedItem().toString();
        String tipoDebito = tarjetaV.listaTipoDebito.getSelectedItem().toString();
        String banco = tarjetaV.listaBanco.getSelectedItem().toString();
        
        String numTarjeta="", cvv="";


         if( tarjetaV.tnumTarjeta.getText().length() >= 13 &&  tarjetaV.tnumTarjeta.getText().length() <= 19 ){
             numTarjeta =tarjetaV.tnumTarjeta.getText().toString();
            cvv =tarjetaV.cvv.getText().toString();
         }

        
        if( tarjetaV.tnumTarjeta.getText().length() < 13 
                || tarjetaV.tnumTarjeta.getText().length() > 19 
                || tarjetaV.tnumTarjeta.getText().length() < 0){
            JOptionPane.showMessageDialog(tarjetaV, "Ingrese un numero valido para la tarjeta");
        r=0;
        }
        
        
        

        if (tarjetaV.cvv.getText().length() != 3) {
            JOptionPane.showMessageDialog(tarjetaV, "El CVV no puede ser menor o mayor a 3");
            r = 0;
        } 
        
        String fecha;
        fecha = tarjetaV.tvencimiento.getText().toString();

        if (validarFecha(fecha)) {
            System.out.println("Fecha válida: ");
        } else {
            JOptionPane.showMessageDialog(tarjetaV, "El formato de la fecha no coincide MM/AAAA :"+ fecha);
            System.out.println("Fecha inválida: " + fecha);
        }
        
        String nombrePropietario="", apellidoPropietario="";
        
        try {
            nombrePropietario = tarjetaV.tnombrePropietario.getText().toString();
            apellidoPropietario = tarjetaV.tapellidoPropietario.getText().toString();
            
            validarEspaciosNumeros(nombrePropietario);
            validarEspaciosNumeros(apellidoPropietario);

        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(tarjetaV, "Error: " + e.getMessage());
        }
        if(r==1){
            return true;
        } else {
            return false;
        }
        
    }
}
