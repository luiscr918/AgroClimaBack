package com.itsqmet.agroClima.dto;

import com.itsqmet.agroClima.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String email;
    private Rol rol;
}
