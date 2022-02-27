package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RpaNumeroDto {

    @JsonProperty("numero")
    private Integer numero;


    public RpaNumeroDto() {}

    public RpaNumeroDto(Integer numero) {
        this.numero = numero;
    }
}
