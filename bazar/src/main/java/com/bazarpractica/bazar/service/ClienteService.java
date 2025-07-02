package com.bazarpractica.bazar.service;

import com.bazarpractica.bazar.model.Cliente;
import com.bazarpractica.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository cliRepo;

    @Override
    public List<Cliente> getCliente() {
        List<Cliente> listCliente = cliRepo.findAll();
        return listCliente;
    }

    @Override
    public void saveCliente(Cliente cliente) {
        cliRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        cliRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente cliente = cliRepo.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public void updateCliente(Cliente cliente) {
        this.saveCliente(cliente);
    }
}
