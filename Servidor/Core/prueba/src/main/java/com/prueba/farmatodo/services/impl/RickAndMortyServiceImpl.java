package com.prueba.farmatodo.services.impl;

import com.prueba.farmatodo.dto.DataEpisodioDto;
import com.prueba.farmatodo.dto.PersonajeDto;
import com.prueba.farmatodo.dto.RpaEpisodioDto;
import com.prueba.farmatodo.services.IRickAndMortyService;
import com.prueba.farmatodo.utils.Constantes;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Log4j2
public class RickAndMortyServiceImpl implements IRickAndMortyService {
    private static RestTemplate restTemplate;
    private static RestTemplate restTemplateDataEpisodio;
    private static RestTemplate restTemplateDataPersonaje;
    private static RestTemplate restTemplateDataLocalizacion;
    private static HttpHeaders headers = new HttpHeaders();


    @SuppressWarnings("static-access")
    @Autowired
    public RickAndMortyServiceImpl(RestTemplate restTemplate, RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplate;
        this.restTemplateDataEpisodio = restTemplateBuilder.build();
        this.restTemplateDataPersonaje = restTemplateBuilder.build();
        this.restTemplateDataLocalizacion = restTemplateBuilder.build();
    }

    @Override
    public DataEpisodioDto ConsultarInformacionEpisodio(RpaEpisodioDto rpaEpisodioDto) {
        log.info("Entro-RickAndMortyServiceImpl-consultarEpisodio: episodio: {}", rpaEpisodioDto.getNmroEpisodio());
        DataEpisodioDto dataEpisodioDto = new DataEpisodioDto();

        try {
            String url = Constantes.UrlInformacionEpisodio +rpaEpisodioDto.getNmroEpisodio();

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            HttpEntity<Object> entityWs = new HttpEntity<Object>(headers);

            ResponseEntity<DataEpisodioDto> dataEpisodio = restTemplateDataEpisodio.exchange(builder.toUriString(), HttpMethod.GET, entityWs, DataEpisodioDto.class);

            log.info("Direccion de la peticion realizada para el episodio [{}]: {}", rpaEpisodioDto.getNmroEpisodio(), builder.toUriString());
            log.info("data Episodio {}", dataEpisodio.getBody());

            if (dataEpisodio.getBody() != null) {
                dataEpisodioDto = dataEpisodio.getBody();

                dataEpisodioDto.getCharacters().forEach(character -> {
                            log.info("character: {}", character);
                            Integer id = Integer.parseInt(character.split("/")[character.split("/").length - 1]);
                            log.info("IdPersonaje: {}", id);
                        });

                //capturar cada episodioDto.
            }
        } catch (Exception e) {
            log.error("Error-RickAndMortyServiceImpl-consultarEpisodio: {}", e.getMessage());
        }

        return dataEpisodioDto;
    }


    public PersonajeDto ConsultarInformacionPersonaje(Integer idPersonaje) {
        log.info("Entro-RickAndMortyServiceImpl-ConsultarInformacionPersonaje: IdPersonaje: {}",idPersonaje);
        PersonajeDto personajeDto = new PersonajeDto();

        try {
            String url = Constantes.UrlInformacionEpisodio +idPersonaje;

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            HttpEntity<Object> entityWs = new HttpEntity<Object>(headers);

            ResponseEntity<PersonajeDto> datapersonaje = restTemplateDataPersonaje.exchange(builder.toUriString(), HttpMethod.GET, entityWs, PersonajeDto.class);

            log.info("Direccion de la peticion realizada para el IdPersonaje [{}]: {}", idPersonaje, builder.toUriString());
            log.info("data Personaje {}", datapersonaje.getBody());

            if (datapersonaje.getBody() != null) {
                personajeDto = datapersonaje.getBody();
            }
        } catch (Exception e) {
            log.error("Error-RickAndMortyServiceImpl-consultarEpisodio: {}", e.getMessage());
        }

        return personajeDto;
    }




}
