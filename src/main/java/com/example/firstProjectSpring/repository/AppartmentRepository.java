package com.example.firstProjectSpring.repository;

import com.example.firstProjectSpring.client.Appartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppartmentRepository extends JpaRepository<Appartment, Long> {
}