package com.prueba.farmatodo.services;

import com.prueba.farmatodo.dto.DataEpisodioDto;
import com.prueba.farmatodo.dto.RpaEpisodioDto;

public interface IRickAndMortyService {

    public DataEpisodioDto ConsultarInformacionEpisodio(RpaEpisodioDto rpaEpisodioDto);
}
