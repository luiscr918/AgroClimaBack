package com.itsqmet.agroClima.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsqmet.agroClima.enums.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Usuario {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //nombre
    @NotBlank
    private String nombre;
    //apellido
    @NotBlank
    private String apellido;
    //email
    @Column(unique = true)
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Ingrese un correo válido"
    )
    private String email;
    //contraseña
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$",
            message = "La contraseña debe tener mínimo 8 caracteres, incluir mayúscula, minúscula, número y caracter especial"
    )
    private  String password;
    //telefono
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "El telefono tiene que tener 10 digitos y solo se permiten numeros")
    private  String telefono;
    //rol
    @Enumerated(EnumType.STRING)
    private Rol rol;
    //CARDINALIDAD
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "usuario-terrenos")
    private List<Terreno> terrenos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "usuario-recomendaciones")
    private List<Recomendacion> recomendaciones;
}
