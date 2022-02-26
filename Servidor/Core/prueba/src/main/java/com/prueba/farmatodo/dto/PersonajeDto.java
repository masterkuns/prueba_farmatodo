package com.prueba.farmatodo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PersonajeDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;


    @JsonProperty("species")
    private String species;

    @JsonProperty("type")
    private String type;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("origin")
    private PersonajeOriginDto origin;

    @JsonProperty("location")
    private PersonajeLocationDto location;

    @JsonProperty("image")
    private String image;

    @JsonProperty("episode")
    private List<String> episode;

    @JsonProperty("url")
    private String url;

    @JsonProperty("created")
    private String created;


    public PersonajeDto() {
    }

    public PersonajeDto(int id, String name, String status, String species, String type, String gender, PersonajeOriginDto origin, PersonajeLocationDto location, String image, List<String> episode, String url, String created) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.image = image;
        this.episode = episode;
        this.url = url;
        this.created = created;
    }
}
