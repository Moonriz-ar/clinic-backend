package com.example.clinica.controller;

import com.example.clinica.entities.OdontologistDTO;
import com.example.clinica.service.OdontologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/odontologists")
public class OdontologistController {
    @Autowired
    private OdontologistService odontologistService;

    @PostMapping
    public ResponseEntity<?> createOdontologist(@RequestBody OdontologistDTO odontologistDTO) {
        odontologistService.createOdontologist(odontologistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modifyOdontologist(@RequestBody OdontologistDTO odontologistDTO) {
        odontologistService.modifyOdontologist(odontologistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologistDTO> findOdontologistById(@PathVariable Long id) {
        return ResponseEntity.ok(odontologistService.findOdontologistById(id));
    }

    @GetMapping
    public Set<OdontologistDTO> getAllOdontologists() {
        return odontologistService.getAllOdontologists();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminateOdontologistById(@PathVariable Long id) {
        odontologistService.eliminateOdontologistById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
