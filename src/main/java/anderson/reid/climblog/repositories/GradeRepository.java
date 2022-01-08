package anderson.reid.climblog.repositories;

import anderson.reid.climblog.domain.grade.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
}
