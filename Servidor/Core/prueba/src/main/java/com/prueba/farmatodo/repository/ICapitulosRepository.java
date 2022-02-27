package com.prueba.farmatodo.repository;


import com.prueba.farmatodo.entity.CapitulosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICapitulosRepository extends JpaRepository<CapitulosEntity, Integer> {

    @Query(nativeQuery = true)
    public Integer consultarCapituloExistente(
            @Param("episodio") Integer episodio);


    //INSERT EPISODIO
    @Query(value = "INSERT INTO episodios(episodio, nombre_episodio)"
            + "     VALUES (:episodio,:nombre_episodio) "
            + "     RETURNING episodio", nativeQuery = true)
    public String insertarCapitulo(
            @Param("episodio") Integer episodio,
            @Param("nombre_episodio") String nombre_episodio);

    //INSERT PERSONAJE
    @Query(value = "INSERT INTO personajes(episodio_aparicion, nombre, especie, genero, imagen)"
            + "     VALUES (:episodio_aparicion,:nombre,:especie,:genero,:imagen) "
            + "     RETURNING episodio_aparicion", nativeQuery = true)
    public String insertarPersonaje(
            @Param("episodio_aparicion") Integer episodio_aparicion,
            @Param("nombre") String nombre,
            @Param("especie") String especie,
            @Param("genero") String genero,
            @Param("imagen") String imagen);

    //INSERT LUGAR
    @Query(value = "INSERT INTO lugares(episodio, nombre, tipo, dimension)"
            + "     VALUES (:episodio,:nombre,:tipo,:dimension) "
            + "     RETURNING episodio", nativeQuery = true)
    public String insertarLugar(
            @Param("episodio") Integer episodio,
            @Param("nombre") String nombre,
            @Param("tipo") String tipo,
            @Param("dimension") String dimension);

}
