package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SumatoriaDto {

    @JsonProperty("result")
    private Integer result;

    public SumatoriaDto() {
    }

    public SumatoriaDto(Integer result) {
        this.result = result;
    }
}
