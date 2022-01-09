package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.grade.Grade;
import anderson.reid.climblog.domain.grade.YDSGrade;
import anderson.reid.climblog.repositories.GradeRepository;
import anderson.reid.climblog.services.GradeService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class JPAGradeServiceYDS implements GradeService<YDSGrade> {

   private final GradeRepository gradeRepository;

   public JPAGradeServiceYDS(GradeRepository gradeRepository) {
      this.gradeRepository = gradeRepository;
   }

   @Override
   public List<YDSGrade> getGrades() {
      List<YDSGrade> grades = new ArrayList<>();
      gradeRepository.findAll().iterator().forEachRemaining(grade -> {
         if(grade instanceof YDSGrade) {
            grades.add((YDSGrade) grade);
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
