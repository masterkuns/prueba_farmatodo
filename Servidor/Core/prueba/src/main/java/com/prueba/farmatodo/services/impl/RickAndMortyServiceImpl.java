package com.prueba.farmatodo.services.impl;

import com.prueba.farmatodo.dto.*;
import com.prueba.farmatodo.repository.ICapitulosRepository;
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

import java.util.List;

@Service
@Log4j2
public class RickAndMortyServiceImpl implements IRickAndMortyService {
    private static RestTemplate restTemplate;
    private static RestTemplate restTemplateDataEpisodio;
    private static HttpHeaders headers = new HttpHeaders();
    private ICapitulosRepository iCapitulosRepository;


    private String nombreEpisodio = "";
    private Boolean capituloExiste;
    private Integer episodio;


    private List<PersonajeDto> personajes;
    private LocalizacionDto localizacion;



    @SuppressWarnings("static-access")
    @Autowired
    public RickAndMortyServiceImpl(RestTemplate restTemplate, RestTemplateBuilder restTemplateBuilder, List<PersonajeDto> personajes, LocalizacionDto localizacion, ICapitulosRepository iCapitulosRepository) {
        this.restTemplate = restTemplate;
        this.restTemplateDataEpisodio = restTemplateBuilder.build();
        this.personajes = personajes;
        this.localizacion = localizacion;
        this.iCapitulosRepository = iCapitulosRepository;
    }


    @Override
    public EpisodioDto ConsultarEpisodio(RpaEpisodioDto rpaEpisodioDto) {
        personajes.clear();
        log.info("Entro-RickAndMortyServiceImpl-ConsultarEpisodio: episodio: {}", rpaEpisodioDto.getNmroEpisodio());
        EpisodioDto episodioDto = new EpisodioDto();
        Integer idEpisodio = rpaEpisodioDto.getNmroEpisodio();
        episodio = idEpisodio;
        try {

            ConsultarInformacionEpisodio(idEpisodio);
            episodioDto.setEpisode(rpaEpisodioDto.getNmroEpisodio());
            episodioDto.setEpisodeName(nombreEpisodio);
            episodioDto.setCharacters(personajes);

        } catch (Exception e) {
            log.error("Error-RickAndMortyServiceImpl-consultarEpisodio: {}", e.getMessage());

        }

        return episodioDto;
    }

    public DataEpisodioDto ConsultarInformacionEpisodio(Integer idEpisodio) {
        DataEpisodioDto dataEpisodioDto = new DataEpisodioDto();
        capituloExiste = true;
        try {
            String url = Constantes.UrlInformacionEpisodio +idEpisodio;

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            HttpEntity<Object> entityWs = new HttpEntity<Object>(headers);

            ResponseEntity<DataEpisodioDto> dataEpisodio = restTemplateDataEpisodio.exchange(builder.toUriString(), HttpMethod.GET, entityWs, DataEpisodioDto.class);

            if (dataEpisodio.getBody() != null) {
                dataEpisodioDto = dataEpisodio.getBody();
                nombreEpisodio = dataEpisodioDto.getName();

                Integer validarCapitulo = iCapitulosRepository.consultarCapituloExistente(idEpisodio);
                if (validarCapitulo == 0) {
                    capituloExiste = false;
                    iCapitulosRepository.insertarCapitulo(idEpisodio, nombreEpisodio);
                }else{
                    log.info("El episodio: {} ya se encuentra registrado",idEpisodio);
                }

                dataEpisodioDto.getCharacters().forEach(character -> {
                            Integer id = Integer.parseInt(character.split("/")[character.split("/").length - 1]);
                            ConsultarInformacionPersonaje(id);
                        });
            }
        } catch (Exception e) {
            log.error("Error-RickAndMortyServiceImpl-consultarEpisodio: {}", e.getMessage());
        }

        return dataEpisodioDto;
    }


    public DataPersonajeDto ConsultarInformacionPersonaje(Integer idPersonaje) {
        DataPersonajeDto dataPersonajeDto = new DataPersonajeDto();

        try {
            String url = Constantes.UrlInformacionPersonaje +idPersonaje;

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            HttpEntity<Object> entityWs = new HttpEntity<Object>(headers);

            ResponseEntity<DataPersonajeDto> datapersonaje = restTemplateDataEpisodio.exchange(builder.toUriString(), HttpMethod.GET, entityWs, DataPersonajeDto.class);

            if (datapersonaje.getBody() != null) {
                dataPersonajeDto = datapersonaje.getBody();

                if (!capituloExiste) {
                    iCapitulosRepository.insertarPersonaje(
                            episodio,
                            dataPersonajeDto.getName(),
                            dataPersonajeDto.getSpecies(),
                            dataPersonajeDto.getGender(),
                            dataPersonajeDto.getImage());
                }

                Integer id = Integer.parseInt(dataPersonajeDto.getLocation().getUrl().split("/")[dataPersonajeDto.getLocation().getUrl().split("/").length - 1]);
                ConsultarInformacionLocalizacion(id);

                PersonajeDto personajeDto = new PersonajeDto();
                personajeDto.setName(dataPersonajeDto.getName());
                personajeDto.setSpecies(dataPersonajeDto.getSpecies());
                personajeDto.setGender(dataPersonajeDto.getGender());
                personajeDto.setImage(dataPersonajeDto.getImage());
                personajeDto.setLocation(localizacion);
                personajes.add(personajeDto);

            }
        } catch (Exception e) {
            log.error("Error-RickAndMortyServiceImpl-ConsultarInformacionPersonaje: {}", e.getMessage());
        }

        return dataPersonajeDto;
    }

    public DataLocalizacionDto ConsultarInformacionLocalizacion(Integer idLocalizacion) {
        DataLocalizacionDto dataLocalizacionDto = new DataLocalizacionDto();
        localizacion = new LocalizacionDto();

        try {
            String url = Constantes.UrlInformacionLocalizacion +idLocalizacion;

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            HttpEntity<Object> entityWs = new HttpEntity<Object>(headers);

            ResponseEntity<DataLocalizacionDto> dataLocalizacion = restTemplateDataEpisodio.exchange(builder.toUriString(), HttpMethod.GET, entityWs, DataLocalizacionDto.class);

            if (dataLocalizacion.getBody() != null) {
                dataLocalizacionDto = dataLocalizacion.getBody();

                if (!capituloExiste) {
                    iCapitulosRepository.insertarLugar(
                            episodio,
                            dataLocalizacionDto.getName(),
                            dataLocalizacionDto.getType(),
                            dataLocalizacionDto.getDimension());
                }

                LocalizacionDto localizacionDto = new LocalizacionDto();
                localizacionDto.setName(dataLocalizacionDto.getName());
                localizacionDto.setType(dataLocalizacionDto.getType());
                localizacionDto.setDimension(dataLocalizacionDto.getDimension());
                localizacion = localizacionDto;

            }
        } catch (Exception e) {
            log.error("Error-RickAndMortyServiceImpl-ConsultarInformacionLocalizacion: {}", e.getMessage());
        }

        return dataLocalizacionDto;
    }
}


