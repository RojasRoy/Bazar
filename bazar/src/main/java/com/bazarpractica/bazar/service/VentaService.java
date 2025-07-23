package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.DTO.VentasDiaDTo;
import com.bazarpractica.bazar.DTO.VentasMayorDTO;
import com.bazarpractica.bazar.model.Venta;
import com.bazarpractica.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
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

    @Override
    public VentasDiaDTo getVentaDia(LocalDate fecha) {
        List<Venta> ventaDia = ventaRepo.findByFechaVenta(fecha);

        double total = 0;
        for(Venta venta : ventaDia ){
            total+= venta.getTotal();
        }

        return new VentasDiaDTo(total, ventaDia.size());
    }

    @Override
    public VentasMayorDTO getVentaConMayorMonto() {
        List<Venta> listaVentas = ventaRepo.findAll();

        if (listaVentas.isEmpty()) return null;

        Venta mayorVenta = Collections.max(listaVentas, Comparator.comparing(Venta::getTotal));

        VentasMayorDTO dto = new VentasMayorDTO();
        dto.setCodigo_venta(mayorVenta.getCodigo_venta());
        dto.setTotal(mayorVenta.getTotal());
        dto.setCantidadProductos(mayorVenta.getListaProductos().size());
        dto.setNombreCliente(mayorVenta.getUnCliente().getNombre());
        dto.setApellidoCliente(mayorVenta.getUnCliente().getApellido());

        return dto;
    }
}
