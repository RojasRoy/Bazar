package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProducto();

    public void saveProducto(Producto producto);

    public void deleteProducto(Long codigo_producto);

    public Producto findProducto(Long codigo_producto);

    public void updateProducto(Producto producto);
}
