package com.healthcare.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class PaymentDTO {

    private Long id;

    @NotNull(message = "Appointment ID is required")
    private Long appointmentId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be positive")
    private Float amount;

    @NotBlank(message = "Payment method is required")
    private String method;

    @NotBlank(message = "Status is required")
    private String status;

    private LocalDateTime paymentTime;

    public PaymentDTO() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAppointmentId() { return appointmentId; }
    public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }

    public Float getAmount() { return amount; }
    public void setAmount(Float amount) { this.amount = amount; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getPaymentTime() { return paymentTime; }
    public void setPaymentTime(LocalDateTime paymentTime) { this.paymentTime = paymentTime; }
}
