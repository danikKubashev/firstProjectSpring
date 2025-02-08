package com.example.firstProjectSpring.impl;

import com.example.firstProjectSpring.client.Appartment;
import com.example.firstProjectSpring.client.Client;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("singleton")
public interface AppartmentService {

    List<Appartment> getAllAppartments();



    boolean canGetMortgage(Client client, Appartment apartment);


    Appartment getApartmentById(Long appartmentId);
}
