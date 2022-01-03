package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.Grade;
import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.domain.YDSGrade;
import anderson.reid.climblog.services.ClimbService;
import anderson.reid.climblog.services.GradeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RouteControllerTest {

   @Mock
   ClimbService<Route> routeService;

   @Mock
   GradeService<YDSGrade> gradeService;

   @Mock
   Model model;

   @InjectMocks
   RouteController controller;

   MockMvc mockMvc;

   @BeforeEach
   void setUp() {
      mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
   }

   @Test
   void listRoutesMVCTest() throws Exception {
      //why does /climbs/routes/ work but not just /climbs/routes? it works in practice, but the test doesn't pass
      mockMvc.perform(get("/climbs/routes/"))
            .andExpect(status().isOk())
            .andExpect(view().name("climbs/routes"));
   }

   @Test
   void createRouteMVCTest() throws Exception {
      mockMvc.perform(get("/climbs/routes/create"))
            .andExpect(status().isOk())
            .andExpect(view().name("create/create_route"));
   }

   @Test
   void saveOrUpdateMVCTest() throws Exception {
      mockMvc.perform(post("/climbs/routes/new_route"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/climbs/routes"));
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


      assertEquals("climbs/routes", viewName);
      verify(routeService).getClimbs();
      verify(model).addAttribute(eq("routes"), argumentCaptor.capture());
      Set<Route> setInController = argumentCaptor.getValue();
      assertEquals(2, setInController.size());
   }

   @Test
   void createRouteTest() {
      //given
      YDSGrade g1 = new YDSGrade("5.12a");
      YDSGrade g2 = new YDSGrade("5.12b");
      List<YDSGrade> grades = new ArrayList<>();
      grades.add(g1);
      grades.add(g2);

      //when
      when(gradeService.getGrades()).thenReturn(grades);
      String viewName = controller.createRoute(model);
      ArgumentCaptor<List<Grade>> argumentCaptor = ArgumentCaptor.forClass(List.class);

      //then
      assertEquals("create/create_route", viewName);
      verify(model).addAttribute(eq("route"), any(Route.class));
      verify(model).addAttribute(eq("grades"), argumentCaptor.capture());
      List<Grade> listInController = argumentCaptor.getValue();
      assertEquals(2, listInController.size());
   }

   @Test
   void saveNewRouteTest() {
      //given
      Route route = Route.builder().id(1L).build();

      //when
      when(routeService.save(any(Route.class))).thenReturn(route);
      String viewName = controller.saveOrUpdate(new Route());

      //then
      assertEquals("redirect:/climbs/routes", viewName);
   }
}