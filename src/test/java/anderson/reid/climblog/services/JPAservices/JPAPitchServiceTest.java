package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Pitch;
import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.repositories.PitchRepository;
import anderson.reid.climblog.repositories.RouteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JPAPitchServiceTest {

   @Mock
   PitchRepository pitchRepository;

   @Mock
   RouteRepository routeRepository;

   @InjectMocks
   JPAPitchService service;

   @Test
   void getSessionClimbsTest() {
      //given
      Pitch p1 = Pitch.builder().id(1L).build();
      Pitch p2 = Pitch.builder().id(2L).build();
      List<Pitch> pitches = new ArrayList<>();
      pitches.add(p1);
      pitches.add(p2);

      //when
      when(pitchRepository.findAll()).thenReturn(pitches);
      List<Pitch> returnedPitches = service.getSessionClimbs();

      //then
      assertEquals(2, returnedPitches.size());
      verify(pitchRepository).findAll();
   }
}