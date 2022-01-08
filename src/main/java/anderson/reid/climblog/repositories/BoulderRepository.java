package anderson.reid.climblog.repositories;

import anderson.reid.climblog.domain.climb.Boulder;
import org.springframework.data.repository.CrudRepository;

public interface BoulderRepository extends CrudRepository<Boulder, Long> {
}
