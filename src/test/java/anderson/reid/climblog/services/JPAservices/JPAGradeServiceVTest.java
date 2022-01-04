package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Grade;
import anderson.reid.climblog.domain.VGrade;
import anderson.reid.climblog.domain.YDSGrade;
import anderson.reid.climblog.repositories.GradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JPAGradeServiceVTest {

   @Mock
   GradeRepository gradeRepository;

   @InjectMocks
   JPAGradeServiceV service;

   @Test
   void getGradesTest() {
      //given
      YDSGrade g1 = new YDSGrade("5.13a");
      VGrade v1 = new VGrade("V0");
      VGrade v2 = new VGrade("V1");
      List<Grade> grades = new ArrayList<>();
      grades.add(g1);
      grades.add(v1);
      grades.add(v2);

      //when
      when(gradeRepository.findAll()).thenReturn(grades);
      List<VGrade> returnedGrades = service.getGrades();

      //then
      verify(gradeRepository).findAll();
      assertEquals(2, returnedGrades.size());
   }
}