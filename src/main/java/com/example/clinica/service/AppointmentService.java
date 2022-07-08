package com.example.clinica.service;

import com.example.clinica.entities.Appointment;
import com.example.clinica.entities.AppointmentDTO;
import com.example.clinica.repository.IAppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentService {
    private IAppointmentRepository appointmentRepository;
    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
        return appointmentDTO;
    }

    public AppointmentDTO modifyAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
        return appointmentDTO;
    }

    public AppointmentDTO findAppointmentById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDTO appointmentDTO = null;
        if(appointment.isPresent()) {
            appointmentDTO = mapper.convertValue(appointment, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    public Set<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        Set<AppointmentDTO> appointmentsDTO = new HashSet<>();

        for (Appointment appointment : appointments) {
            appointmentsDTO.add(mapper.convertValue(appointment, AppointmentDTO.class));
        }

        return appointmentsDTO;
    }

    public void eliminateAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
