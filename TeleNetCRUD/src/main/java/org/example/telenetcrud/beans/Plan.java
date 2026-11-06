package org.example.telenetcrud.beans;

import java.math.BigDecimal;

public class Plan {
    public String getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(String idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVelocidadMbps() {
        return velocidadMbps;
    }

    public void setVelocidadMbps(double velocidadMbps) {
        this.velocidadMbps = velocidadMbps;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private String idPlan;
    private String nombre;
    private double velocidadMbps;
    private BigDecimal precio;
    private String estado;

}
