package com.example.clinica.controller;

import com.example.clinica.entities.*;
import com.example.clinica.service.AppointmentService;
import com.example.clinica.service.OdontologistService;
import com.example.clinica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private OdontologistService odontologistService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        ResponseEntity<AppointmentDTO> response;

        // control if id are existent
        PatientDTO patientDTO = patientService.findPatientById(appointmentDTO.getPatient().getId());
        OdontologistDTO odontologistDTO = odontologistService.findOdontologistById(appointmentDTO.getOdontologist().getId());

        // control
        if (patientDTO!=null&&odontologistDTO!=null) {
            // control passed, add the appointment
            response = ResponseEntity.ok(appointmentService.createAppointment(appointmentDTO));
        }
        else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<?> modifyAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.modifyAppointment(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.findAppointmentById(id));
    }

    @GetMapping
    public ResponseEntity<Set<AppointmentDTO>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminateAppointmentById(@PathVariable Long id) {
        appointmentService.eliminateAppointmentById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
