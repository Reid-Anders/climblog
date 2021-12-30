package anderson.reid.climblog.repositories;

import anderson.reid.climblog.domain.Grade;
import anderson.reid.climblog.domain.YDSGrade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
}
