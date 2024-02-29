package com.prueba.dbaex.pruebadbaex.services.impl;

import com.prueba.dbaex.pruebadbaex.models.dto.ResponseGoogleDto;
import com.prueba.dbaex.pruebadbaex.services.GoogleMapsService;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class GoogleMapsServiceImpl implements GoogleMapsService {

    private static final String apiKey = "AIzaSyAnxqtgXV7FivXxIruCZLa6WmIb9QXGpEE";
    private static final String uriGoogle = "https://maps.googleapis.com/maps/api/";

    @Override
    public Object perfectAddress(String longitude, String latitude) {
        String uri = uriGoogle + "geocode/json?latlng=" + latitude + "," + longitude + "&key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(uri, Object.class);
    }

    @Override
    public Object getAddressesAutoComplete(String address) {
        String uri = uriGoogle + "place/autocomplete/json?input=" + address + "&key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Object.class);
    }

    @Override
    public List<ResponseGoogleDto> getAddressesTextSearch(String address) throws JSONException {
        String uri = uriGoogle + "/place/textsearch/json?query=" + address + "&key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        String googleResponse = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObjectResponse = new JSONObject(googleResponse);
        List<ResponseGoogleDto> listaResponse = new ArrayList<>();
        for (int i = 0; i < jsonObjectResponse.getJSONArray("results").length(); i++) {
            String formattedAddress = jsonObjectResponse.getJSONArray("results").getJSONObject(i).getString("formatted_address");
            String lat = jsonObjectResponse.getJSONArray("results").getJSONObject(i).getJSONObject("geometry")
                    .getJSONObject("location").getString("lat");
            String lng = jsonObjectResponse.getJSONArray("results").getJSONObject(i).getJSONObject("geometry")
                    .getJSONObject("location").getString("lng");
            ResponseGoogleDto responseGoogleDto = new ResponseGoogleDto();
            responseGoogleDto.setAddress(formattedAddress);
            responseGoogleDto.setLat(lat);
            responseGoogleDto.setLng(lng);
            listaResponse.add(responseGoogleDto);
        }
        return listaResponse;
    }

    @Override
    public URI getBaseURI() {
        return null;
    }

    @Override
    public String address(String jsonAddress) {
        return null;
    }
}
