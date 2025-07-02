package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVenta();

    public void saveVenta(Venta venta);

    public void deleteVenta(Long codigo_venta);

    public Venta findVenta(Long codigo_venta);

    public void updateVenta(Venta venta);

}
