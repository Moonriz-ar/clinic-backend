package com.example.clinica.controller;

import com.example.clinica.entities.PatientDTO;
import com.example.clinica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO patient = patientDTO;
        patient.setRegistrationDate(LocalDate.now());
        patientService.createPatient(patient);
        return ResponseEntity.ok((HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<?> modifyPatient(@RequestBody PatientDTO patientDTO) {
        patientService.modifyPatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findPatientById(id));
    }

    @GetMapping
    public Set<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminatePatientById(@PathVariable Long id) {
        patientService.eliminatePatientById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
