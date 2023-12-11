package jbnu.ssad1.service.booking;

import jbnu.ssad1.medel.entity.Booking;

import java.util.List;

public interface BookingService {

    void book(Booking booking);

    Booking findBookingById(Long bookingId);

    List<Booking> findAllBookings();

    List<Booking> findBookingsByMemberId(Long memberId);

    List<Booking> findBookingsByMemberEmail(String email);

    void deleteBooking(Long bookingId);
}
