package com.healthcare.controller;

import com.healthcare.model.Payment;
import com.healthcare.model.Appointment;
import com.healthcare.repository.PaymentRepository;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;
    private final AppointmentRepository appointmentRepository;

    public PaymentController(PaymentRepository paymentRepository,
                             AppointmentRepository appointmentRepository) {
        this.paymentRepository = paymentRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        if (payment.getAppointment() == null || payment.getAppointment().getId() == null) {
            throw new IllegalArgumentException("appointment id is required");
        }

        Long apId = payment.getAppointment().getId();
        Appointment ap = appointmentRepository.findById(apId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + apId));

        payment.setPaymentTime(LocalDateTime.now());
        payment.setAppointment(ap);
        Payment saved = paymentRepository.save(payment);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable Long id) {
        Payment p = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id " + id));
        return ResponseEntity.ok(p);
    }

    @GetMapping("/by-appointment/{appointmentId}")
    public ResponseEntity<?> getByAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.of(paymentRepository.findByAppointmentId(appointmentId));
    }
}
