package com.prueba.dbaex.pruebadbaex.controllers;

import com.prueba.dbaex.pruebadbaex.exceptions.FieldEmptyException;
import com.prueba.dbaex.pruebadbaex.messages.Mensajes;
import com.prueba.dbaex.pruebadbaex.models.dto.UsuarioUbicacion;
import com.prueba.dbaex.pruebadbaex.services.UbicacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/ubicacion")
public class UbicacionController {

    private final UbicacionService ubicacionService;

    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> saveAdress(@RequestBody UsuarioUbicacion usuarioUbicacion){

        HashMap<String, Object> response = new HashMap<>();

        try {
            ubicacionService.guardarUbicacion(usuarioUbicacion);
        } catch (FieldEmptyException e) {
            response.put("mensaje", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", Mensajes.SAVE);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
