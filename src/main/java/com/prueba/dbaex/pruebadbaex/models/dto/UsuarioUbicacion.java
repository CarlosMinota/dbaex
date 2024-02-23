package com.prueba.dbaex.pruebadbaex.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioUbicacion {

    private Long idUsuario;

    private String direccion;
}
