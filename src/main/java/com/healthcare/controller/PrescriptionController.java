package com.healthcare.controller;

import com.healthcare.model.Prescription;
import com.healthcare.model.Appointment;
import com.healthcare.repository.PrescriptionRepository;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionRepository prescriptionRepository;
    private final AppointmentRepository appointmentRepository;

    public PrescriptionController(PrescriptionRepository prescriptionRepository,
                                  AppointmentRepository appointmentRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping
    public ResponseEntity<Prescription> create(@RequestBody Prescription prescription) {
        if (prescription.getAppointment() == null || prescription.getAppointment().getId() == null) {
            throw new IllegalArgumentException("appointment id is required");
        }

        Long apId = prescription.getAppointment().getId();
        Appointment ap = appointmentRepository.findById(apId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + apId));

        prescription.setAppointment(ap);
        Prescription saved = prescriptionRepository.save(prescription);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getById(@PathVariable Long id) {
        Prescription p = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with id " + id));
        return ResponseEntity.ok(p);
    }

    @GetMapping("/by-appointment/{appointmentId}")
    public ResponseEntity<?> getByAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.of(prescriptionRepository.findByAppointmentId(appointmentId));
    }
}
