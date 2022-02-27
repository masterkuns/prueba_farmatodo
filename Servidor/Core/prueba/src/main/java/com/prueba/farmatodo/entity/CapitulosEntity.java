package com.prueba.farmatodo.entity;



import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "Episodios", schema = "public")
@XmlRootElement


@SqlResultSetMapping(name = "ConteoCapitulosTotalMapping",
        classes = {
                @ConstructorResult(
                        targetClass = Integer.class,
                        columns = {
                                @ColumnResult(name = "total", type = Integer.class)}
                )})

@NamedNativeQueries({


        @NamedNativeQuery(name = "CapitulosEntity.consultarCapituloExistente",
                query = "SELECT count(*) AS total " +
                        "FROM Episodios " +
                        "WHERE episodio = :episodio",
                resultSetMapping = "ConteoCapitulosTotalMapping"),


})

public class CapitulosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "episodio")
    private int episodio;
}
