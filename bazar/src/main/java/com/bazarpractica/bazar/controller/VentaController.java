package com.bazarpractica.bazar.controller;

import com.bazarpractica.bazar.DTO.VentasDiaDTo;
import com.bazarpractica.bazar.DTO.VentasMayorDTO;
import com.bazarpractica.bazar.model.Venta;
import com.bazarpractica.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaServi;

    @GetMapping("/ventas")
    public List<Venta> getVenta(){
        return ventaServi.getVenta();
    }

    @GetMapping("/ventas/{codigoVenta}")
    public Venta findVenta(@PathVariable Long codigoVenta){
        return ventaServi.findVenta(codigoVenta);
    }

    @GetMapping("/ventas/fecha/{fechaVenta}")
    public VentasDiaDTo getVentasDia(@PathVariable ("fechaVenta") String fecha_venta){
        LocalDate fecha = LocalDate.parse(fecha_venta);
        return ventaServi.getVentaDia(fecha);
    }

    @GetMapping("/ventas/mayor_venta")
    public VentasMayorDTO getVentaMayor() {
        return ventaServi.getVentaConMayorMonto();
    }

    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta){
        ventaServi.saveVenta(venta);
        return "success create venta";
    }

    @DeleteMapping("/ventas/eliminar/{codigoVenta}")
    public String eliminarVenta(@PathVariable Long codigoVenta){
        ventaServi.deleteVenta(codigoVenta);
        return "success delete venta";
    }

    @PutMapping("/ventas/editar/{codigoVenta}")
    public Venta editarVenta(@RequestBody Venta venta){
        ventaServi.updateVenta(venta);
        return ventaServi.findVenta(venta.getCodigoVenta());
    }

}
