/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class EditarUsuarioV extends JFrame{
    public Container contenedor;
    public JLabel infor;
    public JLabel lregistrar;
    public JLabel lnombre1;
    public JLabel lnombre2;
    public JLabel lapellido1;
    public JLabel lapellido2;
    public JLabel lcorreo;
    public JLabel ltelefono;
    public JLabel ldireccion;
    public JLabel lcontrasena;
    public JTextField tnombre1;
    public JTextField tnombre2;
    public JTextField tapellido1;
    public JTextField tapellido2;
    public JTextField tcorreo;
    public JTextField ttelefono;
    public JTextField tdireccion;
    public JPasswordField tcontrasena;
    public JButton beditar;
    public JButton bcancelar;
    public JPanel panelBag;
    public JPanel panel;
    public JPanel panelNorte;
    public JPanel panelCentro;
    public JPanel panelSur;
    public JPanel info;
    private GridLayout migrid;
    private FlowLayout miflow;
    private GridBagLayout gridbag;
    private GridBagConstraints gbc;
    private GridBagConstraints gbcn;
    
    
    public EditarUsuarioV() {
        
        super("Editar");
         ImageIcon fondo = new ImageIcon("fondo.jpg");
          setContentPane(new JLabel(fondo));
        
        contenedor = getContentPane();
        miflow = new FlowLayout();
        contenedor.setLayout(miflow);
        
        panel = new JPanel();
        gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        
        info = new JPanel();
        miflow = new FlowLayout();
        info.setLayout(miflow);
        
        //panelNorte
        panelNorte = new JPanel();
        miflow = new FlowLayout();
        panelNorte.setLayout(miflow);
        
        
        lregistrar = new JLabel("Editar Usuario");
        lregistrar.setFont(new Font("Times New Roman", 1, 80));
        
        
        panelNorte.add(lregistrar);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 100, 50, 100);
        
        panel.add(panelNorte, gbc);
        
        infor = new JLabel("<html> <br>La contraseña debe ser de 8 digitos "
                + "<br>Debe contener una mayuscula"
                + "<br>Debe contener un (@$!%*?&)</html>");
        infor.setForeground(Color.red);
        
        info.add(infor);
        //panelCentro
        panelCentro = new JPanel();
        migrid = new GridLayout(8, 2, 80, 8);
        panelCentro.setLayout(migrid);
        
        lnombre1 = new JLabel("Primer nombre");
        lnombre1.setFont(new Font("Times New Roman", 0, 30));
        lnombre2 = new JLabel("Segundo nombre");
        lnombre2.setFont(new Font("Times New Roman", 0, 30));
        lapellido1 = new JLabel("Primer apellido");
        lapellido1.setFont(new Font("Times New Roman", 0, 30));
        lapellido2 = new JLabel("Segundo apellido");
        lapellido2.setFont(new Font("Times New Roman", 0, 30));
        lcorreo = new JLabel("Correo");
        lcorreo.setFont(new Font("Times New Roman", 0, 30));
        ltelefono = new JLabel("Telefono");
        ltelefono.setFont(new Font("Times New Roman", 0, 30));
        ldireccion = new JLabel("Direccion");
        ldireccion.setFont(new Font("Times New Roman", 0, 30));
        lcontrasena = new JLabel("Contrase\u00f1a");
        lcontrasena.setFont(new Font("Times New Roman", 0, 30));
        
        tnombre1 = new JTextField(10);
        tnombre1.setFont(new Font("Times New Roman", 0, 25));
        tnombre2 = new JTextField(10);
        tnombre2.setFont(new Font("Times New Roman", 0, 25));
        tapellido1 = new JTextField(10);
        tapellido1.setFont(new Font("Times New Roman", 0, 25));
        tapellido2 = new JTextField(10);
        tapellido2.setFont(new Font("Times New Roman", 0, 25));
        tcorreo = new JTextField(10);
        tcorreo.setFont(new Font("Times New Roman", 0, 25));
        ttelefono = new JTextField(10);
        ttelefono.setFont(new Font("Times New Roman", 0, 25));
        tdireccion = new JTextField(10);
        tdireccion.setFont(new Font("Times New Roman", 0, 25));
        tcontrasena = new JPasswordField(10);
        tcontrasena.setFont(new Font("Times New Roman", 0, 25));
        
        panelCentro.add(lnombre1);
        panelCentro.add(tnombre1);
        panelCentro.add(lnombre2);
        panelCentro.add(tnombre2);
        panelCentro.add(lapellido1);
        panelCentro.add(tapellido1);
        panelCentro.add(lapellido2);
        panelCentro.add(tapellido2);
        panelCentro.add(lcorreo);
        panelCentro.add(tcorreo);
        panelCentro.add(ltelefono);
        panelCentro.add(ttelefono);
        panelCentro.add(ldireccion);
        panelCentro.add(tdireccion);
        panelCentro.add(lcontrasena);
        panelCentro.add(tcontrasena);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 30, 50);
        
        panel.add(panelCentro, gbc);
        panel.add(info, gbc);
        
        
        //panelSur
        panelSur = new JPanel();
        migrid = new GridLayout(1, 2, 8, 8);
        panelSur.setLayout(migrid);
        
        
        bcancelar = new JButton("Cancelar");
        bcancelar.setFont(new Font("Times New Roman", 0, 20));
        
        bcancelar.setContentAreaFilled(false);
        bcancelar.setForeground(Color.BLACK);
        
        beditar = new JButton("Editar");
        beditar.setFont(new Font("Times New Roman", 0, 20));
        
        beditar.setContentAreaFilled(false);
        beditar.setForeground(Color.BLACK);
        
        panelSur.add(bcancelar);
        panelSur.add(beditar);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 10, 50);
        
        panel.add(panelSur, gbc);
        
        contenedor.add(panel);
        contenedor.add(info);
    
    }
}
