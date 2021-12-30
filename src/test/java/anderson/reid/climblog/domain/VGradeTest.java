package anderson.reid.climblog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VGradeTest {

   Grade grade;

   @BeforeEach
   void setUp() {
      grade = new VGrade("V8");
   }

   @Test
   void testToString() {
      assertEquals("V8", grade.toString());
   }

   @Test
   void testIncrement() {
      grade.increment();
      grade.increment();
      grade.increment();
      grade.increment();

      assertEquals("V12", grade.toString());
   }

   @Test
   void testDecrement() {
      grade.decrement();

      assertEquals("V7", grade.toString());
   }
}