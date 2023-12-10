package jbnu.ssad1.service.screening;

import jbnu.ssad1.medel.entity.Screening;
import jbnu.ssad1.repository.screening.ScreeningRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ScreeningServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public Screening findScreeningById(Long screeningId) {
        return this.screeningRepository.findById(screeningId);
    }

    @Override
    public List<Screening> findAllScreening() {
        return this.screeningRepository.findAll();
    }

    @Override
    public List<Screening> findNotStartedScreenings(LocalDateTime now) {
        return this.screeningRepository.findNotStarted(now);
    }
}
