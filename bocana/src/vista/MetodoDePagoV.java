/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author estud
 */
public class MetodoDePagoV extends JFrame{
    public Container contenedor;
    public JPanel panel;
    public JLabel elige;
    public JComboBox lista;
    public JButton cancelar, continuar;
    public String medio[] = {"","Efectivo","Tarjeta"};
    private FlowLayout miflow;
    private final GridLayout migrid;
    
    public MetodoDePagoV() {
        super("Metodo de pago");
        
        lista = new JComboBox(medio);
        
        ImageIcon fondo = new ImageIcon("fondo.jpg");
        setContentPane(new JLabel(fondo));
        
        contenedor = getContentPane();
        miflow = new FlowLayout(FlowLayout.CENTER);
        contenedor.setLayout(miflow);
        
        panel = new JPanel();
        migrid = new GridLayout(2,2,4,8);
        panel.setLayout(migrid);
        
        elige = new JLabel("Elige medio de pago");
        
        cancelar = new JButton("Cancelar");
        continuar = new JButton("Continuar");
        
        panel.add(elige);
        panel.add(lista);
        panel.add(cancelar);
        panel.add(continuar);
        
        contenedor.add(panel);
        
    } 
            
}
