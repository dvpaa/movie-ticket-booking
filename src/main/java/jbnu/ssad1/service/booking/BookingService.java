package jbnu.ssad1.service.booking;

import jbnu.ssad1.medel.entity.Booking;
import jbnu.ssad1.medel.entity.Payment;

import java.util.List;

public interface BookingService {

    void book(Booking booking);

    List<Booking> findBookingsByMemberEmail(String email);

    void deleteBooking(Long bookingId);
}
