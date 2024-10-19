/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HotelV extends JFrame {
     private Container contenedor;
    private GridLayout migrid;
    private FlowLayout miflow;
    private GridBagLayout gridbag;
    private GridBagConstraints gbc;
    private GridBagConstraints gbcn;
    private JLabel info, logo, lregistrar, liniciar;
    private JPanel panelsur, panelnorte, panelcentro, panel;
    public JButton iniciar, registrar, inicio;
    private ImageIcon fondo;
    
    public HotelV (){
        
        super("Alojamientos Bocana");
        
        fondo = new ImageIcon("fondo.jpg");
        setContentPane(new JLabel(fondo));
        
        contenedor = getContentPane();
        miflow = new FlowLayout(FlowLayout.CENTER);
        contenedor.setLayout(miflow);
        
    
        
//        contenedor.setBackground(Color.Hex);



        panel = new JPanel();
        gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
//        panel.setAlignmentY(CENTER_ALIGNMENT);
//        panel.setAlignmentX(CENTER_ALIGNMENT);
        
        Color fondoColor = new Color(99, 124, 119);
        panel.setBackground(fondoColor);
        
        
        info = new JLabel("<html><center>Alojamientos Bocana <br>Observa sin compromiso</center></html>");
        info.setFont(new Font("Times New Roman", 2, 14));
        info.setForeground(Color.lightGray);
        
       
         //panel norte
         
         
         panelnorte = new JPanel();
         miflow = new FlowLayout(FlowLayout.CENTER);
        panelnorte.setLayout(miflow);
        panelnorte.setBackground(fondoColor);
         ImageIcon logoIcon = new ImageIcon("logoDos.PNG");
          Image scaledImage0 = logoIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        logo = new JLabel(new ImageIcon(scaledImage0));
        
        panelnorte.add(logo);
        
         gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30, 20,  20, 20);
         
         panel.add(panelnorte,gbc);
        
        
        
        //panel centro
        
//         panelcentro = new JPanel();
//         miflow = new FlowLayout();
//        panelcentro.setLayout(miflow);
//        panelcentro.setBackground(fondoColor);
    
        
         ImageIcon inicioIcon = new ImageIcon("flecha-derecha.PNG");
         Image scaledImage1 = inicioIcon.getImage().getScaledInstance(70, 50, Image.SCALE_SMOOTH);
         
         inicio = new JButton("");
         inicio.setIcon(new ImageIcon(scaledImage1));
         

         
         inicio.setBorderPainted(false);
         inicio.setContentAreaFilled(false);
         
//         panelcentro.add(inicio);
         

        gbc.gridy = 1;
        gbc.insets = new Insets(30, 20,  45, 20);

         
         panel.add(inicio,gbc);

         
         //panel sur
         
         panelsur = new JPanel();
         migrid = new GridLayout(2, 2, 30, 0);
        panelsur.setLayout(migrid);
        panelsur.setBackground(fondoColor);
         
         ImageIcon iniciarIcon = new ImageIcon("iniciarSesion.PNG");
         Image scaledImage2 = iniciarIcon.getImage().getScaledInstance(70, 40, Image.SCALE_SMOOTH);
         
         ImageIcon registroIcon = new ImageIcon("registro.PNG");
         Image scaledImage3 = registroIcon.getImage().getScaledInstance(70, 40, Image.SCALE_SMOOTH);
         
         liniciar = new JLabel("<html><center>¿Ya tienes una cuenta? <br>Inicia sesion</center></html>");
         lregistrar = new JLabel("<html><center>¿No tienes una cuenta? <br>Registrate</center></html>");
         liniciar.setFont(new Font("Times New Roman", 2, 14));
         lregistrar.setFont(new Font("Times New Roman", 2, 14));
         liniciar.setForeground(Color.LIGHT_GRAY);
         lregistrar.setForeground(Color.LIGHT_GRAY);
         
         iniciar = new JButton("");
         iniciar.setIcon(new ImageIcon(scaledImage2));
         registrar = new JButton("");
         registrar.setIcon(new ImageIcon(scaledImage3));
         
         iniciar.setBorderPainted(false);
        iniciar.setContentAreaFilled(false);
        
        registrar.setBorderPainted(false);
        registrar.setContentAreaFilled(false);
         
         iniciar.setBounds(20, 20, 50, 30);
         registrar.setBounds(20, 20, 50, 30);
         
         panelsur.add(liniciar);
         panelsur.add(lregistrar);
         panelsur.add(iniciar);         
         panelsur.add(registrar);
         
       
        gbc.gridy = 2;
       
         
         panel.add(panelsur,gbc);
        
         gbc.insets = new Insets(30, 20,  20, 20);

        gbc.gridy = 3;

         panel.add(info, gbc);
         
         
         gbc.insets = new Insets(10, 20,  20, 20);
         contenedor.add(panel);
    }


}