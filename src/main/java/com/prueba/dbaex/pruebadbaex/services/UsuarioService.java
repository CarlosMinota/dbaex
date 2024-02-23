package com.prueba.dbaex.pruebadbaex.services;

import com.prueba.dbaex.pruebadbaex.exceptions.UserNotFoundException;
import com.prueba.dbaex.pruebadbaex.models.Usuario;

public interface UsuarioService {

    Usuario findUsuarioById(Long id) throws UserNotFoundException;
}
