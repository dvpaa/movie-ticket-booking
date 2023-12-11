package jbnu.ssad1.repository.booking;

import jbnu.ssad1.medel.entity.Booking;

import java.util.List;

public interface BookingRepository {

    Booking save(Booking booking);

    Booking findById(Long bookingId);

    List<Booking> findAll();

    List<Booking> findByMemberId(Long memberId);

    void delete(Long bookingId);

    void clear();

    List<Booking> findByMemberEmail(String email);
}
