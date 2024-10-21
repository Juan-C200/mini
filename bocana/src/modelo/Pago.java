/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.util.Date;

/**
 *
 * @author estud
 */
public class Pago {
    public int idPago;
    public double descuento;
    public double monto;
    public String metodo;
    public double valorFinal;
    public Date fecha;
    public int id_usuario;

    public Pago(int idPago, double descuento, double monto, String metodo, double valorFinal,Date fecha, int id_usuario) {
        this.idPago = idPago;
        this.descuento = descuento;
        this.monto = monto;
        this.metodo = metodo;
        this.valorFinal = valorFinal;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
    }
  
    public Pago() {
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    
    
    
}
