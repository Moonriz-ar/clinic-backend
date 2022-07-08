package com.example.clinica.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentDTO {
    private int id;
    private Patient patient;
    private Odontologist odontologist;
    private LocalDateTime appointmentDateTime;

    public AppointmentDTO() {

    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Odontologist getOdontologist() {
        return odontologist;
    }

    public void setOdontologist(Odontologist odontologist) {
        this.odontologist = odontologist;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
}
