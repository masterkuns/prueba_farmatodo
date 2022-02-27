package com.prueba.farmatodo.services.impl;

import com.prueba.farmatodo.dto.*;
import com.prueba.farmatodo.services.INumerosService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Log4j2
public class NumerosServiceImpl implements INumerosService {




    @SuppressWarnings("static-access")
    @Autowired
    public NumerosServiceImpl() {

    }


    @Override
    public NFelicesDto consultarNumerosFelices(RpaListadoNumerosDto rpaListadoNumerosDto) {
        return null;
    }

    @Override
    public SumatoriaDto sumatoriaNumerosNaturales(RpaNumeroDto rpaNumeroDto) {
        return null;
    }
}


