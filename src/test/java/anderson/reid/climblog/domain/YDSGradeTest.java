package anderson.reid.climblog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}