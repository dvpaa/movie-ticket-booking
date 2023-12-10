package jbnu.ssad1.service.payment;

import jbnu.ssad1.medel.entity.Member;
import jbnu.ssad1.medel.entity.Payment;
import jbnu.ssad1.repository.payment.PaymentRepository;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void pay(Payment payment) {
        Member member = payment.getBooking().getMember();
        member.getCoupons().remove(payment.getUsedCoupon());
        member.getPoint().minus(payment.getUsedPoint());
        paymentRepository.save(payment);
    }

    @Override
    public Payment findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> findAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> findPaymentsByMemberId(Long memberId) {
        return paymentRepository.findByMemberId(memberId);
    }

    @Override
    public void cancelPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId);
        Member member = payment.getBooking().getMember();
        member.getCoupons().add(payment.getUsedCoupon());
        member.getPoint().plus(payment.getUsedPoint());
        paymentRepository.delete(paymentId);
    }
}
