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

    @GetMapping("/productos/{codigoProducto}")
    public Producto findProducto(@PathVariable Long codigoProducto){
        return prodServi.findProducto(codigoProducto);
    }

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto){
        prodServi.saveProducto(producto);
        return "success create producto";
    }

    @DeleteMapping("/productos/eliminar/{codigoProducto}")
    public String eliminarProducto(@PathVariable Long codigoProducto){
        prodServi.deleteProducto(codigoProducto);
        return "success delete producto";
    }

    @PutMapping("/productos/editar/{codigoProducto}")
    public Producto editarProducto(@RequestBody Producto producto){
        prodServi.updateProducto(producto);
        return prodServi.findProducto(producto.getCodigoProducto());
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductosConFaltaStock() {
        return prodServi.getProdFaltaStock();
    }


}
