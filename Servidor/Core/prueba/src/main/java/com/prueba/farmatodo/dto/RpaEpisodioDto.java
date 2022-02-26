package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RpaEpisodioDto {

    @JsonProperty("nmro_episodio")
    private int nmroEpisodio;


    public RpaEpisodioDto() {}

    public RpaEpisodioDto(int nmroEpisodio) {
        this.nmroEpisodio = nmroEpisodio;
    }
}
