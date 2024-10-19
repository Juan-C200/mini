/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author estud
 */
public class Tarjeta {
    String numTarjeta;
    String cvv;
    String nombrePropietario;
    String apellidoPropietario;
    String fechaVencimiento;
    String tipoTarjeta;
    String banco;
    String tipoDebito;
    int idUsuario;


    public Tarjeta(String numTarjeta, String cvv, String nombrePropietario, String apellidoPropietario, String fechaVencimiento, String tipoTarjeta, String banco, String tipoDebito, int idUsuario) {
        this.numTarjeta = numTarjeta;
        this.cvv = cvv;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoTarjeta = tipoTarjeta;
        this.banco = banco;
        this.tipoDebito = tipoDebito;
        this.idUsuario = idUsuario;
    }

    public Tarjeta() {
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    
    

   

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getApellidoPropietario() {
        return apellidoPropietario;
    }

    public void setApellidoPropietario(String apellidoPropietario) {
        this.apellidoPropietario = apellidoPropietario;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipoDebito() {
        return tipoDebito;
    }

    public void setTipoDebito(String tipoDebito) {
        this.tipoDebito = tipoDebito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
    
}
