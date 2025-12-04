package com.healthcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String medicines; // store as text; later you can switch to JSON or separate table
    private String notes;

    @OneToOne
    @JoinColumn(name = "appointment_id", unique = true)
    private Appointment appointment;

    public Prescription() {}

    public Prescription(Long id, String medicines, String notes) {
        this.id = id;
        this.medicines = medicines;
        this.notes = notes;
    }

    // Getters & Setters
    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id; 
    }

    public String getMedicines() { 
    	return medicines; 
    }
    public void setMedicines(String medicines) { 
    	this.medicines = medicines; 
    }

    public String getNotes() { 
    	return notes; 
    }
    public void setNotes(String notes) { 
    	this.notes = notes; 
    }

    public Appointment getAppointment() { 
    	return appointment; 
    }
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
        if (appointment != null && appointment.getPrescription() != this) {
            appointment.setPrescription(this);
        }
    }
}
