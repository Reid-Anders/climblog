package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.Boulder;
import anderson.reid.climblog.domain.Grade;
import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.domain.VGrade;
import anderson.reid.climblog.services.ClimbService;
import anderson.reid.climblog.services.GradeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
class BoulderControllerTest {

   @Mock
   ClimbService<Boulder> boulderService;

   @Mock
   GradeService<VGrade> gradeService;

   @Mock
   Model model;

   @InjectMocks
   BoulderController controller;

   MockMvc mockMvc;

   @BeforeEach
   void setUp() {
      mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
   }

   @Test
   void listBouldersMVCTest() throws Exception {
      //why does /climbs/routes/ work but not just /climbs/routes? it works in practice, but the test doesn't pass
      mockMvc.perform(get("/climbs/boulder/"))
            .andExpect(status().isOk())
            .andExpect(view().name("climbs/boulders"));
   }

   @Test
   void createBoulderMVCTest() throws Exception {
      mockMvc.perform(get("/climbs/boulder/create"))
            .andExpect(status().isOk())
            .andExpect(view().name("create/create_boulder"));
   }

   @Test
   void saveOrUpdateBoulderMVCTest() throws Exception {
      mockMvc.perform(post("/climbs/boulder/new_boulder"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/climbs/boulders"));
   }

   @Test
   void listRoutesTest() {
      Boulder r1 = Boulder.builder().id(1L).build();
      Boulder r2 = Boulder.builder().id(2L).build();
      List<Boulder> boulders = new ArrayList<>();
      boulders.add(r1);
      boulders.add(r2);

      when(boulderService.getClimbs()).thenReturn(boulders);

      ArgumentCaptor<List<Boulder>> argumentCaptor = ArgumentCaptor.forClass(List.class);


      String viewName = controller.listBoulders(model);


      assertEquals("climbs/boulders", viewName);
      verify(boulderService).getClimbs();
      verify(model).addAttribute(eq("boulders"), argumentCaptor.capture());
      List<Boulder> setInController = argumentCaptor.getValue();
      assertEquals(2, setInController.size());
   }

   @Test
   void createBoulderTest() {
      //given
      VGrade g1 = new VGrade("v1");
      VGrade g2 = new VGrade("v2");
      List<VGrade> grades = new ArrayList<>();
      grades.add(g1);
      grades.add(g2);

      //when
      when(gradeService.getGrades()).thenReturn(grades);
      String viewName = controller.createBoulder(model);
      ArgumentCaptor<List<Grade>> argumentCaptor = ArgumentCaptor.forClass(List.class);

      //then
      assertEquals("create/create_boulder", viewName);
      verify(model).addAttribute(eq("boulder"), any(Boulder.class));
      verify(model).addAttribute(eq("grades"), argumentCaptor.capture());
      List<Grade> listInController = argumentCaptor.getValue();
      assertEquals(2, listInController.size());
   }

   @Test
   void saveNewRouteTest() {
      //given
      Boulder boulder = Boulder.builder().id(1L).build();

      //when
      when(boulderService.save(any(Boulder.class))).thenReturn(boulder);
      String viewName = controller.saveOrUpdateBoulder(new Boulder());

      //then
      assertEquals("redirect:/climbs/boulders", viewName);
   }
}