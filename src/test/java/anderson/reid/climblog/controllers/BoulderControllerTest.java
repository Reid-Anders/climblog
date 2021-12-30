package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.Boulder;
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
class BoulderControllerTest {

   @Mock
   ClimbService<Boulder> boulderService;

   @Mock
   Model model;

   @InjectMocks
   BoulderController controller;

   @Test
   void mockMVCTest() throws Exception {
      MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
      //why does /climbs/routes/ work but not just /climbs/routes? it works in practice, but the test doesn't pass
      mockMvc.perform(get("/climbs/boulders/"))
            .andExpect(status().isOk())
            .andExpect(view().name("boulders"));
   }

   @Test
   void listRoutesTest() {
      Boulder r1 = Boulder.builder().id(1L).build();
      Boulder r2 = Boulder.builder().id(2L).build();
      Set<Boulder> boulders = new HashSet<>();
      boulders.add(r1);
      boulders.add(r2);

      when(boulderService.getClimbs()).thenReturn(boulders);

      ArgumentCaptor<Set<Boulder>> argumentCaptor = ArgumentCaptor.forClass(Set.class);


      String viewName = controller.listBoulders(model);


      assertEquals("boulders", viewName);
      verify(boulderService).getClimbs();
      verify(model).addAttribute(eq("boulders"), argumentCaptor.capture());
      Set<Boulder> setInController = argumentCaptor.getValue();
      assertEquals(2, setInController.size());
   }
}