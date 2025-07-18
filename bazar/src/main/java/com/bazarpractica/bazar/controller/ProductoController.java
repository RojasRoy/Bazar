package com.bazarpractica.bazar.controller;

import com.bazarpractica.bazar.model.Producto;
import com.bazarpractica.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService prodServi;

    @GetMapping("/productos")
    public List<Producto> getProducto(){
        return prodServi.getProducto();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return prodServi.findProducto(codigo_producto);
    }

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto){
        prodServi.saveProducto(producto);
        return "success create producto";
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String eliminarProducto(@PathVariable Long codigo_producto){
        prodServi.deleteProducto(codigo_producto);
        return "success delete producto";
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editarProducto(@RequestBody Producto producto){
        prodServi.updateProducto(producto);
        return prodServi.findProducto(producto.getCodigo_producto());
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductosConFaltaStock() {
        return prodServi.getProdFaltaStock();
    }


}
