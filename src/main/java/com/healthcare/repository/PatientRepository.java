package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.healthcare.model.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContainingIgnoreCase(String name);
    Optional<Patient> findByEmail(String email);
}
