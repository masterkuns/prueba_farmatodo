package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NFelicesDto {


    @JsonProperty("numbers")
    List<NumeroFelizDto> numbers;

    public NFelicesDto() {
    }

    public NFelicesDto(List<NumeroFelizDto> numbers) {
        this.numbers = numbers;
    }
}
