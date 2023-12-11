package jbnu.ssad1.repository.payment;

import jbnu.ssad1.medel.entity.Payment;

import java.util.List;

public interface PaymentRepository {

    Payment save(Payment payment);

    Payment findById(Long paymentId);

    List<Payment> findAll();

    List<Payment> findByMemberId(Long memberId);

    void delete(Long paymentId);

    void clear();

    Payment findByBookingId(Long bookingId);
}
