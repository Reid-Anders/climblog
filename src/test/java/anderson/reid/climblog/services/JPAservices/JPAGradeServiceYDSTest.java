package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.grade.Grade;
import anderson.reid.climblog.domain.grade.YDSGrade;
import anderson.reid.climblog.repositories.GradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JPAGradeServiceYDSTest {

   @Mock
   GradeRepository gradeRepository;

   @InjectMocks
   JPAGradeServiceYDS gradeService;

   @Test
   void getGrades() {
      //given
      YDSGrade g1 = new YDSGrade("5.13a");
      YDSGrade g2 = new YDSGrade("5.13b");
      Set<Grade> grades = new HashSet<>();
      grades.add(g1);
      grades.add(g2);

      //when
      when(gradeRepository.findAll()).thenReturn(grades);
      List<YDSGrade> returnedGrades = gradeService.getGrades();

      //then
      assertEquals(2, returnedGrades.size());
      verify(gradeRepository).findAll();
   }
}