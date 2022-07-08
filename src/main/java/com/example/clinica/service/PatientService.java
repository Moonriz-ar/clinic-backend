package com.example.clinica.service;

import com.example.clinica.entities.Patient;
import com.example.clinica.entities.PatientDTO;
import com.example.clinica.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService {
    private final IPatientRepository patientRepository;
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
        return patientDTO;
    }

    public PatientDTO modifyPatient(PatientDTO patientDTO) {
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
        return patientDTO;
    }

    public PatientDTO findPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;
        if(patient.isPresent()) {
            patientDTO = mapper.convertValue(patient, PatientDTO.class);
        }
        return patientDTO;
    }

    public Set<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientsDTO = new HashSet<>();

        for(Patient patient : patients) {
            patientsDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }

        return patientsDTO;
    }

    public void eliminatePatientById(Long id) {
        patientRepository.deleteById(id);
    }
}
