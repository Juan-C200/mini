/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JLabel;
import modelo.Habitacion;
import modelo.Oferta;
import modelo.PagoDao;
import modelo.Usuario;
import vista.PagoV;
import vista.TarjetaV;

/**
 *
 * @author estud
 */
public class PagoC implements ActionListener{
    public JLabel ldescuento, lvalorFinal, tvalorFinal, tdescuento, mensaje;
    public PagoV pV = new PagoV();
    public PagoDao dao = new PagoDao();
    private Usuario usuario = new Usuario();
    private Habitacion habitacion = new Habitacion();
    private Oferta of = new Oferta();
    private Date fechaI, fechaF;
    double monto, descuento, valorFinal;
    public PagoC(PagoV p, Usuario u, Habitacion h, String s, Date fecha_inicio, Date fecha_fin){
        this.usuario = u;
        this.habitacion = h;
        this.pV = p;
        this.fechaI = fecha_inicio;
        this.fechaF = fecha_fin;
        this.pV.cancelar.addActionListener(this);
        this.pV.continuar.addActionListener(this);
        this.pV.agregarTarjeta.addActionListener(this);
        this.pV.listaTarjetas.addActionListener(this);
         this.pV.setExtendedState(6);
        this.pV.setVisible(true);
        this.pV.setDefaultCloseOperation(3);
        
        this.pV.id_usu = usuario.getIdUsuario();
        
        of=dao.buscarOferta(habitacion.getIdHabitacion());
        descuento = of.getDescuento();
        monto = habitacion.getTarifa();
        
        pV.monto.setText(String.valueOf(monto));
        
         if (dao.buscarOferta(usuario.getIdUsuario())!=null){
             ldescuento = new JLabel("Descuento");
             lvalorFinal = new JLabel("ValorFinal");
            valorFinal = monto * (descuento/100);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        
        
        if (e.getSource()==pV.agregarTarjeta){
            TarjetaV tv = new TarjetaV();
            TarjetaC tc = new TarjetaC(tv, usuario, habitacion, fechaI, fechaF);
        }
    }
}
