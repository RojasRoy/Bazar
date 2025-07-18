package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Venta;
import com.bazarpractica.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public List<Venta> getVenta() {
        List<Venta> listVenta = ventaRepo.findAll();
        return listVenta;
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        Venta venta = ventaRepo.findById(codigo_venta).orElse(null);
        return venta;
    }

    @Override
    public void updateVenta(Venta venta) {
        this.saveVenta(venta);
    }
}
