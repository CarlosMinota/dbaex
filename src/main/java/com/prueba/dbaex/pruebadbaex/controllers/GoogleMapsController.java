package com.prueba.dbaex.pruebadbaex.controllers;

import com.prueba.dbaex.pruebadbaex.models.dto.ResponseGoogleDto;
import com.prueba.dbaex.pruebadbaex.services.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/google")
public class GoogleMapsController {

    @Autowired
    private GoogleMapsService googleMapsService;

    @GetMapping("/navigate")
    public ResponseEntity<?> getAddressWithLongitudeAndLatitude(@RequestParam String longitude, @RequestParam String latitude) {

        HashMap<String, Object> response = new HashMap<>();

        Object bodyGoogle = googleMapsService.perfectAddress(longitude, latitude);
        response.put("resultado", bodyGoogle);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getAddressesAutoComplete/{address}")
    public ResponseEntity<?> getAddressesWithAddress(@PathVariable String address) {
        HashMap<String, Object> response = new HashMap<>();
        Object responseGoogle = googleMapsService.getAddressesAutoComplete(address);
        response.put("resultado", responseGoogle);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getAddressesTextSearch/{address}")
    public ResponseEntity<?> getAddressesTextSearch(@PathVariable String address) throws JSONException {
        HashMap<String, Object> response = new HashMap<>();
        List<ResponseGoogleDto> responseGoogle = googleMapsService.getAddressesTextSearch(address);
        response.put("resultado", responseGoogle);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
