package com.prueba.dbaex.pruebadbaex.repository;

import com.prueba.dbaex.pruebadbaex.models.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

    Ubicacion findByUsuario_Id(Long id);
}
