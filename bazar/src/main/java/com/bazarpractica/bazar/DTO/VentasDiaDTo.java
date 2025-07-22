package com.bazarpractica.bazar.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentasDiaDTo {
    private double totalFacturado;
    private int cantidadVentas;

    public VentasDiaDTo(){}

    public VentasDiaDTo(double totalFacturado, int cantidadVentas){
        this.totalFacturado = totalFacturado;
        this.cantidadVentas = cantidadVentas;
    }
}
