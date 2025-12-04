package com.healthcare.dto;

import jakarta.validation.constraints.*;

public class PrescriptionDTO {

    private Long id;

    @NotNull(message = "Appointment ID is required")
    private Long appointmentId;

    @NotBlank(message = "Medicines field cannot be empty")
    private String medicines;

    @Size(max = 500, message = "Notes max length is 500")
    private String notes;

    public PrescriptionDTO() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAppointmentId() { return appointmentId; }
    public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }

    public String getMedicines() { return medicines; }
    public void setMedicines(String medicines) { this.medicines = medicines; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
