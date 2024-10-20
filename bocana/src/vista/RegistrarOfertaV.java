/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import modelo.Habitacion;
import modelo.HabitacionDao;

/**
 *
 * @author Usuario
 */
public class RegistrarOfertaV extends JFrame{
    public JButton bcancelar, bagregar;
    public JDateChooser fechaInicio, fechaFin;
    public JPanel panel,panelNorte, panelCentro, panelSur;
    public JLabel lregistrar, ldescuento, lfechaInicio, lfechaFin, lhabitacion;
    public JTextField tdescuento ;
    public Container contenedor;
    public String listaH[];
    public ArrayList <String> habitaciones;
    public FlowLayout miflow;
    public GridBagLayout gridbag;
    public GridLayout migrid;
    public JComboBox lista;
    public GridBagConstraints gbc;
    
            
    public RegistrarOfertaV(){
        
        super("Registrar Oferta");
        
        
        
        
        
        contenedor = getContentPane();
        miflow = new FlowLayout();
        contenedor.setLayout(miflow);
        
        panel = new JPanel();
        gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        
        //panelNorte
        panelNorte = new JPanel();
        miflow = new FlowLayout();
        panelNorte.setLayout(miflow);
        
        
        lregistrar = new JLabel("Agregar oferta");
        lregistrar.setFont(new Font("Times New Roman", 1, 80));
        
        
        panelNorte.add(lregistrar);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 100, 50, 100);
        
        panel.add(panelNorte, gbc);
        
        
        //panelCentro
        panelCentro = new JPanel();
        migrid = new GridLayout(4, 2, 80, 8);
        panelCentro.setLayout(migrid);
        
        ldescuento = new JLabel("Descuento en %");
        ldescuento.setFont(new Font("Times New Roman", 0, 30));
        lfechaInicio = new JLabel("Fecha inicio");
        lfechaInicio.setFont(new Font("Times New Roman", 0, 30));
        lfechaFin = new JLabel("Fecha fin");
        lfechaFin.setFont(new Font("Times New Roman", 0, 30));
        lhabitacion= new JLabel("Habitacion");
        lhabitacion.setFont(new Font("Times New Roman", 0, 30));
        
        
        tdescuento = new JTextField(10);
        tdescuento.setFont(new Font("Times New Roman", 0, 30));
        fechaInicio = new JDateChooser();
        fechaInicio.setFont(new Font("Times New Roman", 0, 30));
        fechaFin = new JDateChooser();
        fechaFin.setFont(new Font("Times New Roman", 0, 30));

        lista.setFont(new Font("Times New Roman", 0, 25));

        panelCentro.add(ldescuento);
        panelCentro.add(tdescuento);
        panelCentro.add(lfechaInicio);
        panelCentro.add(fechaInicio);
        panelCentro.add(lfechaFin);
        panelCentro.add(fechaFin);
        panelCentro.add(lhabitacion);
        panelCentro.add(lista);

        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 30, 50);
        
        panel.add(panelCentro, gbc);

       
        
        
        //panelSur
        panelSur = new JPanel();
        migrid = new GridLayout(1, 2, 8, 8);
        panelSur.setLayout(migrid);
        
        
        bcancelar = new JButton("Cancelar");
        bcancelar.setFont(new Font("Times New Roman", 0, 20));
        
        bcancelar.setContentAreaFilled(false);
        bcancelar.setForeground(Color.BLACK);
        
        bagregar = new JButton("Agregar");
        bagregar.setFont(new Font("Times New Roman", 0, 20));
        
        bagregar.setContentAreaFilled(false);
        bagregar.setForeground(Color.BLACK);
        
        panelSur.add(bcancelar);
        panelSur.add(bagregar);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 10, 50);
        
        panel.add(panelSur, gbc);
        
        

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1000, 680)); // Establece un tamaño preferido para el JScrollPane

        
        contenedor.add(scrollPane);
        
    
    }
}
