package com.healthcare.service;

import com.healthcare.model.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    Doctor updateDoctor(Long id, Doctor doctor);
    void deleteDoctor(Long id);
}
