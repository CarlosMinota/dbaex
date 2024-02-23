package com.prueba.dbaex.pruebadbaex.services;

import com.prueba.dbaex.pruebadbaex.exceptions.FieldEmptyException;
import com.prueba.dbaex.pruebadbaex.models.Ubicacion;
import com.prueba.dbaex.pruebadbaex.models.dto.UsuarioUbicacion;

public interface UbicacionService {

    void guardarUbicacion(UsuarioUbicacion ubicacion) throws FieldEmptyException;
}
