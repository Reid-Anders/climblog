package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.repositories.RouteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JPARouteServiceTest {

   @Mock
   RouteRepository routeRepository;

   @InjectMocks
   JPARouteService routeService;

   @Test
   void getRoutesTest() {
      Set<Route> testRoutes = new HashSet<>();
      testRoutes.add(Route.builder().id(1L).name("Air Test").build());
      testRoutes.add(Route.builder().id(2L).name("Pressure Test").build());

      when(routeRepository.findAll()).thenReturn(testRoutes);

      Set<Route> returnedRoutes = routeService.getClimbs();

      assertNotNull(returnedRoutes);
      assertEquals(2, returnedRoutes.size());
      verify(routeRepository).findAll();
   }

   @Test
   void findRouteByIdTest() {
      Optional<Route> optionalRoute = Optional.ofNullable(Route.builder().id(2L).name("Pressure Test").build());
      when(routeRepository.findById(anyLong())).thenReturn(optionalRoute);

      Route returnedRoute = routeService.findClimbById(2L);

      assertNotNull(returnedRoute);
      assertEquals(2L, returnedRoute.getId());
      assertEquals("Pressure Test", returnedRoute.getName());
   }
}