package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.grade.Grade;
import anderson.reid.climblog.domain.grade.VGrade;
import anderson.reid.climblog.repositories.GradeRepository;
import anderson.reid.climblog.services.GradeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class JPAGradeServiceV implements GradeService<VGrade> {

   private final GradeRepository gradeRepository;

   public JPAGradeServiceV(GradeRepository gradeRepository) {
      this.gradeRepository = gradeRepository;
   }

   @Override
   public List<VGrade> getGrades() {
      List<VGrade> grades = new ArrayList<>();
      gradeRepository.findAll().iterator().forEachRemaining(grade -> {
         if(grade instanceof VGrade) {
            grades.add((VGrade) grade);
         }
      });
      Collections.sort(grades);
      return grades;
   }

   @Override
   public Grade findGradeById(Long id) {
      Optional<Grade> grade = gradeRepository.findById(id);
      return grade.orElse(null);
   }
}
