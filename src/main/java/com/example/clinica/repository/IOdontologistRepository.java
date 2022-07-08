package com.example.clinica.repository;

import com.example.clinica.entities.Odontologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologistRepository extends JpaRepository<Odontologist, Long> {
}
