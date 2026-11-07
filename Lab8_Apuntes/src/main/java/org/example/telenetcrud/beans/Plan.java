package org.example.telenetcrud.beans;

import java.math.BigDecimal;

public class Plan {
    private int idPlan;
    private String nombre;
    private int velocidadMbps;
    private BigDecimal precio;
    private String estado;

    public int getIdPlan() { return idPlan; }
    public void setIdPlan(int idPlan) { this.idPlan = idPlan; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getVelocidadMbps() { return velocidadMbps; }
    public void setVelocidadMbps(int velocidadMbps) { this.velocidadMbps = velocidadMbps; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
