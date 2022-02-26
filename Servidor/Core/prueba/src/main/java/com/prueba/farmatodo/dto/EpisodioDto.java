package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EpisodioDto {

    @JsonProperty("episode")
    private int episode;

    @JsonProperty("episodeName")
    private String episodeName;

    @JsonProperty("characters")
    private String characters;
}
