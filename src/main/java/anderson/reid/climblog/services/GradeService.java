package anderson.reid.climblog.services;

import anderson.reid.climblog.domain.Grade;

import java.util.List;
import java.util.Set;

public interface GradeService<T extends Grade> {

   List<T> getGrades();
}
