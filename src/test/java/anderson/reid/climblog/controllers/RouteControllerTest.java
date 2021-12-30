package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.services.ClimbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RouteControllerTest {

   @Mock
   ClimbService<Route> routeService;

   @Mock
   Model model;

   @InjectMocks
   RouteController controller;

   @Test
   void mockMVCTest() throws Exception {
      MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
      //why does /climbs/routes/ work but not just /climbs/routes? it works in practice, but the test doesn't pass
      mockMvc.perform(get("/climbs/routes/"))
            .andExpect(status().isOk())
            .andExpect(view().name("routes"));
   }

   @Test
   void listRoutesTest() {
      Route r1 = Route.builder().id(1L).build();
      Route r2 = Route.builder().id(2L).build();
      Set<Route> routes = new HashSet<>();
      routes.add(r1);
      routes.add(r2);

      when(routeService.getClimbs()).thenReturn(routes);

      ArgumentCaptor<Set<Route>> argumentCaptor = ArgumentCaptor.forClass(Set.class);


      String viewName = controller.listRoutes(model);


      assertEquals("routes", viewName);
      verify(routeService).getClimbs();
      verify(model).addAttribute(eq("routes"), argumentCaptor.capture());
      Set<Route> setInController = argumentCaptor.getValue();
      assertEquals(2, setInController.size());
   }
}