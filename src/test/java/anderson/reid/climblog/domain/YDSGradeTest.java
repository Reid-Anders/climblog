package anderson.reid.climblog.domain;

import anderson.reid.climblog.domain.grade.Grade;
import anderson.reid.climblog.domain.grade.YDSGrade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class YDSGradeTest {

   Grade grade;

   @BeforeEach
   void setUp() {
      grade = new YDSGrade("5.13a");
   }

   @Test
   void testToString() {
      assertEquals("5.13a", grade.toString());
   }

   @Test
   void testIncrement() {
      grade.increment();
      grade.increment();
      grade.increment();
      grade.increment();

      assertEquals("5.14a", grade.toString());
   }

   @Test
   void testDecrement() {
      grade.decrement();

      assertEquals("5.12d", grade.toString());
   }

   @Test
   void testSort() {
      YDSGrade twelveD = new YDSGrade("5.12d");
      YDSGrade thirteenA = new YDSGrade("5.13a");
      YDSGrade thirteenB = new YDSGrade("5.13b");
      YDSGrade thirteenC = new YDSGrade("5.13c");
      YDSGrade thirteenD = new YDSGrade("5.13d");
      YDSGrade fourteenA = new YDSGrade("5.14a");
      YDSGrade fourteenB = new YDSGrade("5.14b");
      YDSGrade fourteenC = new YDSGrade("5.14c");
      YDSGrade fourteenD = new YDSGrade("5.14d");
      YDSGrade fifteenA = new YDSGrade("5.15a");

      List<Grade> gradeList = new ArrayList<>();
      gradeList.add(twelveD);
      gradeList.add(thirteenA);
      gradeList.add(thirteenB);
      gradeList.add(thirteenC);
      gradeList.add(thirteenD);
      gradeList.add(fourteenA);
      gradeList.add(fourteenB);
      gradeList.add(fourteenC);
      gradeList.add(fourteenD);
      gradeList.add(fifteenA);

      Collections.sort(gradeList);

      assertEquals("[5.12d, 5.13a, 5.13b, 5.13c, 5.13d, 5.14a, 5.14b, 5.14c, 5.14d, 5.15a]", gradeList.toString());
   }
}