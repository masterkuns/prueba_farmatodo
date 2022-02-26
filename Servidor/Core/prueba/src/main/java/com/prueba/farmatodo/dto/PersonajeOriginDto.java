package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class PersonajeOriginDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;


    public PersonajeOriginDto() {
    }

    public PersonajeOriginDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

}
