/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.UsuarioDao;

/**
 *
 * @author estud
 */
public class PagoV extends JFrame{
    UsuarioDao usuDao= new UsuarioDao();
    int id_usu=2;
    String temp;
    
   

    public Container contenedor;
    public JPanel panel, panelNorte, panelCentro, panelSur;
    public JLabel titulo, tmonto, monto, tfecha, fecha, tiTarjetas;
    public FlowLayout miflow;
    public GridLayout grid;
    public String tarjetas[];
    public ArrayList <String> lisTarjetas;
    public JButton continuar, cancelar;
    public JComboBox listaTarjetas;
    public GridBagConstraints gbc;
    public GridBagLayout gridbag;
    
    public PagoV(){
        super("Pago");
        
        lisTarjetas = usuDao.buscarTarjeta(id_usu);
        
        tarjetas = new String[usuDao.buscarTarjeta(id_usu).size()+1];
        
        
        for(int x=0;x<usuDao.buscarTarjeta(id_usu).size();x++){
            if(x==0){
                tarjetas[x]="";
            }
            temp = lisTarjetas.get(x);
            System.out.print(temp);
            tarjetas[x] = temp;
        }
        
        
        
         ImageIcon fondo = new ImageIcon("fondo.jpg");
         setContentPane(new JLabel(fondo));
         
         contenedor = getContentPane();
         miflow = new FlowLayout(FlowLayout.CENTER);
         contenedor.setLayout(miflow);
          
           gbc = new GridBagConstraints();
           gbc.gridx = 0;
           gbc.gridy = 0;
           gbc.gridwidth = 3;
           gbc.gridheight = 1;
           gbc.insets = new Insets(100, 100, 20, 100);
          
         panel = new JPanel();
         gridbag = new GridBagLayout();
         panel.setLayout(gridbag);
         
         panelNorte = new JPanel();
         miflow = new FlowLayout(FlowLayout.CENTER);
         panelNorte.setLayout(miflow);
         
         titulo = new JLabel("Pago");
         titulo.setFont(new Font("Times New Roman", 1, 60));
         
         panelNorte.add(titulo);
         
        panelSur = new JPanel();
        grid = new GridLayout(1,2,5,5);
        panelSur.setLayout(grid);
        
        continuar = new JButton("Continuar");
        cancelar = new JButton("Cancelar");
        
        panelSur.add(cancelar);
        panelSur.add(continuar);
        
        listaTarjetas = new JComboBox(tarjetas);
        tiTarjetas = new JLabel("Seleccione una tarjeta *(Solo si el pago es por tarjeta)");
        tmonto = new JLabel ("Monto:");
        monto = new JLabel("");
        tfecha = new JLabel("Fecha:");
        fecha = new JLabel("");
        
        
        panelCentro = new JPanel();
        grid = new GridLayout(3,2,7,7);
        panelCentro.setLayout(grid);
        
        panelCentro.add(tmonto);
        panelCentro.add(monto);
        panelCentro.add(tfecha);
        panelCentro.add(fecha);
        panelCentro.add(tiTarjetas);
        panelCentro.add(listaTarjetas);
        
        
        
        panel.add(panelNorte, gbc);
        
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 100, 20, 100);
        
        panel.add(panelCentro, gbc);
        
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 100, 100, 100);
        
        panel.add(panelSur, gbc);
        
        contenedor.add(panel);
    }
}
