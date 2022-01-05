package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.BoulderSession;
import anderson.reid.climblog.exceptions.EmptyListException;
import anderson.reid.climblog.repositories.BoulderSessionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JPABoulderSessionServiceTest {

   @Mock
   BoulderSessionRepository boulderSessionRepository;

   @InjectMocks
   JPABoulderSessionService service;

   @Test
   void getSessionClimbsTest() {
      BoulderSession bs1 = BoulderSession.builder().id(1L).build();
      BoulderSession bs2 = BoulderSession.builder().id(2L).build();
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
}