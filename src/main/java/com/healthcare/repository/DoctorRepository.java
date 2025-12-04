package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.healthcare.model.Doctor;
import java.util.List;
// if you had Optional previously, use Optional<Doctor> findByEmail(String email)
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecializationContainingIgnoreCase(String specialization);
    Optional<Doctor> findByEmail(String email);
}
