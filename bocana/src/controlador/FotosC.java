/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import modelo.Usuario;
import vista.FotosV;

/**
 *
 * @author estud
 */
public class FotosC implements ActionListener {

    FotosV vista = new FotosV();
    
    
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    
    public boolean flag = false;
    int num;
    byte[] imagen;
    FileInputStream entrada;
    FileOutputStream salida;
    List<JLabel> fotos = new ArrayList<>();
    List<byte[]> imagenes = new ArrayList<>();
    Usuario usuario = new Usuario();
    
    

    public FotosC(FotosV vista, List<JLabel> fotos, List<byte[]> imagenes, Usuario usuario) {
        this.usuario = usuario;
        this.vista = vista;
        this.fotos=fotos;
        this.imagenes=imagenes;
        
        for(JLabel foto : fotos){
            this.vista.panelCentro.add(foto);

        }
        this.vista.panelCentro.revalidate();
        this.vista.panelCentro.repaint();
        
        this.vista.seleccionar.addActionListener(this);
        this.vista.beliminar.addActionListener(this);
        this.vista.bcontinuar.addActionListener(this);
        this.vista.setExtendedState(6);
        this.vista.setVisible(true);
        this.vista.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.seleccionar) {
            if (seleccionar.showDialog(null, null) == JFileChooser.APPROVE_OPTION) {
                archivo = seleccionar.getSelectedFile();
                if (archivo.canRead()) {

                    agregarFoto(archivo);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }

            }
        }

        

        if (e.getSource() == vista.beliminar) {
            try{
                 num=Integer.parseInt(JOptionPane.showInputDialog(vista,"Ingrese el numero de la imagen que desea eliminar"));
                 if(num>0 && num<=fotos.size()){
                    eliminar(num);
                } else {
                    JOptionPane.showMessageDialog(vista, "El numero ingresado no coincide con la cantidad de imagenes seleccionadas");
                }
            } catch(NumberFormatException eN){
                JOptionPane.showMessageDialog(vista, "Ingrese un numero"+ eN.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        if(e.getSource()==vista.bcontinuar){
            flag=true;
        }
        
    }

    public byte[] abrirArchivo(File archivo) {
        byte[] imagen = new byte[1024 * 1024];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(imagen);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo: " + e.getMessage());
        }
        return imagen;
    }

    public int validarArchivo(File archivo, byte[] imagen) {
        int r = 0;
        try {
            salida = new FileOutputStream(archivo);
            salida.write(imagen);
            System.out.println("Se valido");
            r=1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo: " + e.getMessage());
            r=0;
        }
        return r;
    }

    private void agregarFoto(File archivo) {
        int x=fotos.size()+1;
        if (archivo.getName().endsWith("jpg")
            || archivo.getName().endsWith("jpeg")
            || archivo.getName().endsWith("png")
            || archivo.getName().endsWith("PNG")) {
        

            imagen = abrirArchivo(archivo);
            if(validarArchivo(archivo,imagen)==1){
                JLabel foto = new JLabel();
                foto.setSize(100, 100);

                ImageIcon ima = new ImageIcon(imagen);
                Image imagenEscalada = ima.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
                foto.setText(""+x);
                foto.setHorizontalTextPosition(SwingConstants.LEFT);
                foto.setIcon(new ImageIcon(imagenEscalada));

                fotos.add(foto);
                imagenes.add(imagen);
                vista.panelCentro.add(foto);
                vista.panelCentro.revalidate();
                vista.panelCentro.repaint();
                
                if(fotos.size()==6){
                    vista.seleccionar.setEnabled(false);
                }
                
            }else{
                System.out.println("error en la validacion de la imagen");
            }
            

        }
    }
    
    private void  eliminar(int num){
        System.out.println(fotos.size());
        vista.panelCentro.removeAll();
        fotos.remove(num-1);
        imagenes.remove(num-1);
        
        for(int i =0;i<fotos.size();i++){
            
            JLabel foto = fotos.get(i);
            foto.setText(""+(i+1));
            vista.panelCentro.add(foto);
        }
        vista.panelCentro.revalidate();
        vista.panelCentro.repaint();
        if(fotos.size()==6){
            vista.seleccionar.setEnabled(false);
        }

    }
    
    public List<JLabel> getFotos() {
        return fotos;
    }

    public List<byte[]> getImagenes() {
        return imagenes;
    }

}
