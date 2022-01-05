package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.BoulderSession;
import anderson.reid.climblog.services.SessionClimbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class BoulderSessionControllerTest {

   @Mock
   SessionClimbService<BoulderSession> boulderSessionService;

   @Mock
   Model model;

   @InjectMocks
   BoulderSessionController controller;

   MockMvc mockMvc;

   @BeforeEach
   void setUp() {
      mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
   }

   @Test
   void listBoulderSessionMVCTest() throws Exception {
      mockMvc.perform(get("/log/bouldersession"))
            .andExpect(status().isOk())
            .andExpect(view().name("log/bouldersessions"));
   }

   @Test
   void listBoulderSessionsTest() {
      //given
      BoulderSession bs1 = BoulderSession.builder().id(1L).build();
      BoulderSession bs2 = BoulderSession.builder().id(2L).build();
      List<BoulderSession> boulderSessions = new ArrayList<>();
      boulderSessions.add(bs1);
      boulderSessions.add(bs2);

      //when
      when(boulderSessionService.getSessionClimbs()).thenReturn(boulderSessions);
      ArgumentCaptor<List<BoulderSession>> argumentCaptor = ArgumentCaptor.forClass(List.class);
      String viewName = controller.listBoulderSessions(model);

      //then
      assertEquals("log/bouldersessions", viewName);
      verify(boulderSessionService).getSessionClimbs();
      verify(model).addAttribute(eq("boulderSessions"), argumentCaptor.capture());
      assertEquals(2, argumentCaptor.getValue().size());
   }
}