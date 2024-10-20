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
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Usuario
 */
public class UsuarioV extends JFrame{
    
    public Container contenedor;
    public JLabel lnombreUsuario, leditarPerfil, lverReservas, lagregarAlojamiento, leliminarPerfil, lverAlojamientos, lagregarOferta;
    public JButton beditarPerfil, bverReservas, bagregarAlojamiento, beliminarPerfil, bvolver, bcerrarSesion, bverAlojamientos, bagregar;


    public JPanel panel;
    public JPanel panelSur;

    public GridLayout migrid;
    public FlowLayout miflow;
    public GridBagLayout gridbag;
    public GridBagConstraints gbc;
    
    public UsuarioV(){
        
        super("Usuario");
        
        contenedor = getContentPane();
        miflow = new FlowLayout();
        contenedor.setLayout(miflow);
        
        panel = new JPanel();
        gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
              
        
        lnombreUsuario = new JLabel("Nombre Usuario");
        lnombreUsuario.setFont(new Font("Times New Roman", 1, 40));
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.WEST;
        
        panel.add(lnombreUsuario, gbc);
        
        leditarPerfil = new JLabel("Editar perfil");
        leditarPerfil.setFont(new Font("Times New Roman", 0, 30));
        
        gbc.gridy = 1;
        panel.add(leditarPerfil, gbc);
        
        beditarPerfil = new JButton("Editar");
        beditarPerfil.setFont(new Font("Times New Roman", 0, 20));
        
        beditarPerfil.setContentAreaFilled(false);
        beditarPerfil.setForeground(Color.BLACK);
        
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(beditarPerfil, gbc);

        lverReservas = new JLabel("Ver tus reservas");
        lverReservas.setFont(new Font("Times New Roman", 0, 30));
        
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(lverReservas, gbc);
        
        bverReservas = new JButton("Ver");
        bverReservas.setFont(new Font("Times New Roman", 0, 20));
        
        bverReservas.setContentAreaFilled(false);
        bverReservas.setForeground(Color.BLACK);
        
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(bverReservas, gbc);
        
        lagregarAlojamiento = new JLabel("Agregar Alojamiento");
        lagregarAlojamiento.setFont(new Font("Times New Roman", 0, 30));
        
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(lagregarAlojamiento, gbc);
        
        bagregarAlojamiento = new JButton("Agregar");
        bagregarAlojamiento.setFont(new Font("Times New Roman", 0, 20));
        
        bagregarAlojamiento.setContentAreaFilled(false);
        bagregarAlojamiento.setForeground(Color.BLACK);
        
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(bagregarAlojamiento, gbc);
        
        
        leliminarPerfil = new JLabel("Eliminar Perfil");
        leliminarPerfil.setFont(new Font("Times New Roman", 0, 30));
        leliminarPerfil.setForeground(Color.red);
        
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(leliminarPerfil, gbc);
        
        beliminarPerfil = new JButton("Eliminar");
        beliminarPerfil.setFont(new Font("Times New Roman", 0, 20));
        beliminarPerfil.setForeground(Color.red);
        beliminarPerfil.setContentAreaFilled(false);
        
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        panel.add(beliminarPerfil, gbc);
        
        
        //panelSur
        panelSur = new JPanel();
        migrid = new GridLayout(1, 2, 8, 8);
        panelSur.setLayout(migrid);
        
        
        bvolver = new JButton("Volver");
        bvolver.setFont(new Font("Times New Roman", 0, 20));
        
        bvolver.setContentAreaFilled(false);
        bvolver.setForeground(Color.BLACK);
        
        bcerrarSesion = new JButton("Cerrar sesion");
        bcerrarSesion.setFont(new Font("Times New Roman", 0, 20));
        
        bcerrarSesion.setContentAreaFilled(false);
        bcerrarSesion.setForeground(Color.BLACK);
        
        panelSur.add(bvolver);
        panelSur.add(bcerrarSesion);
        
        gbc.gridy = 13;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(panelSur, gbc);
        
        

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1000, 680)); // Establece un tamaño preferido para el JScrollPane

        
        contenedor.add(scrollPane);
    }
}
