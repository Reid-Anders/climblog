package anderson.reid.climblog.domain;

import anderson.reid.climblog.domain.climb.Boulder;
import anderson.reid.climblog.domain.grade.VGrade;
import anderson.reid.climblog.domain.sessionclimb.BoulderSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoulderSessionTest {

   final static Boulder BOULDER = Boulder.builder().name("Baby Cthulhu")
         .sector("Burning Man")
         .area("Boulderfields")
         .grade(new VGrade("V7"))
         .status('R')
         .build();
   final static Integer ATTEMPTS = 15;
   final static String SPOTTERS = "Landon Orr";
   final static LocalDate DATE = LocalDate.now();
   final static char TYPE = 'R';
   final static String NOTES = "Great climb";

   BoulderSession boulderSession;

   @BeforeEach
   void setUp() {
      boulderSession = BoulderSession.builder()
            .climb(BOULDER)
            .attempts(ATTEMPTS)
            .spotters(SPOTTERS)
            .date(DATE)
            .type(TYPE)
            .notes(NOTES)
            .build();
   }

   @Test
   void testBoulderSession() {
      assertEquals(BOULDER, boulderSession.getClimb());
      assertEquals(ATTEMPTS, boulderSession.getAttempts());
      assertEquals(SPOTTERS, boulderSession.getSpotters());
      assertEquals(DATE, boulderSession.getDate());
      assertEquals(TYPE, boulderSession.getType());
      assertEquals(NOTES, boulderSession.getNotes());
   }

   @Test
   void testSortPitches() {
      BoulderSession bs1 = BoulderSession.builder()
            .climb(Boulder.builder().id(1L).grade(new VGrade("V0")).build())
            .date(LocalDate.MIN)
            .build();

      BoulderSession bs2 = BoulderSession.builder()
            .climb(Boulder.builder().id(2L).grade(new VGrade("V10")).build())
            .date(LocalDate.MAX)
            .build();

      List<BoulderSession> boulderList = new ArrayList<>();
      boulderList.add(bs2);
      boulderList.add(boulderSession);
      boulderList.add(bs1);

      Collections.sort(boulderList);

      assertEquals("[null, V10 on " + LocalDate.MAX + ", Baby Cthulhu, V7 on " + LocalDate.now() +
            ", null, V0 on " + LocalDate.MIN + "]", boulderList.toString());
   }
}