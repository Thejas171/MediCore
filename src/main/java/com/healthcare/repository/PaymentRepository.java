package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.healthcare.model.Payment;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // find payment by appointment
    Optional<Payment> findByAppointmentId(Long appointmentId);
}
