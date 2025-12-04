package com.healthcare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments", uniqueConstraints = @UniqueConstraint(name = "uk_doctor_time",
columnNames = {"doctor_id", "appointment_time"}))
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentTime;
    private String status; // e.g., BOOKED, COMPLETED, CANCELLED
    private String reason;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Prescription prescription;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;

    public Appointment() {}

    public Appointment(Long id, LocalDateTime appointmentTime, String status, String reason,
                       Doctor doctor, Patient patient) {
        this.id = id;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
        this.doctor = doctor;
        this.patient = patient;
    }

    // Getters & Setters
    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id; 
    }

    public LocalDateTime getAppointmentTime() { 
    	return appointmentTime; 
    }
    public void setAppointmentTime(LocalDateTime appointmentTime) { 
    	this.appointmentTime = appointmentTime; 
    }

    public String getStatus() { 
    	return status; 
    }
    public void setStatus(String status) { 
    	this.status = status; 
    }

    public String getReason() { 
    	return reason; 
    }
    public void setReason(String reason) { 
    	this.reason = reason; 
    }

    public Doctor getDoctor() { 
    	return doctor; 
    }
    public void setDoctor(Doctor doctor) { 
    	this.doctor = doctor; 
    }

    public Patient getPatient() { 
    	return patient; 
    }
    public void setPatient(Patient patient) {
    	this.patient = patient; 
    }

    public Prescription getPrescription() { 
    	return prescription; 
    }
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
        if (prescription != null) {
            prescription.setAppointment(this);
        }
    }

    public Payment getPayment() { 
    	return payment; 
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
        if (payment != null) {
            payment.setAppointment(this);
        }
    }
}
