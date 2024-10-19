/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author estud
 */
public class Pago {
    double monto;
    LocalDateTime fecha;
    int id_usuario;
    int id_habitacion;

    public Pago(double monto, LocalDateTime fecha, int id_usuario, int id_habitacion) {
        this.monto = monto;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
        this.id_habitacion = id_habitacion;
    }

    public Pago() {
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_hotel(int id_hotel) {
        this.id_habitacion = id_habitacion;
    }
    
    
}
