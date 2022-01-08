package anderson.reid.climblog.domain;

import anderson.reid.climblog.domain.climb.Route;
import anderson.reid.climblog.domain.grade.YDSGrade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {

   final static String NAME = "Air Test";
   final static String SECTOR = "Doctor's Wall";
   final static String AREA = "Skaha Bluffs";
   final static YDSGrade GRADE = new YDSGrade("5.13a");
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
   void testSort() {
      Route r1 = Route.builder().name("Apricot Jam").grade(new YDSGrade("5.12b")).build();
      Route r2 = Route.builder().name("Nurse Minitweak").grade(new YDSGrade("5.12b")).build();
      List<Route> routes = new ArrayList<>();
      routes.add(route);
      routes.add(r1);
      routes.add(r2);

      Collections.sort(routes);

      assertEquals("[Apricot Jam, 5.12b, Nurse Minitweak, 5.12b, Air Test, 5.13a]", routes.toString());
   }
}