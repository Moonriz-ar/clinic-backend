package com.example.clinica.service;

import com.example.clinica.entities.Address;
import com.example.clinica.entities.AddressDTO;
import com.example.clinica.entities.PatientDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void testCreatePatient() {
        PatientDTO patientDTO = new PatientDTO();
        Address address = new Address();

        address.setStreet("Av. Santa Fe");
        address.setNumber("4006");
        address.setProvince("Buenos Aires");
        address.setCity("Capital Federal");

        patientDTO.setName("Mario");
        patientDTO.setSurname("Kart");
        patientDTO.setEmail("mario@gmail.com");
        patientDTO.setDni("37694839");
        patientDTO.setRegistrationDate(LocalDate.now());
        patientDTO.setAddress(address);

        patientService.createPatient(patientDTO);

        PatientDTO patientMario = patientService.findPatientById(1L);

        assertNotNull(patientMario);
    }
}