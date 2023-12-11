package jbnu.ssad1.repository.payment;

import jbnu.ssad1.discount.Coupon;
import jbnu.ssad1.discount.RateDiscountPolicy;
import jbnu.ssad1.medel.entity.*;
import jbnu.ssad1.money.Money;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentRepositoryTest {

    PaymentRepository paymentRepository = new MemoryPaymentRepository();
    Payment payment1;
    Payment payment2;

    @BeforeEach
    void setUp() {
        Movie movie1 = new Movie(
                "서울의 봄",
                "김성수",
                Arrays.asList("황정민", "정우성", "이성민", "박해준", "김성균", "김의성"),
                LocalDate.of(2023, 11, 22),
                9.57,
                true
        );

        Movie movie2 = new Movie(
                "말하고 싶은 비밀",
                "타케무라 켄타로",
                Arrays.asList("타카하시 후미야", "사쿠라다 히요리"),
                LocalDate.of(2023, 12, 13),
                null,
                false
        );
        movie1.setId(1L);
        movie2.setId(2L);

        Screening screening1 = new Screening(movie1, LocalDateTime.of(2024, 12, 9, 13, 0));
        Screening screening2 = new Screening(movie2, LocalDateTime.of(2024, 12, 13, 14, 0));
        screening1.setId(1L);
        screening2.setId(2L);

        Member member1 = new Member("email1", "password1", "name1");
        Member member2 = new Member("email2", "password2", "name2");
        member1.setId(1L);
        member2.setId(2L);

        Booking booking1 = new Booking(member1, screening1);
        Booking booking2 = new Booking(member2, screening2);
        booking1.setId(1L);
        booking2.setId(2L);

        this.payment1 = new Payment(booking1, Money.wons(15000L), null, null, LocalDateTime.of(2023, 12, 10, 19, 0));
        this.payment2 = new Payment(booking2, Money.wons(13500L), new Coupon(new RateDiscountPolicy(0.1)), null, LocalDateTime.of(2023, 12, 10, 19, 0));
    }

    @AfterEach
    void tearDown() {
        paymentRepository.clear();
    }

    @Test
    void save() {
        Payment save = paymentRepository.save(payment1);

        Payment find = paymentRepository.findById(payment1.getId());

        assertThat(find).isEqualTo(save);
    }

    @Test
    void findAll() {
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

        List<Payment> all = paymentRepository.findAll();

        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(payment1, payment2);
    }

    @Test
    void findByMemberId() {
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

        List<Payment> byMemberId = paymentRepository.findByMemberId(2L);
        assertThat(byMemberId.size()).isEqualTo(1);
        assertThat(byMemberId).contains(payment2);
    }
}