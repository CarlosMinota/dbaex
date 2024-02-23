package com.prueba.dbaex.pruebadbaex.repository;

import com.prueba.dbaex.pruebadbaex.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
