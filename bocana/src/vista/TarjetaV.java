/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.border.Border;

/**
 *
 * @author estud
 */
public class TarjetaV extends JFrame{
    public JLabel lnumTarjeta, lcvv, lvencimiento, lnombrePropietario, lapellidoPropietario, titulo, ltipo, lbanco,ltipoDebito;
    public JTextField tnumTarjeta, tnombrePropietario,tapellidoPropietario, tvencimiento;
    public JPasswordField cvv;
    public JButton cancelar, continuar;
    public JPanel panelCentro, panelNorte, panelSur, panel;
    public Container contenedor;
    public FlowLayout miflow;
    public GridLayout migrid;
    public String tipo[] = {"","Debito","Credito"};
    public String bancos[] = {"","Bancolombia", "BBVA","Banco de Bogotá", "Banco Agrario de Colombia", "Citibank", "Banco AV Villas"};
    public String tipoDebito[]={"Ninguno","Ahorros", "Corriente"};
    public JComboBox listaTipo, listaBanco, listaTipoDebito;
    public GridBagLayout gridBag;
    public GridBagConstraints gbc;
    public JCheckBox guardar;
    private JPanel panel1, panel2, panel3, panel4;
    
    public TarjetaV() {
         super("Agregar tarjeta");
         
          ImageIcon fondo = new ImageIcon("fondo.jpg");
          setContentPane(new JLabel(fondo));

          contenedor = getContentPane();
          miflow = new FlowLayout(FlowLayout.CENTER);
          contenedor.setLayout(miflow);
          
          lnumTarjeta = new JLabel("Numero de tarjeta");
          lcvv = new JLabel("CVV *(3 digitos)");
          lnombrePropietario = new JLabel("Primer nombre del titular");
          lapellidoPropietario = new JLabel("Primer apellido del titular");
          lvencimiento = new JLabel("Fecha de vencimiento (MM/AAAA)");
          
          lnumTarjeta.setFont(new Font("Times New Roman", 1, 16));
          lcvv.setFont(new Font("Times New Roman", 1, 14));
          lnombrePropietario.setFont(new Font("Times New Roman", 1, 16));
          lapellidoPropietario.setFont(new Font("Times New Roman", 1, 16));
          lvencimiento.setFont(new Font("Times New Roman", 1, 16));
          
          tnumTarjeta = new JTextField(10);
          cvv = new JPasswordField(3);
          tnombrePropietario = new JTextField(10);
          tapellidoPropietario = new JTextField(10);
          tvencimiento = new JTextField(10);
          
          Border border = BorderFactory.createDashedBorder(Color.LIGHT_GRAY, 5,1);
          tnumTarjeta.setBorder(border);
          cvv.setBorder(border);
          tnombrePropietario.setBorder(border);
          tapellidoPropietario.setBorder(border);
          tvencimiento.setBorder(border);
          
        guardar = new JCheckBox("Recordar tarjeta");
          
          ltipo = new JLabel("Selecciona el tipo de tarjeta");
          lbanco = new JLabel("Selecciona tu banco");
          ltipoDebito = new JLabel("Selecciona tipo *(Si la tarjeta es debito)");
          ltipo.setFont(new Font("Times New Roman", 1, 16));
          lbanco.setFont(new Font("Times New Roman", 1, 16));
          ltipoDebito.setFont(new Font("Times New Roman", 1, 16));
          
          listaTipo = new JComboBox(tipo);
          listaTipo.setBorder(border);
         
          listaBanco= new JComboBox(bancos);
          listaBanco.setBorder(border);
          
          listaTipoDebito= new JComboBox(tipoDebito);
          listaTipoDebito.setBorder(border);
          
         Color fondoText = new Color(209, 217, 227);
         
         tnumTarjeta.setBackground(fondoText);
         cvv.setBackground(fondoText);
         tnombrePropietario.setBackground(fondoText);
         tapellidoPropietario.setBackground(fondoText);
         tvencimiento.setBackground(fondoText);
         listaTipo.setBackground(fondoText);
         listaBanco.setBackground(fondoText);
         listaTipoDebito.setBackground(fondoText);
         
         
         
          titulo = new JLabel("Agregar tarjeta");
          titulo.setFont(new Font("Times New Roman", 1, 60));
          
          cancelar = new JButton("Cancelar");
          continuar = new JButton("Continuar");
          
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 4;
            gbc.gridheight = 1;
            gbc.insets = new Insets(100, 100, 20, 100);
          
         panel = new JPanel();
         gridBag = new GridBagLayout();
        panel.setLayout(gridBag);
        
        Color fondoColor = new Color(99, 124, 119);
        panel.setBackground(fondoColor);
            
         panelNorte = new JPanel();
         miflow = new FlowLayout(FlowLayout.CENTER);
         panelNorte.setLayout(miflow);
         
         panelCentro = new JPanel();
         migrid = new GridLayout(4,1,5,5);
         panelCentro.setLayout(migrid);
         
         panelSur = new JPanel();
         migrid = new GridLayout(1,2,5,5);
         panelSur.setLayout(migrid);
         
         panel1= new JPanel();
         migrid = new GridLayout(3,2,3,3);
         panel1.setLayout(migrid);
         
         panel2 = new JPanel();
         migrid = new GridLayout(2, 2,3,3);
         panel2.setLayout(migrid);
         
         panel3 = new JPanel();
         migrid = new GridLayout(2, 2,3,3);
         panel3.setLayout(migrid);
         
         panel4 = new JPanel();
         migrid = new GridLayout(2,1,10,10);
         panel4.setLayout(migrid);
         
         panelNorte.setBackground(fondoColor);
         panelSur.setBackground(fondoColor);
         panelCentro.setBackground(fondoColor);
         panel1.setBackground(fondoColor);
         panel2.setBackground(fondoColor);
         panel3.setBackground(fondoColor);
         panel4.setBackground(fondoColor);
    
        //panel norte
         panelNorte.add(titulo);
         
         //panel centro
         panel1.add(ltipo);
         panel1.add(listaTipo);
         panel1.add(lbanco);
         panel1.add(listaBanco);
         panel1.add(ltipoDebito);
         panel1.add(listaTipoDebito);
         
         panelCentro.add(panel1);
         
         panel4.add(lnumTarjeta);
         panel4.add(tnumTarjeta);

         panelCentro.add(panel4);
         
         panel2.add(lvencimiento);
         panel2.add(tvencimiento);
         panel2.add(lcvv);
         panel2.add(cvv);
         
         panelCentro.add(panel2);
         
         panel3.add(lnombrePropietario);
         panel3.add(lapellidoPropietario);
         
         panel3.add(tnombrePropietario);
         panel3.add(tapellidoPropietario);
         
         panelCentro.add(panel3);
         
         panelSur.add(cancelar);
         panelSur.add(continuar);
         
         
         panel.add(panelNorte,gbc);
         
         gbc.gridy = 1;
         gbc.insets = new Insets(10, 50, 20, 50);
         
         panel.add(panelCentro,gbc);
         
         gbc.gridy = 2;
         gbc.insets = new Insets(10, 50, 10, 50);
         
         panel.add(guardar, gbc);
         
          gbc.gridy = 3;
         gbc.insets = new Insets(10, 50, 100, 50);
         
         panel.add(panelSur, gbc);
         
         contenedor.add(panel);
          
    }
    
    
}
