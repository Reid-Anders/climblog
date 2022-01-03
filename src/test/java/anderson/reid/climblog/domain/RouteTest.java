package anderson.reid.climblog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {

   final static String NAME = "Air Test";
   final static String SECTOR = "Doctor's Wall";
   final static String AREA = "Skaha Bluffs";
   final static Grade GRADE = new YDSGrade("5.13a");
   final static char STATUS = 'R';
   final static Integer LENGTH = 30;

   Route route;

   @BeforeEach
   void setUp() {
      route = Route.builder()
            .name(NAME)
            .sector(SECTOR)
            .area(AREA)
            .grade(GRADE)
            .status(STATUS)
            .length(LENGTH)
            .build();
   }

   @Test
   void testRoute() {
      assertEquals(NAME, route.getName());
      assertEquals(SECTOR, route.getSector());
      assertEquals(AREA, route.getArea());
      assertEquals(GRADE, route.getGrade());
      assertEquals(STATUS, route.getStatus());
      assertEquals(LENGTH, route.getLength());
   }

   @Test
   void testStatusChange() {

   }
}