package com.itsqmet.agroClima.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Terreno {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //nombre
    private String nombre;
    //tamaño hectarias
    @Column(precision = 10, scale = 3)
    private BigDecimal tamanioHectareas;
    //ubicacion
    private String ubicacion;
    //tipo suelo
    private String tipoSuelo;
    //CARDINALIDAD
    // USUARIO (PADRE)
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonBackReference(value = "usuario-terrenos")
    private Usuario usuario;

    // CULTIVOS (HIJO)
    @OneToMany(mappedBy = "terreno", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "terreno-cultivos")
    private List<Cultivo> cultivos;

    // PRONOSTICOS (HIJO)
    @OneToMany(mappedBy = "terreno", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "terreno-pronosticos")
    private List<Pronostico> pronosticos;
}
