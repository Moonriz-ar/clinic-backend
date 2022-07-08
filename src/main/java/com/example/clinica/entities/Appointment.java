package com.example.clinica.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDateTime;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "odontologist_id", nullable = false)
    private Odontologist odontologist;

    public Appointment() {

    }

    public Appointment(LocalDateTime appointmentDateTime, Patient patient, Odontologist odontologist) {
        this.appointmentDateTime = appointmentDateTime;
        this.patient = patient;
        this.odontologist = odontologist;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
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
}
