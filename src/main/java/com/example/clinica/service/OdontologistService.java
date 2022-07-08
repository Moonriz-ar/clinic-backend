package com.example.clinica.service;

import com.example.clinica.entities.Odontologist;
import com.example.clinica.entities.OdontologistDTO;
import com.example.clinica.repository.IOdontologistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologistService {
    private IOdontologistRepository odontologistRepository;
    public OdontologistService(IOdontologistRepository odontologistRepository) {
        this.odontologistRepository = odontologistRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public OdontologistDTO createOdontologist(OdontologistDTO odontologistDTO) {
        Odontologist odontologist = mapper.convertValue(odontologistDTO, Odontologist.class);
        odontologistRepository.save(odontologist);
        return odontologistDTO;
    }

    public OdontologistDTO modifyOdontologist(OdontologistDTO odontologistDTO) {
        Odontologist odontologist = mapper.convertValue(odontologistDTO, Odontologist.class);
        odontologistRepository.save(odontologist);
        return odontologistDTO;
    }

    public OdontologistDTO findOdontologistById(Long id) {
        Optional<Odontologist> odontologist = odontologistRepository.findById(id);
        OdontologistDTO odontologistDTO = null;
        if(odontologist.isPresent()) {
            odontologistDTO = mapper.convertValue(odontologist, OdontologistDTO.class);
        }
        return odontologistDTO;
    }

    public Set<OdontologistDTO> getAllOdontologists() {
        List<Odontologist> odontologists = odontologistRepository.findAll();
        Set<OdontologistDTO> odontologistsDTO = new HashSet<>();

        for (Odontologist odontologist : odontologists) {
            odontologistsDTO.add(mapper.convertValue(odontologist, OdontologistDTO.class));
        }

        return odontologistsDTO;
    }

    public void eliminateOdontologistById(Long id) {
        odontologistRepository.deleteById(id);
    }

}
