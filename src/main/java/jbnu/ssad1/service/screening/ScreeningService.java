package jbnu.ssad1.service.screening;

import jbnu.ssad1.medel.entity.Movie;
import jbnu.ssad1.medel.entity.Screening;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningService {

    List<Screening> findScreeningsByMovie(Movie movie);
}
