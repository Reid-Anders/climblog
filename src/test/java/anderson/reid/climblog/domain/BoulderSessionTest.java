package anderson.reid.climblog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
            .boulder(BOULDER)
            .attempts(ATTEMPTS)
            .spotters(SPOTTERS)
            .date(DATE)
            .type(TYPE)
            .notes(NOTES)
            .build();
   }

   @Test
   void testBoulderSession() {
      assertEquals(BOULDER, boulderSession.getBoulder());
      assertEquals(ATTEMPTS, boulderSession.getAttempts());
      assertEquals(SPOTTERS, boulderSession.getSpotters());
      assertEquals(DATE, boulderSession.getDate());
      assertEquals(TYPE, boulderSession.getType());
      assertEquals(NOTES, boulderSession.getNotes());
   }
}