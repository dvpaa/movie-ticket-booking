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
        paymentRepository.save(payment);
        Member member = payment.getBooking().getMember();
        if (payment.getUsedCoupon() != null) {
            member.getCoupons().remove(payment.getUsedCoupon());
            payment.setPaymentAmount(payment.getUsedCoupon().discount(payment.getPaymentAmount()));
        }
        if (payment.getUsedPoint() != null) {
            member.setPoint(member.getPoint().minus(payment.getUsedPoint()));
            payment.setPaymentAmount(payment.getPaymentAmount().minus(payment.getUsedPoint()));
        }
    }

    @Override
    public Payment findPaymentByBookingId(Long bookingId) {
        return paymentRepository.findByBookingId(bookingId);
    }

    @Override
    public void cancelPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId);
        Member member = payment.getBooking().getMember();
        if (payment.getUsedCoupon() != null) {
            member.getCoupons().add(payment.getUsedCoupon());
        }
        if (payment.getUsedPoint() != null) {
            member.getPoint().plus(payment.getUsedPoint());
        }
        paymentRepository.delete(paymentId);
    }
}
