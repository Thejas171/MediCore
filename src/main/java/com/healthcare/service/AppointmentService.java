package com.healthcare.service;

import com.healthcare.model.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment) throws IllegalArgumentException;
    Appointment getAppointmentById(Long id);
    List<Appointment> getAppointmentsByDoctor(Long doctorId);
    List<Appointment> getAppointmentsByPatient(Long patientId);
    Appointment updateAppointmentStatus(Long id, String status);
    void cancelAppointment(Long id);
}
