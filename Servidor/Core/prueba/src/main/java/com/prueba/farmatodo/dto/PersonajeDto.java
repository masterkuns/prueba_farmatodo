package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonajeDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("species")
    private String species;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("image")
    private String image;

    @JsonProperty("location")
    private LocalizacionDto location;


    public PersonajeDto() {
    }

    public PersonajeDto(String name, String species, String gender, String image, LocalizacionDto location) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.image = image;
        this.location = location;
    }
}
