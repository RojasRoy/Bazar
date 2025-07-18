package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Producto;
import com.bazarpractica.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository prodRepo;

    @Override
    public List<Producto> getProducto() {
        List<Producto> listProducto = prodRepo.findAll();
        return listProducto;
    }

    @Override
    public void saveProducto(Producto producto) {
        prodRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        prodRepo.deleteById(codigo_producto);
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        Producto producto = prodRepo.findById(codigo_producto).orElse(null);
        return producto;
    }

    @Override
    public void updateProducto(Producto producto) {
        this.saveProducto(producto);
    }

    @Override
    public List<Producto> getProdFaltaStock() {
        return prodRepo.findByCantidadDisponibleLessThan(5);
    }
}
