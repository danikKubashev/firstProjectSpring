package com.example.firstProjectSpring.impl;

import com.example.firstProjectSpring.client.Client;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("singleton")
public interface ClientService {

    List<Client> getAllClients();

    Client findById(int id);

    void deleteClientsById(int id);

    void addClients(Client film);

    void updateClients(Client film);


}