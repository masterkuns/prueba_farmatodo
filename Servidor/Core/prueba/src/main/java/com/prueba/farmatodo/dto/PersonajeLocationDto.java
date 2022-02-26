package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonajeLocationDto {


    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    public PersonajeLocationDto() {
    }

    public PersonajeLocationDto(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
