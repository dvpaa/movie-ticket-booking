package jbnu.ssad1.service.screening;

import jbnu.ssad1.medel.entity.Movie;
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
    public List<Screening> findScreeningsByMovie(Movie movie) {
        return screeningRepository.findByMovie(movie);
    }
}
