package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Pronostico {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //fecha
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    //remperatura minima
    @Column(precision = 10, scale = 3)
    private BigDecimal temperaturaMinima;
    //temperatura maxima
    @Column(precision = 10,scale = 2)
    private BigDecimal temperaturaMaxima;
    //precipitacion
    @Column(precision = 10,scale = 2)
    private BigDecimal precipitacion;
    //humedad
    @Column(precision = 10,scale = 2)
    private BigDecimal humedad;
    //descripcion
    private String descripcion;
    //CARDINALIDAD
    //con terreno
    @ManyToOne
    @JoinColumn(name = "id_terreno")
    private Terreno terreno;
}
