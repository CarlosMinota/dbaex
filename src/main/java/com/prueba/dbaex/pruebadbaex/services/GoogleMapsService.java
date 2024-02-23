package com.prueba.dbaex.pruebadbaex.services;

import java.net.URI;

public interface GoogleMapsService {

    String perfectAddress();

    URI getBaseURI();

    String address(String jsonAddress);


}
