/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class TipoHabitacion {
    public int idTipoHabitacion;
    public String descripcion;

    public TipoHabitacion(int idTipoHabitacion, String descripcion) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.descripcion = descripcion;
    }
    public TipoHabitacion(){
        
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
