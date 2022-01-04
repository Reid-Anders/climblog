package anderson.reid.climblog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

   @Test
   void testSort() {
      Boulder r1 = Boulder.builder().name("V Power").grade(new VGrade("V7")).build();
      Boulder r2 = Boulder.builder().name("4 Horsemen").grade(new VGrade("V5")).build();
      List<Boulder> boulders = new ArrayList<>();
      boulders.add(boulder);
      boulders.add(r1);
      boulders.add(r2);

      Collections.sort(boulders);

      assertEquals("[4 Horsemen, V5, Baby Cthulhu, V7, V Power, V7]", boulders.toString());
   }

}