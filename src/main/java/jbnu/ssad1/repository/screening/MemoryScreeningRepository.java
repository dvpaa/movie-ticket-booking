package jbnu.ssad1.repository.screening;

import jbnu.ssad1.medel.entity.Screening;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryScreeningRepository implements ScreeningRepository {

    private static Map<Long, Screening> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Screening save(Screening screening) {
        screening.setId(++sequence);
        store.put(sequence, screening);
        return screening;
    }

    @Override
    public Screening findById(Long screeningId) {
        return store.get(screeningId);
    }

    @Override
    public List<Screening> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Screening> findNotStarted(LocalDateTime now) {
        return findAll().stream()
                .filter(screening -> screening.getScreeningDate().isAfter(now.minusMinutes(30)))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long screeningId) {
        store.remove(screeningId);
    }

    @Override
    public void clear() {
        store.clear();
    }
}
