package jbnu.ssad1.service.payment;

import jbnu.ssad1.medel.entity.Payment;

import java.util.List;

public interface PaymentService {
    void pay(Payment payment);

    Payment findPaymentById(Long paymentId);

    List<Payment> findAllPayment();

    List<Payment> findPaymentsByMemberId(Long memberId);

    void cancelPayment(Long paymentId);
}
