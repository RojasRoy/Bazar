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

    @GetMapping("/clientes/{idCliente}")
    public Cliente findCliente(@PathVariable Long idCliente){
        return cliServi.findCliente(idCliente);
    }



    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        cliServi.saveCliente(cliente);
        return "success create cliente";
    }

    @DeleteMapping("/clientes/eliminar/{idCliente}")
    public String eliminarCliente(@PathVariable Long idCliente){
        cliServi.deleteCliente(idCliente);
        return "success delete cliente";
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editarCliente(@RequestBody Cliente cliente){
        cliServi.updateCliente(cliente);
        return cliServi.findCliente(cliente.getIdCliente());
    }





}
