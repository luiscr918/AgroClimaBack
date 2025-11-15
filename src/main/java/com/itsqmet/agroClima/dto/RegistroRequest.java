package com.itsqmet.agroClima.dto;

import com.itsqmet.agroClima.enums.Rol;
import lombok.Data;

@Data
public class RegistroRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private Rol rol; // opcional
}
