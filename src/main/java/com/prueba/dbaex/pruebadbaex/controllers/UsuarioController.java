package com.prueba.dbaex.pruebadbaex.controllers;

import com.prueba.dbaex.pruebadbaex.exceptions.UserNotFoundException;
import com.prueba.dbaex.pruebadbaex.models.Usuario;
import com.prueba.dbaex.pruebadbaex.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> findUsuarioById(@PathVariable Long id) {

        HashMap<String, Object> response = new HashMap<>();
        Usuario usuario;

        try {
            usuario = usuarioService.findUsuarioById(id);
        } catch (UserNotFoundException e) {
            response.put("mensaje" , e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("usuario", usuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
