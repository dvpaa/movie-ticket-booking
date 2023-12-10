package jbnu.ssad1.repository.payment;

import jbnu.ssad1.medel.entity.Payment;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryPaymentRepository implements PaymentRepository {

    private static Map<Long, Payment> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Payment save(Payment payment) {
        payment.setId(++sequence);
        store.put(payment.getId(), payment);
        return payment;
    }

    @Override
    public Payment findById(Long paymentId) {
        return store.get(paymentId);
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Payment> findByMemberId(Long memberId) {
        return findAll().stream()
                .filter(payment -> Objects.equals(payment.getBooking().getMember().getId(), memberId))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long paymentId) {
        store.remove(paymentId);
    }

    @Override
    public void clear() {
        store.clear();
    }
}
