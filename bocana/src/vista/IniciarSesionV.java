/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Usuario
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IniciarSesionV
extends JFrame {
    public Container contenedor ;
    public JLabel liniciarSesion;
    public JLabel lcorreo;
    public JLabel lcontrasena;
    public JTextField tcorreo;
    public JPasswordField tcontrasena;
    public JButton biniciarSesion;
    public JButton bregistrarse;
    public JButton bcancelar;
    public JPanel panel;
    public JPanel panelNorte;
    public JPanel panelCentro;
    public JPanel panelSur;
    private GridLayout migrid;
    private FlowLayout miflow;
    private GridBagLayout gridbag;
    private BoxLayout box;
    private GridBagConstraints gbc;
    private GridBagConstraints gbcn;
    private GridBagConstraints gbcs;
    public JCheckBox ver;

    public IniciarSesionV() {
        super("iniciar Sesion");
         ImageIcon fondo = new ImageIcon("fondo.jpg");
          setContentPane(new JLabel(fondo));
        
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
        
        liniciarSesion = new JLabel("Iniciar sesion");
        liniciarSesion.setFont(new Font("Times New Roman", 1, 80));
        
        panelNorte.add(liniciarSesion);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(60, 100, 60, 100);
        
        panel.add(panelNorte, gbc);
        
        
        //panelCentro
        panelCentro = new JPanel();
        migrid = new GridLayout(5, 1, 80, 8);
        panelCentro.setLayout(migrid);
        
         
        
        
        lcorreo = new JLabel("Correo");
        lcorreo.setFont(new Font("Times New Roman", 0, 30));
        lcontrasena = new JLabel("Contraseña");
        lcontrasena.setFont(new Font("Times New Roman", 0, 30));

        ver = new JCheckBox("Mostrar contraseña");
        tcorreo = new JTextField(10);
        tcorreo.setFont(new Font("Times New Roman", 0, 25));
        tcontrasena = new JPasswordField(10);
        tcontrasena.setEchoChar('*');
        tcontrasena.setFont(new Font("Times New Roman", 0, 25));
        
        panelCentro.add(lcorreo);
        panelCentro.add(tcorreo);
        panelCentro.add(lcontrasena);
        panelCentro.add(tcontrasena);
        panelCentro.add(ver);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 50, 50);

        
        panel.add(panelCentro, gbc);
        
        
        
        //panelSur
        panelSur = new JPanel();
        migrid = new GridLayout(1, 3, 8, 8);
        panelSur.setLayout(migrid);
        
        
       
        bcancelar = new JButton("Cancelar");
        bcancelar.setFont(new Font("Times New Roman", 0, 20));
        
        bcancelar.setContentAreaFilled(false);
        bcancelar.setForeground(Color.BLACK);
        
        biniciarSesion = new JButton("Iniciar Sesion");
        biniciarSesion.setFont(new Font("Times New Roman", 0, 20));
        
        biniciarSesion.setContentAreaFilled(false);
        biniciarSesion.setForeground(Color.BLACK);
        
        bregistrarse = new JButton("Registrarse");
        bregistrarse.setFont(new Font("Times New Roman", 0, 20));
        
        bregistrarse.setContentAreaFilled(false);
        bregistrarse.setForeground(Color.BLACK);
        
        biniciarSesion.setBackground(Color.LIGHT_GRAY);
        bcancelar.setBackground(Color.LIGHT_GRAY);
        bregistrarse.setBackground(Color.LIGHT_GRAY);
        
        panelSur.add(bcancelar);
        panelSur.add(bregistrarse);
        panelSur.add(biniciarSesion);
        
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 50, 50, 50);
        
        panel.add(panelSur, gbc);
        
        contenedor.add(panel);
    }
}
