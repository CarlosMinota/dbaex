package com.prueba.dbaex.pruebadbaex.services.impl;

import com.prueba.dbaex.pruebadbaex.exceptions.UserNotFoundException;
import com.prueba.dbaex.pruebadbaex.messages.Mensajes;
import com.prueba.dbaex.pruebadbaex.models.Usuario;
import com.prueba.dbaex.pruebadbaex.repository.UsuarioRepository;
import com.prueba.dbaex.pruebadbaex.services.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findUsuarioById(Long id) throws UserNotFoundException {
         return usuarioRepository.findById(id).orElseThrow(() ->
            new UserNotFoundException(Mensajes.USER_NOT_FOUND_EXCEPTION)
        );
    }
}
