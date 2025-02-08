package com.example.firstProjectSpring.impl;

import com.example.firstProjectSpring.client.Client;
import com.example.firstProjectSpring.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public void deleteClientsById(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void addClients(Client film) {
        clientRepository.save(film);
    }

    @Override
    public void updateClients(Client film) {
        clientRepository.save(film);
    }

}