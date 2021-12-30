package anderson.reid.climblog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoulderTest {

   final static String NAME = "Baby Cthulhu";
   final static String SECTOR = "Burning Man";
   final static String AREA = "Boulderfields";
   final static Grade GRADE = new VGrade("V7");
   final static char STATUS = 'R';

   Boulder boulder;

   @BeforeEach
   void setUp() {
      boulder = Boulder.builder()
            .name(NAME)
            .sector(SECTOR)
            .area(AREA)
            .grade(GRADE)
            .status(STATUS)
            .build();
   }

   @Test
   void testBoulder() {
      assertEquals(NAME, boulder.getName());
      assertEquals(SECTOR, boulder.getSector());
      assertEquals(AREA, boulder.getArea());
      assertEquals(GRADE, boulder.getGrade());
      assertEquals(STATUS, boulder.getStatus());
   }

}