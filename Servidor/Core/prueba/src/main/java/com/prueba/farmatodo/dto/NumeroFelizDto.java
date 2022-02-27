package com.prueba.farmatodo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NumeroFelizDto {

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("isHappy")
    private Boolean isHappy;

    public NumeroFelizDto() {
    }

    public NumeroFelizDto(Integer number, Boolean isHappy) {
        this.number = number;
        this.isHappy = isHappy;
    }
}
