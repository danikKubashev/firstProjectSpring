package com.example.firstProjectSpring.impl;

import com.example.firstProjectSpring.client.Appartment;
import com.example.firstProjectSpring.client.Client;
import com.example.firstProjectSpring.repository.AppartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppartmentServiceImpl  implements AppartmentService {
    private final AppartmentRepository appartmentRepository;
    private static final double MAX_LOAN_RATIO = 0.6;

    public List<Appartment> getAllAppartments() {
        return appartmentRepository.findAll();
    }

    @Override
    public Appartment getApartmentById(Long appartmentId) {
        return appartmentRepository.findById(appartmentId).get();
    }


    public boolean canGetMortgage(Client client, Appartment appartment) {
        double maxLoanAmount = client.getSalary() * MAX_LOAN_RATIO;
        return appartment.getPrice() <= maxLoanAmount;
    }






}
