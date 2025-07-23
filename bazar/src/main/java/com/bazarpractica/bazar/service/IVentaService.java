package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.DTO.VentasDiaDTo;
import com.bazarpractica.bazar.DTO.VentasMayorDTO;
import com.bazarpractica.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public List<Venta> getVenta();

    public void saveVenta(Venta venta);

    public void deleteVenta(Long codigo_venta);

    public Venta findVenta(Long codigo_venta);

    public void updateVenta(Venta venta);

    public VentasDiaDTo getVentaDia(LocalDate fecha);

    public VentasMayorDTO getVentaConMayorMonto();

}
