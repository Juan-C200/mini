/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class ResenaV extends JFrame{
    public Container contenedor;
    public JLabel lnombreHotel, ltipoHabitacion, ldescripcionDetallada, lservicios, lfotos, lcalificacion, lnumero, lcomenta;
    public JTextField tresena;
    public JButton bmas, bmenos, bpublicar, breservar, bcancelar;

    public JComboBox lista;
    public JPanel panelServicios;
    public JPanel panelFotos;
    public JPanel panelPublicar;
    public JPanel panelCalificacion;
    public JPanel panelResenas;
    public JPanel panel;
    public JPanel panelSur;

    public GridLayout migrid;
    public FlowLayout miflow;
    public GridBagLayout gridbag;
    public GridBagConstraints gbc;
    
    
    public ResenaV(){
        
        super("Alojamiento");
        
        contenedor = getContentPane();
        miflow = new FlowLayout();
        contenedor.setLayout(miflow);
        
        panel = new JPanel();
        gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
              
        
        lnombreHotel = new JLabel("Nombre Hotel");
        lnombreHotel.setFont(new Font("Times New Roman", 1, 40));
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.WEST;
        
        panel.add(lnombreHotel, gbc);
        
        

        
        ltipoHabitacion = new JLabel("Tipo Habitacion");
        ltipoHabitacion.setFont(new Font("Times New Roman", 0, 30));
        
        gbc.gridy = 1;
        panel.add(ltipoHabitacion, gbc);
        
        ldescripcionDetallada = new JLabel("Descripcion detallada");
        ldescripcionDetallada.setFont(new Font("Times New Roman", 0, 23));
        
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        panel.add(ldescripcionDetallada, gbc);
        
        lservicios = new JLabel("Servicios");
        lservicios.setFont(new Font("Times New Roman", 0, 30));
        
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(lservicios, gbc);
        
        panelServicios = new JPanel();
        
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        panel.add(panelServicios, gbc);
        
 
        lfotos = new JLabel("Fotos");
        lfotos.setFont(new Font("Times New Roman", 0, 30));
        
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(lfotos, gbc);
        
        panelFotos = new JPanel();
        
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        panel.add(panelFotos, gbc);
        
        lcomenta = new JLabel("Comenta");
        lcomenta.setFont(new Font("Times New Roman", 0, 30));
        
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(lcomenta, gbc);
        
        panelPublicar = new JPanel();
        gridbag = new GridBagLayout();
        panelPublicar.setLayout(gridbag);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 20, 20, 20);;
        
        tresena = new JTextField(25);
        tresena.setFont(new Font("Times New Roman", 0, 25));
        
        panelPublicar.add(tresena, gbc);
        
        
        panelCalificacion = new JPanel();
        gridbag = new GridBagLayout();
        panelCalificacion.setLayout(gridbag);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(8, 8, 8, 8);
        
        
        lcalificacion = new JLabel("Calificacion");
        lcalificacion.setFont(new Font("Times New Roman", 0, 25));
        
        panelCalificacion.add(lcalificacion, gbc);
        
        bmenos = new JButton("-");
        bmenos.setFont(new Font("Times New Roman", 0, 15));
        bmenos.setBackground(Color.white);
        bmenos.setForeground(Color.BLACK);
        
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelCalificacion.add(bmenos, gbc);
                
        lnumero = new JLabel("1");
        lnumero.setFont(new Font("Times New Roman", 0, 15));
        
        gbc.gridx = 1;
        panelCalificacion.add(lnumero, gbc);
        
        bmas = new JButton("+");
        bmas.setFont(new Font("Times New Roman", 0, 15));
        bmas.setBackground(Color.white);
        bmas.setForeground(Color.BLACK);
        
        
        gbc.gridx = 2;
        panelCalificacion.add(bmas, gbc);
        
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 20, 20, 200);
        
        panelPublicar.add(panelCalificacion,gbc);
        
        
        bpublicar = new JButton("Publicar");
        bpublicar.setFont(new Font("Times New Roman", 0, 20));
        bpublicar.setBackground(Color.white);
        bpublicar.setForeground(Color.BLACK);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(20, 20, 20, 20);
        panelPublicar.add(bpublicar,gbc);
        
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 20, 20, 20);
        panel.add(panelPublicar, gbc);
        
        
        panelResenas = new JPanel();
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(panelResenas, gbc);
        
        //panelSur
        panelSur = new JPanel();
        migrid = new GridLayout(1, 2, 8, 8);
        panelSur.setLayout(migrid);
        
        
        bcancelar = new JButton("Cancelar");
        bcancelar.setFont(new Font("Times New Roman", 0, 20));
        
        bcancelar.setContentAreaFilled(false);
        bcancelar.setForeground(Color.BLACK);
        
        breservar = new JButton("Reservar");
        breservar.setFont(new Font("Times New Roman", 0, 20));
        
        breservar.setContentAreaFilled(false);
        breservar.setForeground(Color.BLACK);
        
        panelSur.add(bcancelar);
        panelSur.add(breservar);
        
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(panelSur, gbc);
        
        

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1000, 680)); // Establece un tamaño preferido para el JScrollPane

        
        contenedor.add(scrollPane);
        
    
    }
}
