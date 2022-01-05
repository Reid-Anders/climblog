package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Boulder;
import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.domain.VGrade;
import anderson.reid.climblog.exceptions.EmptyListException;
import anderson.reid.climblog.repositories.BoulderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JPABoulderServiceTest {

   @Mock
   BoulderRepository boulderRepository;

   @InjectMocks
   JPABoulderService boulderService;

   @Test
   void getBouldersTest() {
      Set<Boulder> testBoulders = new HashSet<>();
      testBoulders.add(Boulder.builder().id(1L).grade(new VGrade("V0")).build());
      testBoulders.add(Boulder.builder().id(2L).grade(new VGrade("V1")).build());

      when(boulderRepository.findAll()).thenReturn(testBoulders);

      List<Boulder> returnedRoutes = boulderService.getClimbs();

      assertNotNull(returnedRoutes);
      assertEquals(2, returnedRoutes.size());
      verify(boulderRepository).findAll();
   }

   @Test
   void findRouteByIdTest() {
      Optional<Boulder> optionalBoulder = Optional.ofNullable(Boulder.builder().id(2L).name("Baby Cthulhu").build());
      when(boulderRepository.findById(anyLong())).thenReturn(optionalBoulder);

      Boulder returnedBoulder = boulderService.findClimbById(2L);

      assertNotNull(returnedBoulder);
      assertEquals(2L, returnedBoulder.getId());
      assertEquals("Baby Cthulhu", returnedBoulder.getName());
   }

   @Test
   void testEmptyList() {
      assertThrows(EmptyListException.class, () -> {
         boulderService.getClimbs();
      });
   }
}