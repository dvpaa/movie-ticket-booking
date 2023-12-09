package jbnu.ssad1.repository.booking;

import jbnu.ssad1.medel.entity.Booking;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryBookingRepository implements BookingRepository {

    private static Map<Long, Booking> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Booking save(Booking booking) {
        booking.setId(++sequence);
        store.put(booking.getId(), booking);
        return booking;
    }

    @Override
    public Booking findById(Long bookingId) {
        return store.get(bookingId);
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Booking> findByMemberId(Long memberId) {
        return findAll().stream()
                .filter(booking -> Objects.equals(booking.getMember().getId(), memberId))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long bookingId) {
        store.remove(bookingId);
    }

    @Override
    public void clear() {
        store.clear();
    }
}
