package com.bazarpractica.bazar.controller;

import com.bazarpractica.bazar.model.Venta;
import com.bazarpractica.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaServi;

    @GetMapping("/ventas")
    public List<Venta> getVenta(){
        return ventaServi.getVenta();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return ventaServi.findVenta(codigo_venta);
    }

    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta){
        ventaServi.saveVenta(venta);
        return "success create venta";
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta){
        ventaServi.deleteVenta(codigo_venta);
        return "success delete venta";
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editarVenta(@RequestBody Venta venta){
        ventaServi.updateVenta(venta);
        return ventaServi.findVenta(venta.getCodigo_venta());
    }

}
