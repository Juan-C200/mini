/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class Habitacion {
    public int idHabitacion;
    public String nombreHabitacion;
    public String estado;
    public double tarifa;
    public String descripcionBreve;
    public String descripcionDetallada;
    public TipoHabitacion tipoHabitacion;
    public Hotel hotel;
    public List<byte[]> imagenes;
    public List<JLabel> fotos;

    public Habitacion(int idHabitacion,String nombreHabitacion, String estado, double tarifa, String descripcionBreve, String descripcionDetallada, TipoHabitacion tipoHabitacion, Hotel hotel) {
        this.idHabitacion = idHabitacion;
        this.nombreHabitacion=nombreHabitacion;
        this.estado = estado;
        this.tarifa = tarifa;
        this.descripcionBreve = descripcionBreve;
        this.descripcionDetallada = descripcionDetallada;
        this.tipoHabitacion = tipoHabitacion;
        this.hotel = hotel;
        
    }
    
    public Habitacion(){
        
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    public void setDescripcionDetallada(String descripcionDetallada) {
        this.descripcionDetallada = descripcionDetallada;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<byte[]> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<byte[]> imagenes) {
        this.imagenes = imagenes;
    }

    public List<JLabel> getFotos() {
        return fotos;
    }

    public void setFotos(List<JLabel> fotos) {
        this.fotos = fotos;
    }
        
    
    
}
