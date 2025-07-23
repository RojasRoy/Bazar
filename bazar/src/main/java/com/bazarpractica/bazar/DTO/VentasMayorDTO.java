package com.bazarpractica.bazar.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentasMayorDTO {

    private Long codigo_venta;
    private double total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentasMayorDTO(){}

    public VentasMayorDTO(Long codigo_venta, double total, int cantidadProductos, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
}
