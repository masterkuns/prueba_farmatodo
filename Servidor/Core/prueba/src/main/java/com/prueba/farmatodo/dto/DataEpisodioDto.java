package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DataEpisodioDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("air_date")
    private String airDate;

    @JsonProperty("episode")
    private String episode;

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("url")
    private String url;


    @JsonProperty("created")
    private String created;


    public DataEpisodioDto() {}

    public DataEpisodioDto(int id, String name, String airDate, String episode, List<String> characters, String url, String created) {
        this.id = id;
        this.name = name;
        this.airDate = airDate;
        this.episode = episode;
        this.characters = characters;
        this.url = url;
        this.created = created;
    }
}




