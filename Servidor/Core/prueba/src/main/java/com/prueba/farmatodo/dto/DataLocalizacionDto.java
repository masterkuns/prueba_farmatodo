package com.prueba.farmatodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;


@Data
public class DataLocalizacionDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("dimension")
    private String dimension;

    @JsonProperty("residents")
    private List<String> residents;

    @JsonProperty("url")
    private String url;

    @JsonProperty("created")
    private String created;


    public DataLocalizacionDto() {
    }

    public DataLocalizacionDto(Integer id, String name, String type, String dimension, List<String> residents, String url, String created) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dimension = dimension;
        this.residents = residents;
        this.url = url;
        this.created = created;
    }
}
