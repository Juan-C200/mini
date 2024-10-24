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
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Usuario
 */
public class VerAlojamientosV extends JFrame{
    public Container contenedor ;
    public JButton bvolver;
    public JPanel panelTop;
    public JPanel panelDown;
    public JPanel panelTitulo;
    public JPanel panelBIniciarSesion;
    public JPanel panelNorte;
    public JPanel panelCentro;
    public JPanel panelSur;
    
    
    public JPanel panelHotel;
    public JPanel panelImg;
    public JPanel panelNombre;
    public JPanel panelDescripcion;
    public JPanel panelPrecio;
    public JPanel panelBoton;
    public JPanel panelCalificacion;
    public JLabel llogo;
    public JLabel ltitulo;
    public JLabel ldescripcion;
    public JLabel lprecio;
    public JLabel lcalificacion;

    
    public JButton beditar;
    
    public FlowLayout miflow;
    public GridBagLayout gridbag;
    public BoxLayout box;
    public GridBagConstraints gbc;

    public VerAlojamientosV() {
       super("Ver Alojamientos");
       
       ImageIcon fondo = new ImageIcon("fondo.jpg");
        setContentPane(new JLabel(fondo));
        
        contenedor = getContentPane();
        
         contenedor.setLayout(new BorderLayout());

        
        panelTop = new JPanel();
        miflow = new FlowLayout();
        panelTop.setLayout(miflow);
        
        
        panelDown = new JPanel();
        gridbag = new GridBagLayout();
        panelDown.setLayout(gridbag);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        
        
        //panelNorte
        panelNorte = new JPanel();
        gridbag = new GridBagLayout();
        panelNorte.setLayout(gridbag);
        panelNorte.setPreferredSize(new Dimension(1500,100));
        
        
        
        panelBIniciarSesion = new JPanel();
        miflow = new FlowLayout();
        panelBIniciarSesion.setLayout(miflow); 
        
        

        
        ImageIcon iconu=new ImageIcon("volver.png");
        Image imgu = iconu.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconu=new ImageIcon(imgu);
        
        bvolver = new JButton("Volver",iconu);
        bvolver.setFont(new Font("Times New Roman", 0, 20));
        bvolver.setBackground(Color.white);
        bvolver.putClientProperty("valor", 0);
        bvolver.setPreferredSize(new Dimension(150,40));
        
        panelBIniciarSesion.add(bvolver);
        
        panelTitulo = new JPanel();
        miflow = new FlowLayout();
        panelTitulo.setLayout(miflow);
        
        
        ltitulo = new JLabel("Mis alojamientos");
        ltitulo.setFont(new Font("Times New Roman", 1, 40));
        
        panelTitulo.add(ltitulo);
        
        gbc.insets = new Insets(10, 10, 10, 10);
        panelNorte.add(panelTitulo, gbc);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(10, 800, 10, 10);
        
        panelNorte.add(panelBIniciarSesion, gbc);
        
        
        
        panelTop.add(panelNorte);
        
        contenedor.add(panelTop,BorderLayout.NORTH);
        
        
        
        
    
    }
}
