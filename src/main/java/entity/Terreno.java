package entity;

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
    //con usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    //con cultivos
    @OneToMany(mappedBy = "terreno")
    private List<Cultivo> cultivos;
    //con pronostico
    @OneToMany(mappedBy = "terreno")
    private List<Pronostico> pronosticos;
}
