package anderson.reid.climblog.services;

import anderson.reid.climblog.domain.grade.Grade;

import java.util.List;

public interface GradeService<T extends Grade> {

   List<T> getGrades();
}
