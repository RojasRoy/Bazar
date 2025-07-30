package com.bazarpractica.bazar.DTO;


public class VentasDiaDTo {
    private double totalFacturado;
    private int cantidadVentas;

    public VentasDiaDTo(){}

    public VentasDiaDTo(double totalFacturado, int cantidadVentas){
        this.totalFacturado = totalFacturado;
        this.cantidadVentas = cantidadVentas;
    }

    public double getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(double totalFacturado) {
        this.totalFacturado = totalFacturado;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }
}
