/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Habitacion;
import modelo.Oferta;
import modelo.Pago;
import modelo.PagoDao;
import modelo.Usuario;
import vista.AlojamientosV;
import vista.PagoV;
import vista.ReservaV;
import vista.TarjetaV;

/**
 *
 * @author estud
 */
public class PagoC implements ActionListener{
    public JLabel ldescuento, lvalorFinal, tvalorFinal, tdescuento;
    public GridLayout migrid;
    public PagoV pV = new PagoV();
    public Pago p = new Pago();
    public PagoDao dao = new PagoDao();
    private Usuario usuario = new Usuario();
    private Habitacion habitacion = new Habitacion();
    private Oferta of = new Oferta();
    public ArrayList <String> lisTarjetas;
    public String tarjetas[], metodo;

    String temp;
    private Date fechaI, fechaF, fechaiO, fechafO, fecha = new Date();
    int id =dao.ultimoId()+1, id_usu;
    double monto, descuento, valorFinal;
    public PagoC(PagoV p, Usuario u, Habitacion h, String s, Date fecha_inicio, Date fecha_fin){
        this.usuario = u;
        this.metodo = s;
        this.habitacion = h;
        this.pV = p;
        this.fechaI = fecha_inicio;
        this.fechaF = fecha_fin;
        this.pV.cancelar.addActionListener(this);
        this.pV.continuar.addActionListener(this);
        this.pV.agregarTarjeta.addActionListener(this);

         this.pV.setExtendedState(6);
        this.pV.setVisible(true);
        this.pV.setDefaultCloseOperation(3);
        
        this.id_usu= usuario.getIdUsuario();
        
        of=dao.buscarOferta(habitacion.getIdHabitacion());
        descuento = of.getDescuento();
        
        monto = habitacion.getTarifa();
        
        valorFinal = monto;
        pV.fecha.setText(""+fecha);
        pV.monto.setText(""+monto);
        fechaiO = of.getFechaInicio();
        fechafO = of.getFechaFin();
        tdescuento = new JLabel();
        tvalorFinal =new JLabel();
         id_usu = usuario.getIdUsuario();
         
         lisTarjetas = dao.buscarTarjeta(id_usu);
        
        tarjetas = new String[dao.buscarTarjeta(id_usu).size()+1];
        
        
        for(int x=0;x<dao.buscarTarjeta(id_usu).size();x++){
            if (x==0){
                temp="";
            }
            temp = lisTarjetas.get(x);
            System.out.print(temp);
            tarjetas[x] = temp;
        }
        this.pV.listaTarjetas = new JComboBox(tarjetas);
        this.pV.panelCentro.add( this.pV.listaTarjetas);
        
        this.pV.listaTarjetas.setSelectedItem(tarjetas.length-1);
         if (dao.buscarOferta(usuario.getIdUsuario())!=null){
             if(fecha_inicio.after(fechaiO) && fecha_fin.before(fechafO)){
                 this.valorFinal = monto - (monto * (descuento/100));
                  this.ldescuento = new JLabel("Descuento:");
             this.lvalorFinal = new JLabel("Valor final a pagar:");
             this.migrid=new GridLayout(6,2,3,3);
             this.tdescuento.setText(descuento+"%");
             this.tvalorFinal.setText(""+valorFinal);
                        
             this.pV.panelCentro.setLayout(migrid);
             
             this.pV.panelCentro.add(ldescuento);
             this.pV.panelCentro.add(tdescuento);
             this.pV.panelCentro.add(lvalorFinal);
             this.pV.panelCentro.add(tvalorFinal);
             
  
             }
            
             
            
        }
        
        if(s.equals("Efectivo")){    
            this.pV.listaTarjetas.setEnabled(false);   
        }
        
                this.pV.listaTarjetas.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==pV.continuar){
            setAdd();
            JOptionPane.showMessageDialog(pV, "Si deseas ver los datos de esta reserva, ingresa a tu perfil en la opcion de <Ver reservas>");
            AlojamientosV alo = new AlojamientosV();
            AlojamientosC aloc = new AlojamientosC(alo, usuario);
            pV.setVisible(false);
        }
        
        if(e.getSource()==pV.cancelar){
            ReservaV rv = new ReservaV();
            ReservaC rc = new ReservaC(rv, usuario, habitacion);
            pV.setVisible(false);
            
        }
        
        
        if (e.getSource()==pV.agregarTarjeta){
            TarjetaV tv = new TarjetaV();
            TarjetaC tc = new TarjetaC(tv, usuario, habitacion, fechaI, fechaF);
            pV.setVisible(false);
        }
    }
    
    public void setAdd(){
        
        
        int r = 1, resultado = 0;
        int idPago = id;
        double desc = descuento;
        double mon = monto;
        double valorF = valorFinal;
        Date fe = fecha;
        int id_usu = usuario.getIdUsuario();
        
        p.setIdPago(idPago);
        p.setDescuento(desc);
        p.setMonto(mon);
        p.setMetodo(metodo);
        p.setValorFinal(valorF);
        p.setFecha(fe);
        p.setId_usuario(id_usu);
        
        resultado = dao.setAgregar(p);
        
         if (resultado == 1) {
            JOptionPane.showMessageDialog(pV, "Tarjeta guardada");
        } else {
            JOptionPane.showMessageDialog(pV, "Error de insercion" + JOptionPane.ERROR_MESSAGE);
        }
    }
}
