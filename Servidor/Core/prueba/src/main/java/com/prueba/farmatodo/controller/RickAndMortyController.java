package com.prueba.farmatodo.controller;


import com.prueba.farmatodo.dto.*;
import com.prueba.farmatodo.services.IRickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RickAndMortyController {
    private IRickAndMortyService iRickAndMortyService;

    @Autowired
    public RickAndMortyController(IRickAndMortyService iRickAndMortyService) {
        this.iRickAndMortyService = iRickAndMortyService;
    }


    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @PostMapping(value = "/consultar/episodio")
    public EpisodioDto consultarEpisodio(@RequestBody RpaEpisodioDto rpaEpisodioDto) {
        return this.iRickAndMortyService.ConsultarEpisodio(rpaEpisodioDto);
    }

}
