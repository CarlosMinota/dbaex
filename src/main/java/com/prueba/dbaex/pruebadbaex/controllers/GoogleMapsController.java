package com.prueba.dbaex.pruebadbaex.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/waze")
public class GoogleMapsController {

    @GetMapping("/navigate")
    public String wazeNavigation(@RequestParam String longitude, @RequestParam String latitude) {
        String wazeUrl = "https://www.waze.com/ul?ll=" + latitude + "," + longitude;

        return "forward:/" + wazeUrl;
    }
}
