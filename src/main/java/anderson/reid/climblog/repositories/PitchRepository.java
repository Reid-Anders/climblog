package anderson.reid.climblog.repositories;

import anderson.reid.climblog.domain.sessionclimb.Pitch;
import org.springframework.data.repository.CrudRepository;

public interface PitchRepository extends CrudRepository<Pitch, Long> {
}
