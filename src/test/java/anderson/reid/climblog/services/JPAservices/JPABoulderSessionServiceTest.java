package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.sessionclimb.BoulderSession;
import anderson.reid.climblog.exceptions.EmptyListException;
import anderson.reid.climblog.repositories.BoulderSessionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class JPABoulderSessionServiceTest {

   @Mock
   BoulderSessionRepository boulderSessionRepository;

   @InjectMocks
   JPABoulderSessionService service;

   @Test
   void getSessionClimbsTest() {
      BoulderSession bs1 = BoulderSession.builder().id(1L).date(LocalDate.now()).build();
      BoulderSession bs2 = BoulderSession.builder().id(2L).date(LocalDate.now()).build();
      List<BoulderSession> boulderSessions = new ArrayList<>();
      boulderSessions.add(bs1);
      boulderSessions.add(bs2);

      when(boulderSessionRepository.findAll()).thenReturn(boulderSessions);
      List<BoulderSession> returnedSessions = service.getSessionClimbs();

      verify(boulderSessionRepository).findAll();
      assertEquals(2, returnedSessions.size());
   }

   @Test
   void testEmptyList() {
      assertThrows(EmptyListException.class, () -> {
         service.getSessionClimbs();
      });
   }

   @Test
   void testSaveBoulderSession() {
      BoulderSession bs1 = BoulderSession.builder().id(1L).build();

      when(boulderSessionRepository.save(any(BoulderSession.class))).thenReturn(bs1);
      BoulderSession savedBoulderSession = service.save(new BoulderSession());

      verify(boulderSessionRepository).save(any(BoulderSession.class));
      assertEquals(1L, savedBoulderSession.getId());
   }
}