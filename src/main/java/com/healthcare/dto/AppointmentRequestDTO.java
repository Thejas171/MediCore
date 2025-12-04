package com.healthcare.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AppointmentRequestDTO {
	@NotNull
    private Long doctorId;
	@NotNull
    private Long patientId;
	@NotNull
    private String appointmentTime;
	@Size(max = 500)
    private String reason;

    public AppointmentRequestDTO() {}
    // getters & setters...
    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public String getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(String appointmentTime) { this.appointmentTime = appointmentTime; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
