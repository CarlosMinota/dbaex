package com.prueba.dbaex.pruebadbaex.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGoogleDto {

    private String address;

    private String lat;

    private String lng;
}
