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
public class AlojamientosV extends JFrame{
    public Container contenedor ;
    public JButton biniciarSesion;
    public JButton busuario;
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

    
    public JButton bvermas;
    
    public FlowLayout miflow;
    public GridBagLayout gridbag;
    public BoxLayout box;
    public GridBagConstraints gbc;

    public AlojamientosV() {
       super("Alojamientos");
        
       ImageIcon fondo = new ImageIcon("fondo.jpg");
        setContentPane(new JLabel(fondo));
        contenedor = getContentPane();
        
         contenedor.setLayout(new BorderLayout());

        
        panelTop = new JPanel();
        miflow = new FlowLayout();
        panelTop.setLayout(miflow);
        panelTop.setBackground(Color.LIGHT_GRAY);
        
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
        panelNorte.setBackground(new Color(99, 124, 119));
        
        
        panelBIniciarSesion = new JPanel();
        miflow = new FlowLayout();
        panelBIniciarSesion.setLayout(miflow); 
        panelBIniciarSesion.setBackground(new Color(99, 124, 119));
        
        
        ImageIcon iconac=new ImageIcon("iniciar_sesion.png");
        Image imgac = iconac.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconac=new ImageIcon(imgac);
        
        biniciarSesion = new JButton("Iniciar Sesion",iconac);
        biniciarSesion.setFont(new Font("Times New Roman", 0, 20));
        biniciarSesion.setBackground(Color.white);
//        biniciarSesion.setContentAreaFilled(false);
        biniciarSesion.setBorderPainted(false);
        biniciarSesion.putClientProperty("valor", 0);
        
        ImageIcon iconu=new ImageIcon("usuario.png");
        Image imgu = iconu.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconu=new ImageIcon(imgu);
        
        busuario = new JButton("",iconu);
        busuario.setFont(new Font("Times New Roman", 0, 20));
        busuario.setBackground(Color.white);
//        biniciarSesion.setContentAreaFilled(false);
//        busuario.setBorderPainted(false);
        busuario.putClientProperty("valor", -1);
        
        panelBIniciarSesion.add(biniciarSesion);
        
        panelTitulo = new JPanel();
        miflow = new FlowLayout();
        panelTitulo.setLayout(miflow);
        panelTitulo.setBackground(new Color(99, 124, 119));
        
        ImageIcon logoIcon = new ImageIcon("logoDos.PNG");
        Image scaledImage0 = logoIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        llogo = new JLabel(new ImageIcon(scaledImage0));
        
        panelTitulo.add(llogo);
        
        gbc.insets = new Insets(10, 10, 10, 10);
        panelNorte.add(panelTitulo, gbc);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(10, 950, 10, 10);
        
        panelNorte.add(panelBIniciarSesion, gbc);
        
        
        
        panelTop.add(panelNorte);
        
        contenedor.add(panelTop,BorderLayout.NORTH);
        
        
        
        
    
    }
}
