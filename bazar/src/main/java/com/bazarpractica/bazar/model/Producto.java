package com.bazarpractica.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double costo;
    
    @Column(name = "cantidad_disponible")
    private double cantidadDisponible;

    public Producto(){}

    public Producto(Long codigo_producto, String nombre, String marca, double costo, double cantidadDisponible){
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
    }

}
