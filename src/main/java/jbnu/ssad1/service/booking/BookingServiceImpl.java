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
    public Booking findBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> findBookingsByMemberId(Long memberId) {
        return bookingRepository.findByMemberId(memberId);
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.delete(bookingId);
    }
}
