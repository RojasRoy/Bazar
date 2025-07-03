package com.bazarpractica.bazar.controller;

import com.bazarpractica.bazar.model.Cliente;
import com.bazarpractica.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService cliServi;

    @GetMapping("/clientes")
    public List<Cliente> getCliente(){
        return cliServi.getCliente();
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return cliServi.findCliente(id_cliente);
    }

    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        cliServi.saveCliente(cliente);
        return "success create cliente";
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String eliminarCliente(@PathVariable Long id_cliente){
        cliServi.deleteCliente(id_cliente);
        return "success delete cliente";
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editarCliente(@RequestBody Cliente cliente){
        cliServi.updateCliente(cliente);
        return cliServi.findCliente(cliente.getId_cliente());
    }





}
