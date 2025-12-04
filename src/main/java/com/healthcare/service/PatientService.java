package com.healthcare.service;

import com.healthcare.model.Patient;
import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}
