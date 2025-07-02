package com.bazarpractica.bazar.controller;

import com.bazarpractica.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaServi;

}
