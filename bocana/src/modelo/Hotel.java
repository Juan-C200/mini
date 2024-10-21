/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Hotel {
    
    public int idHotel;
    public int nit;
    public String nombreHotel;
    public String direccion;
    public int numeroHabitaciones;
    public Usuario usuario;
    public List<TipoServicio> servicios;
    public List<Habitacion> habitaciones;

    public Hotel(int idHotel, int nit, String nombreHotel, String direccion, int numeroHabitaciones, List<TipoServicio> servicios, Usuario usuario, List<Habitacion> habitaciones) {
        this.idHotel = idHotel;
        this.nit = nit;
        this.nombreHotel = nombreHotel;
        this.direccion = direccion;
        this.numeroHabitaciones = numeroHabitaciones;
        this.servicios = servicios;
        this.habitaciones=habitaciones;

        this.usuario=usuario;
    }
    public Hotel(){
        
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }


    public List<TipoServicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<TipoServicio> servicios) {
        this.servicios = servicios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
