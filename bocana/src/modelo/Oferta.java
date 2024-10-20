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
public class Oferta {
    public int idOfertaEspecial;
    public int descuento;
    public Date fechaInicio;
    public Date fechaFin;

    public Oferta(int idOfertaEspecial, int descuento, Date fechaInicio, Date fechaFin) {
        this.idOfertaEspecial = idOfertaEspecial;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public Oferta(){
        
    }

    public int getIdOfertaEspecial() {
        return idOfertaEspecial;
    }

    public void setIdOfertaEspecial(int idOfertaEspecial) {
        this.idOfertaEspecial = idOfertaEspecial;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
