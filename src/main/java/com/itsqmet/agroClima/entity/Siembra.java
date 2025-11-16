package com.itsqmet.agroClima.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itsqmet.agroClima.enums.EstadoS;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Siembra {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //fecha de siembra
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaSiembra;
    //Estado
    @Enumerated(EnumType.STRING)
    private EstadoS estado;
    //CARDINALIDAD
    // CULTIVO (PADRE)
    @ManyToOne
    @JoinColumn(name = "id_cultivo")
    @JsonBackReference(value = "cultivo-siembras")
    private Cultivo cultivo;
    // Getter transitorio para JSON
    @JsonProperty("cultivoId")
    public Long getCultivoId() {
        return cultivo != null ? cultivo.getId() : null;
    }
}
