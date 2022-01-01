package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.Pitch;
import anderson.reid.climblog.services.PitchService;
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

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PitchControllerTest {

   @Mock
   PitchService pitchService;

   @Mock
   Model model;

   @InjectMocks
   PitchController controller;

   @Test
   void mockMVCTest() throws Exception {
      MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
      mockMvc.perform(get("/log/pitches/"))
            .andExpect(status().isOk())
            .andExpect(view().name("log/pitches"));
   }

   @Test
   void listPitches() {
      //given
      Pitch p1 = Pitch.builder().id(1L).build();
      Pitch p2 = Pitch.builder().id(2L).build();
      Set<Pitch> pitches = new HashSet<>();
      pitches.add(p1);
      pitches.add(p2);

      //when
      when(pitchService.getPitches()).thenReturn(pitches);
      ArgumentCaptor<Set<Pitch>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
      String viewName = controller.listPitches(model);

      //then
      assertEquals("log/pitches", viewName);
      verify(pitchService).getPitches();
      verify(model).addAttribute(eq("pitches"), argumentCaptor.capture());
      Set<Pitch> setInController = argumentCaptor.getValue();
      assertEquals(2, setInController.size());
   }
}