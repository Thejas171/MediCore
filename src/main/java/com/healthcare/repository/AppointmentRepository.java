package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.healthcare.model.Appointment;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByPatientId(Long patientId);
}
