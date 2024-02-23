package com.prueba.dbaex.pruebadbaex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ubicacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direccion")
    private String direccion;

    @JoinColumn(name = "fk_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"direcciones", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    private Usuario usuario;
}
