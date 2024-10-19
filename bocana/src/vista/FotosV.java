/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author estud
 */
public class FotosV extends JFrame{
    public Container contenedor;
    public JLabel titulo, foto;
    public JButton seleccionar, beliminar, bcontinuar;
    public JPanel panel, panelSur, panelNorte, panelCentro;
    public FlowLayout miflow;
    public GridLayout migrid;
    private GridBagLayout gridbag;
    private GridBagConstraints gbc;
    

    
    public FotosV(){
        super("Hoteles Bocana");
        
        contenedor = getContentPane();
        miflow = new FlowLayout(FlowLayout.CENTER);
        contenedor.setLayout(miflow);
        contenedor.setBackground(Color.lightGray);
        
        panel = new JPanel();
        gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        
        Color fondoColor = new Color(99, 124, 119);
        panel.setBackground(fondoColor);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30, 20,  45, 20);
        
        titulo = new JLabel("Seleccionar archivo");
        titulo.setForeground(Color.white);
        foto= new JLabel();
        
        seleccionar= new JButton("Seleccionar");
        beliminar = new JButton("Eliminar");
        bcontinuar = new JButton("Continuar");
        
        //panel norte
        panelNorte = new JPanel();
        migrid = new GridLayout(1,2,15,15);
        panelNorte.setLayout(migrid);
        
        panelNorte.add(titulo);
        panelNorte.add(seleccionar);
        panelNorte.setBackground(fondoColor);
        
        //panelCentro
        panelCentro = new JPanel();
        migrid = new GridLayout(2,4,5,5);
        panelCentro.setLayout(migrid);
        panelCentro.setBackground(fondoColor);
        
        //panel sur
        panelSur = new JPanel();
        migrid = new GridLayout(1,3, 10,10);
        panelSur.setLayout(migrid);
        panelSur.setBackground(fondoColor);
        
         panelSur.add(beliminar);
        panelSur.add(bcontinuar);
        
        
         gbc.insets = new Insets(200, 20,  50, 20);
         gbc.gridy = 0;
        panel.add(panelNorte, gbc);
        
        gbc.insets = new Insets(50, 20,  45, 20);
         gbc.gridy = 1;
        panel.add(panelCentro, gbc);
        
        gbc.insets = new Insets(50, 20,  45, 20);
        gbc.gridy = 2;
        panel.add(panelSur, gbc);
        
        contenedor.add(panel);
    }
}
