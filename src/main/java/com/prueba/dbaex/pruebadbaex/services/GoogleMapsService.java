package com.prueba.dbaex.pruebadbaex.services;

import com.prueba.dbaex.pruebadbaex.models.dto.ResponseGoogleDto;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.net.URI;
import java.util.List;

public interface GoogleMapsService {

    Object perfectAddress(String longitude, String latitude);

    Object getAddressesAutoComplete(String address);

    List<ResponseGoogleDto> getAddressesTextSearch(String address) throws JSONException;

}
