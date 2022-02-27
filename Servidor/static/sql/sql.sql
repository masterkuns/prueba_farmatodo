-- CREACION DE TABLA #1 episodios

create table episodios
(
    episodio        integer not null
        constraint episodios_pk
            primary key,
    nombre_episodio varchar not null
);

alter table episodios
    owner to postgres;

create unique index episodios_episodio_uindex
    on episodios (episodio);

-- CREACION DE TABLA #2 personajes

create table personajes
(
    id                 serial
        constraint personajes_pk
            primary key,
    episodio_aparicion integer not null,
    nombre             varchar,
    especie            varchar,
    genero             varchar,
    imagen             varchar
);

alter table personajes
    owner to postgres;


-- CREACION DE TABLA #3 lugares

create table lugares
(
    id        serial
        constraint lugares_pk
            primary key,
    episodio  integer not null,
    nombre    varchar,
    tipo      varchar,
    dimension varchar
);

alter table lugares
    owner to postgres;