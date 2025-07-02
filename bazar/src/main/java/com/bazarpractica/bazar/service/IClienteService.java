package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getCliente();

    public void saveCliente(Cliente cliente);

    public void deleteCliente(Long id);

    public Cliente findCliente(Long id);

    public void updateCliente(Cliente cliente);
}
