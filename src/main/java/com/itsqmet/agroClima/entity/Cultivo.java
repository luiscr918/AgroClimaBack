package com.itsqmet.agroClima.entity;

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
    //con terreno
    @ManyToOne
    @JoinColumn(name = "id_terreno")
    private Terreno terreno;
    //con siembra
    @OneToMany(mappedBy = "cultivo")
    private List<Siembra> siembras;
}
