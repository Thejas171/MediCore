package com.healthcare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String method; // CARD, UPI, CASH, etc.
    private String status; // PAID, PENDING, FAILED
    private LocalDateTime paymentTime;

    @OneToOne
    @JoinColumn(name = "appointment_id", unique = true)
    private Appointment appointment;

    public Payment() {}

    public Payment(Long id, Double amount, String method, String status, LocalDateTime paymentTime) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.paymentTime = paymentTime;
    }

    // Getters & Setters
    public Long getId() { 
    	return id; 
   	}
    public void setId(Long id) { 
    	this.id = id; 
    }

    public Double getAmount() { 
    	return amount; 
    }
    public void setAmount(Double amount) { 
    	this.amount = amount; 
    }

    public String getMethod() { 
    	return method; 
    }
    public void setMethod(String method) { 
    	this.method = method; 
    }

    public String getStatus() { 
    	return status; 
    }
    public void setStatus(String status) { 
    	this.status = status; 
    }

    public LocalDateTime getPaymentTime() { 
    	return paymentTime; 
    }
    public void setPaymentTime(LocalDateTime paymentTime) { 
    	this.paymentTime = paymentTime; 
    }

    public Appointment getAppointment() { 
    	return appointment; 
    }
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
        if (appointment != null && appointment.getPayment() != this) {
            appointment.setPayment(this);
        }
    }
}
