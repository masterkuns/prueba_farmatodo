package com.prueba.farmatodo.services;


import com.prueba.farmatodo.dto.*;


public interface INumerosService {

    public NFelicesDto consultarNumerosFelices(RpaListadoNumerosDto rpaListadoNumerosDto);

    public SumatoriaDto sumatoriaNumerosNaturales(RpaNumeroDto rpaNumeroDto);

}


