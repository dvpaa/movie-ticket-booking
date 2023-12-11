package jbnu.ssad1.service.booking;

import jbnu.ssad1.medel.entity.Booking;
import jbnu.ssad1.repository.booking.BookingRepository;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void book(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findBookingsByMemberEmail(String email) {
        return bookingRepository.findByMemberEmail(email);
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.delete(bookingId);
    }
}
