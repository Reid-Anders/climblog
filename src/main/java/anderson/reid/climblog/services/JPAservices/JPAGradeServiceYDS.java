package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.YDSGrade;
import anderson.reid.climblog.repositories.GradeRepository;
import anderson.reid.climblog.services.GradeService;
import org.springframework.stereotype.Service;

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
}
