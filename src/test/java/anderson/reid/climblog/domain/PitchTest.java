package anderson.reid.climblog.domain;

import anderson.reid.climblog.domain.climb.Route;
import anderson.reid.climblog.domain.grade.YDSGrade;
import anderson.reid.climblog.domain.sessionclimb.Pitch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PitchTest {

   final static Route ROUTE = Route.builder()
         .name("Air Test")
         .sector("Doctor's Wall")
         .area("Skaha Bluffs")
         .grade(new YDSGrade("5.13a"))
         .status('R')
         .build();
   final static LocalDate DATE = LocalDate.now();
   final static String PARTNER = "Landon Orr";
   final static char TYPE = 'R';
   final static String NOTES = "really good";

   Pitch pitch;

   @BeforeEach
   void setUp() {
      pitch = Pitch.builder()
            .climb(ROUTE)
            .date(DATE)
            .partner(PARTNER)
            .type(TYPE)
            .notes(NOTES)
            .build();
   }

   @Test
   void testPitch() {
      assertEquals(ROUTE, pitch.getClimb());
      assertEquals(DATE, pitch.getDate());
      assertEquals(PARTNER, pitch.getPartner());
      assertEquals(TYPE, pitch.getType());
      assertEquals(NOTES, pitch.getNotes());
   }

   @Test
   void testSortPitches() {
      Pitch p1 = Pitch.builder()
            .climb(Route.builder().id(1L).grade(new YDSGrade("5.12a")).build())
            .date(LocalDate.MIN)
            .build();

      Pitch p2 = Pitch.builder()
            .climb(Route.builder().id(2L).grade(new YDSGrade("5.15a")).build())
            .date(LocalDate.MAX)
            .build();

      List<Pitch> pitchList = new ArrayList<>();
      pitchList.add(p2);
      pitchList.add(pitch);
      pitchList.add(p1);

      Collections.sort(pitchList);

      assertEquals("[null, 5.15a on " + LocalDate.MAX + ", Air Test, 5.13a on " + LocalDate.now() +
            ", null, 5.12a on " + LocalDate.MIN + "]", pitchList.toString());
   }
}