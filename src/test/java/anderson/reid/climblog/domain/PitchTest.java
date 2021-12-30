package anderson.reid.climblog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
      pitch = Pitch.builder().route(ROUTE).date(DATE).partner(PARTNER).type(TYPE).notes(NOTES).build();
   }

   @Test
   void testPitch() {
      assertEquals(ROUTE, pitch.getRoute());
      assertEquals(DATE, pitch.getDate());
      assertEquals(PARTNER, pitch.getPartner());
      assertEquals(TYPE, pitch.getType());
      assertEquals(NOTES, pitch.getNotes());
   }
}