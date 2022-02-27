package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RpaListadoNumerosDto {

    @JsonProperty("numeros")
    private List<Integer> numeros;


    public RpaListadoNumerosDto() {}

    public RpaListadoNumerosDto(List<Integer> numeros) {
        this.numeros = numeros;
    }
}
