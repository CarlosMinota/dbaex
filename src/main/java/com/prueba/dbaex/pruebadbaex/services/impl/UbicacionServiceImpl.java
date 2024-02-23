package com.prueba.dbaex.pruebadbaex.services.impl;

import com.prueba.dbaex.pruebadbaex.exceptions.FieldEmptyException;
import com.prueba.dbaex.pruebadbaex.messages.Mensajes;
import com.prueba.dbaex.pruebadbaex.models.Ubicacion;
import com.prueba.dbaex.pruebadbaex.models.dto.UsuarioUbicacion;
import com.prueba.dbaex.pruebadbaex.repository.UbicacionRepository;
import com.prueba.dbaex.pruebadbaex.services.UbicacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    public UbicacionServiceImpl(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }

    @Transactional
    @Override
    public void guardarUbicacion(UsuarioUbicacion ubicacion) throws FieldEmptyException {
        if (ubicacion.getIdUsuario() == null || ubicacion.getDireccion() == null || ubicacion.getDireccion().isEmpty()) {
            throw new FieldEmptyException(Mensajes.FIELD_EMPTY_EXCEPTION);
        }
        Ubicacion ubicacionUsuario = ubicacionRepository.findByUsuario_Id(ubicacion.getIdUsuario());
        ubicacionUsuario.setDireccion(ubicacion.getDireccion());
        ubicacionRepository.save(ubicacionUsuario);
    }
}
