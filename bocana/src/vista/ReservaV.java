/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author estud
 */
public class ReservaV extends JFrame {

    public JDateChooser fechaInicio, fechaFin;
    public Container contenedor;
    public JLabel politicas;
    public JLabel titulo, lusuario, usuario, lnombre_habitacion, nombre_habitacion,lmonto, monto, lmetodoPago, metodoPago, lfechaInicio, lfechaFin;
    public JPanel panelNorte, panelCentro, panelSur, panel, panelDerecha;
    public JButton cancelar, continuar;
    public JCheckBox aceptar;
    public GridLayout migrid;
    public FlowLayout miflow;
    public GridBagLayout gridBag;
    public GridBagConstraints gbc;

    public ReservaV() {
        super("Reserva");
        ImageIcon fondo = new ImageIcon("fondo.jpg");
        setContentPane(new JLabel(fondo));
        contenedor = getContentPane();
        miflow = new FlowLayout(FlowLayout.CENTER);
        contenedor.setLayout(miflow);

        panelNorte = new JPanel();
        miflow = new FlowLayout();
        panelNorte.setLayout(miflow);
        
        panelCentro = new JPanel();
        migrid = new GridLayout(4,2,5,5);
        panelCentro.setLayout(migrid); 
        
        panelSur = new JPanel();
        migrid = new GridLayout(1,2,5,5);
        panelSur.setLayout(migrid);
        
        titulo = new JLabel("Reserva");
        lusuario = new JLabel("Nombre del titular:");
        lnombre_habitacion = new JLabel("Nombre de habitacion:");
        lfechaInicio  = new JLabel("Fecha de inicio:");
        lfechaFin  = new JLabel("Fecha de fin");
        politicas  = new JLabel("<html>Política de Cancelación de Alojamientos Bocana" +
"<br>" +
"Cancelación Gratuita: Los huéspedes pueden cancelar su reserva sin cargo "
                + "<br>hasta 48 horas antes de la fecha de llegada." +
"<br>" +
"Cancelación Tardía: Si la cancelación se realiza menos de 48 horas antes "
                + "<br>de la llegada, se aplicará un cargo equivalente a la primera "
                + "<br>noche de estancia." +
"<br>" +
"No Show: En caso de no presentarse sin haber realizado una cancelación "
                + "<br>previa, se cobrará el total de la reserva." +
"<br>" +
"Modificaciones: Las solicitudes de cambio de fecha o tipo de habitación se "
                + "<br>aceptarán sin costo, siempre que se realicen con al menos "
                + "<br>48 horas de anticipación y estén sujetas a disponibilidad." +
"<br>" +
"Reservas No Reembolsables: Las tarifas promocionales y las reservas no "
                + "<br>reembolsables no permiten cancelaciones ni cambios. El "
                + "<br>pago total se cargará al momento de la reserva." +
"<br>" +
"Reembolsos: En caso de cancelación dentro del plazo permitido, el reembolso "
                + "<br>se procesará dentro de 7 a 10 días hábiles.</html>");
       
        aceptar = new JCheckBox("Estoy de acuerdo");
        
      usuario = new JLabel();
      nombre_habitacion = new JLabel();

      lfechaInicio = new JLabel("Fecha de inicio:");
      lfechaFin = new JLabel("Fecha fin:");
      
      fechaInicio = new JDateChooser();
      fechaFin = new JDateChooser();
      
      cancelar = new JButton("Cancelar");
      continuar = new JButton("Continuar");
      
      panelDerecha = new JPanel();
      migrid = new GridLayout(2,1);
      panelDerecha.setLayout(migrid);
      
        panel = new JPanel();
         gridBag = new GridBagLayout();
        panel.setLayout(gridBag);
gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            gbc.gridheight = 1;
            gbc.insets = new Insets(100, 100, 20, 100);
            
            
            
            //Panel norte
            panelNorte.add(titulo);
            
            //Panel centro
            panelCentro.add(lusuario);
            panelCentro.add(usuario);
            panelCentro.add(lnombre_habitacion);
            panelCentro.add(nombre_habitacion);

            panelCentro.add(lfechaInicio);
            panelCentro.add(fechaInicio);
            panelCentro.add(lfechaFin);
            panelCentro.add(fechaFin);
            

            // Panel sur
            panelSur.add(cancelar);
            panelSur.add(continuar);
  
            panel.add(panelNorte, gbc);
            
            gbc.gridy = 1;
            gbc.insets = new Insets(20, 100, 20, 100);
            panel.add(panelCentro, gbc);
            
            gbc.gridy = 2;
            gbc.insets = new Insets(20, 100, 100, 100);
            panel.add(panelSur, gbc);
            
           panelDerecha.add(politicas);
           panelDerecha.add(aceptar);
           contenedor.add(panel);
           contenedor.add(panelDerecha);

    }
}
