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
public class RegistrarHabitacionV extends JFrame{
    public Container contenedor;
    public JLabel lregistrar,lnombreHabitacion, ldescripcionBreve, ldescripcionDetallada, ltarifa,ltipoHabitacion, lfotos;
    public JTextField tnombreHabitacion,tdescripcionBreve, tdescripcionDetallada, ttarifa;
    public JButton bregistrar;
    public JButton bcancelar;
    public JButton bfotos, bcargar;
//    public JButton bsuite, bestandar, bfamiliar, bdeluxe, beconomica, bpresidencial;
    public String tiposHabitaciones[] = {"","Suite","Estandar","Familiar","Deluxe","Economica","Presidencial"};
    public JComboBox lista;
    public JPanel panelBag;
    public JPanel panel;
    public JPanel panelNorte;
    public JPanel panelCentro;
    public JPanel panelSur;
    public JPanel panelServicios;
    public JPanel panelbfotos;
    public JPanel panelFotos;
    private ImageIcon iconsuite, iconestandar, iconfamiliar, icondeluxe, iconeconomica, iconpresidencial;
    private Image imgsuite, imgestandar, imgfamiliar, imgdeluxe, imgeconomica, imgpresidencial;
    public GridLayout migrid;
    private FlowLayout miflow;
    private GridBagLayout gridbag;
    private GridBagConstraints gbc;
    private GridBagConstraints gbcn;
    
    public List<byte[]> imagenes = new ArrayList<>();
    public List<JLabel> fotos = new ArrayList<>();
    
    public RegistrarHabitacionV(){
        
        super("Registrar Habitacion");
        
        lista = new JComboBox(tiposHabitaciones);
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
        
        
        lregistrar = new JLabel("Registrar Habitacion");
        lregistrar.setFont(new Font("Times New Roman", 1, 80));
        
        
        panelNorte.add(lregistrar);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 100, 50, 100);
        
        panel.add(panelNorte, gbc);
        
        
        //panelCentro
        panelCentro = new JPanel();
        migrid = new GridLayout(6, 2, 80, 8);
        panelCentro.setLayout(migrid);
        
        lnombreHabitacion = new JLabel("Nombre de habitacion");
        lnombreHabitacion.setFont(new Font("Times New Roman", 0, 30));
        ldescripcionBreve = new JLabel("Descripcion breve");
        ldescripcionBreve.setFont(new Font("Times New Roman", 0, 30));
        ldescripcionDetallada = new JLabel("Descripcion detallada");
        ldescripcionDetallada.setFont(new Font("Times New Roman", 0, 30));
        ltarifa = new JLabel("Tarifa");
        ltarifa.setFont(new Font("Times New Roman", 0, 30));
        ltipoHabitacion = new JLabel("Tipo habitacion");
        ltipoHabitacion.setFont(new Font("Times New Roman", 0, 30));

        tnombreHabitacion = new JTextField(10);
        tnombreHabitacion.setFont(new Font("Times New Roman", 0, 25));
        tdescripcionBreve = new JTextField(10);
        tdescripcionBreve.setFont(new Font("Times New Roman", 0, 25));
        tdescripcionDetallada = new JTextField(10);
        tdescripcionDetallada.setFont(new Font("Times New Roman", 0, 25));
        ttarifa = new JTextField(10);
        ttarifa.setFont(new Font("Times New Roman", 0, 25));
        lista.setFont(new Font("Times New Roman", 0, 25));

        panelCentro.add(lnombreHabitacion);
        panelCentro.add(tnombreHabitacion);
        panelCentro.add(ldescripcionBreve);
        panelCentro.add(tdescripcionBreve);
        panelCentro.add(ldescripcionDetallada);
        panelCentro.add(tdescripcionDetallada);
        panelCentro.add(ltarifa);
        panelCentro.add(ttarifa);
        panelCentro.add(ltipoHabitacion);
        panelCentro.add(lista);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 30, 50);
        
        panel.add(panelCentro, gbc);
        
//        //panelServicios
//        
//        panelServicios = new JPanel();
//        migrid = new GridLayout(2,3,5,5);
//        panelServicios.setLayout(migrid);
//        
//        ltipoHabitacion = new JLabel("Tipos de servicios");
//        ltipoHabitacion.setFont(new Font("Times New Roman", 0, 30));
//        
//        
//        iconsuite=new ImageIcon("suite.png");
//        imgsuite = iconsuite.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//        iconsuite=new ImageIcon(imgsuite);
//
//        bsuite = new JButton("Suite",iconsuite);
//        bsuite.setFont(new Font("Times New Roman", 0, 20)); 
//        bsuite.setBackground(Color.white);
//        bsuite.setForeground(Color.BLACK);
//        bsuite.putClientProperty("valor", 0);
//        
//        iconestandar=new ImageIcon("estandar.png");
//        imgestandar = iconestandar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//        iconestandar=new ImageIcon(imgestandar);
//       
//        bestandar = new JButton("Estandar",iconestandar);
//        bestandar.setFont(new Font("Times New Roman", 0, 20));
//        bestandar.setBackground(Color.white);
//        bestandar.setForeground(Color.BLACK);
//        bestandar.putClientProperty("valor", 1);
//        
//        iconfamiliar=new ImageIcon("familiar.png");
//        imgfamiliar = iconfamiliar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//        iconfamiliar=new ImageIcon(imgfamiliar);
//        
//        bfamiliar = new JButton("Familiar", iconfamiliar);
//        bfamiliar.setFont(new Font("Times New Roman", 0, 20)); 
//        bfamiliar.setBackground(Color.white);
//        bfamiliar.setForeground(Color.BLACK);
//        bfamiliar.putClientProperty("valor", 2);
//        
//        icondeluxe=new ImageIcon("deluxe.png");
//        imgdeluxe = icondeluxe.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//        icondeluxe=new ImageIcon(imgdeluxe);
//       
//        bdeluxe = new JButton("Deluxe", icondeluxe);
//        bdeluxe.setFont(new Font("Times New Roman", 0, 20));
//        bdeluxe.setBackground(Color.white);
//        bdeluxe.setForeground(Color.BLACK);
//        bdeluxe.putClientProperty("valor", 3);
//        
//        iconeconomica=new ImageIcon("economica.png");
//        imgeconomica = iconeconomica.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//        iconeconomica=new ImageIcon(imgeconomica);
//        
//        beconomica = new JButton("Economica", iconeconomica);
//        beconomica.setFont(new Font("Times New Roman", 0, 20)); 
//        beconomica.setBackground(Color.white);
//        beconomica.setForeground(Color.BLACK);
//        beconomica.putClientProperty("valor", 4);
//        
//        iconpresidencial=new ImageIcon("presidencial.png");
//        imgpresidencial = iconpresidencial.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//        iconpresidencial=new ImageIcon(imgpresidencial);
//       
//        bpresidencial = new JButton("Presidencial",iconpresidencial);
//        bpresidencial.setFont(new Font("Times New Roman", 0, 20));
//        bpresidencial.setBackground(Color.white);
//        bpresidencial.setForeground(Color.BLACK);
//        bpresidencial.putClientProperty("valor", 5);
//
//        
//        panelServicios.add(bsuite);
//        panelServicios.add(bestandar);
//        panelServicios.add(bfamiliar);
//        panelServicios.add(bdeluxe);
//        panelServicios.add(beconomica);
//        panelServicios.add(bpresidencial);
        
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 1;
//        gbc.insets = new Insets(10, 50, 15, 50);
//        
//        panel.add(ltipoHabitacion, gbc);
//        
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        gbc.gridwidth = 3;
//        gbc.gridheight = 1;
//        gbc.insets = new Insets(10, 50, 30, 50);
//        
//        panel.add(lista, gbc);
        
        
        lfotos = new JLabel("Agregar fotos");
        lfotos.setFont(new Font("Times New Roman", 0, 30));
        
        panelbfotos = new JPanel();
        migrid = new GridLayout(1,2,10,10);
        panelbfotos.setLayout(migrid);
        
        
        bfotos = new JButton("Agregar...");
        bfotos.setFont(new Font("Times New Roman", 0, 20));
        bfotos.setBackground(Color.white);
        bfotos.setForeground(Color.BLACK);
        
        bcargar = new JButton("Cargar");
        bcargar.setFont(new Font("Times New Roman", 0, 20));
        bcargar.setBackground(Color.white);
        bcargar.setForeground(Color.BLACK);
        
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(lfotos, gbc);
        
        panelbfotos.add(bfotos);
        panelbfotos.add(bcargar);
        
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        panel.add(panelbfotos, gbc);
        
        
        panelFotos = new JPanel();
        
        
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        panel.add(panelFotos, gbc);
        
        
        //panelSur
        panelSur = new JPanel();
        migrid = new GridLayout(1, 2, 8, 8);
        panelSur.setLayout(migrid);
        
        
        bcancelar = new JButton("Cancelar");
        bcancelar.setFont(new Font("Times New Roman", 0, 20));
        
        bcancelar.setContentAreaFilled(false);
        bcancelar.setForeground(Color.BLACK);
        
        bregistrar = new JButton("Registrar");
        bregistrar.setFont(new Font("Times New Roman", 0, 20));
        
        bregistrar.setContentAreaFilled(false);
        bregistrar.setForeground(Color.BLACK);
        
        panelSur.add(bcancelar);
        panelSur.add(bregistrar);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 10, 50);
        
        panel.add(panelSur, gbc);
        
        

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1000, 680)); // Establece un tamaño preferido para el JScrollPane

        
        contenedor.add(scrollPane);
        
    
    }
}
