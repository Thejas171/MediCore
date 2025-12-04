package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.healthcare.model.Prescription;
import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    // find prescription by appointment
    Optional<Prescription> findByAppointmentId(Long appointmentId);
}
