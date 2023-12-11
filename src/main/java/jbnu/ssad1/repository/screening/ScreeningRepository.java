package jbnu.ssad1.repository.screening;

import jbnu.ssad1.medel.entity.Movie;
import jbnu.ssad1.medel.entity.Screening;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningRepository {

    Screening save(Screening screening);

    Screening findById(Long screeningId);

    List<Screening> findAll();

    List<Screening> findNotStarted(LocalDateTime now);

    List<Screening> findByMovie(Movie movie);

    void delete(Long screeningId);

    void clear();
}
