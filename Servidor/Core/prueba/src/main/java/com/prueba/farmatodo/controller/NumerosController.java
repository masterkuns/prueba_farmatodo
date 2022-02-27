package com.prueba.farmatodo.controller;


import com.prueba.farmatodo.dto.*;
import com.prueba.farmatodo.services.INumerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NumerosController {
    private INumerosService iNumerosService;

    @Autowired
    public NumerosController(INumerosService iNumerosService) {
        this.iNumerosService = iNumerosService;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/consultar/numeros/felices")
    public NFelicesDto consultarNumerosFelices(@RequestBody RpaListadoNumerosDto rpaListadoNumerosDto) {
        return this.iNumerosService.consultarNumerosFelices(rpaListadoNumerosDto);
    }


    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/sumatoria/numeros/naturales")
    public SumatoriaDto sumatoriaNumerosNaturales(@RequestBody RpaNumeroDto rpaNumeroDto) {
        return this.iNumerosService.sumatoriaNumerosNaturales(rpaNumeroDto);
    }


}