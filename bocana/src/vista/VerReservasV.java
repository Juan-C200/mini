/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Usuario
 */
public class VerReservasV extends JFrame{
    public Container contenedor ;
    public JPanel panelTop;
    public JPanel panel;
    public JPanel panelReservas;
    public JPanel panelDown;
    public JLabel ltitulo;
    public JButton bvolver;
    public JPanel panelestado;
    public FlowLayout miflow;
    public GridBagLayout gridbag;
    public GridLayout grid;
    public GridBagConstraints gbc;

    public VerReservasV() {
       super("Reservas");
        
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        panel = new JPanel();
        gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        
        panelTop = new JPanel();
        miflow = new FlowLayout(FlowLayout.LEFT);
        panelTop.setLayout(miflow);
        panelestado = new JPanel();
        
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        ltitulo = new JLabel("Reservas");
        ltitulo.setFont(new Font("Times New Roman", 0, 30));
 
        panelTop.add(ltitulo);
        panel.add(panelTop,gbc);
        
        panelReservas = new JPanel();
        gridbag = new GridBagLayout();
        panelReservas.setLayout(gridbag);
        gbc.gridy = 1;
        panel.add(panelReservas, gbc);

        panelDown = new JPanel();
        miflow = new FlowLayout(FlowLayout.CENTER);
        panelDown.setLayout(miflow);

        bvolver = new JButton("Volver");
        bvolver.setFont(new Font("Times New Roman", 0, 20));
        
        bvolver.setContentAreaFilled(false);
        bvolver.setForeground(Color.BLACK);
        

        panelDown.add(bvolver, gbc);
        
        gbc.gridy = 2;
        panel.add(panelDown, gbc);
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1000, 680));
        
        contenedor.add(scrollPane);
        
        
        
        
    
    }
}
