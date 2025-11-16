package com.itsqmet.agroClima.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Cultivo {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //nombre
    private String nombre;
    //tipo
    private String tipo;
    //ciclo de dias
    private Integer cicloDias;
    //temporada optima
    private String temporadaOptima;
    //CARNDINALIDAD
    // TERRENO (PADRE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_terreno")
    @JsonBackReference(value = "terreno-cultivos")
    private Terreno terreno;

    // SIEMBRAS (HIJO)
    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "cultivo-siembras")
    private List<Siembra> siembras;
    // Getter transitorio para JSON
    @JsonProperty("terrenoId")
    public Long getTerrenoId() {
        return terreno != null ? terreno.getId() : null;
    }
}
