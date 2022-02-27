package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocalizacionDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("dimension")
    private String dimension;

    public LocalizacionDto() {
    }

    public LocalizacionDto(String name, String type, String dimension) {
        this.name = name;
        this.type = type;
        this.dimension = dimension;
    }
}
