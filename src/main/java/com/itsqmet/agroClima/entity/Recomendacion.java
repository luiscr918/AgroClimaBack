package com.itsqmet.agroClima.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Recomendacion {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //mensaje
    private String mensaje;
    //tipo
    private String tipo;
    //fecha de generacion
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_generacion;
    //CARDINALIDAD
    //con usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
