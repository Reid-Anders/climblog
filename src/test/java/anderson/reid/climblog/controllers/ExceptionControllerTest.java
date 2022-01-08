package anderson.reid.climblog.controllers;

import anderson.reid.climblog.exceptions.EmptyListException;
import anderson.reid.climblog.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ExceptionControllerTest {

   @Mock
   Model model;

   @InjectMocks
   ExceptionController controller;

   MockMvc mockMvc;

   @BeforeEach
   void setUp() {
      mockMvc = MockMvcBuilders.standaloneSetup().build();
   }

   @Test
   void handleEmptyListTest() {
      String viewName = controller.handleEmptyList(model, new EmptyListException());

      verify(model).addAttribute(eq("exception"), any(EmptyListException.class));
      assertEquals("exceptions/emptylist", viewName);
   }

   @Test
   void handleEntityNotFoundTest() {
      String viewName = controller.handleEntityNotFound(model, new EntityNotFoundException());

      verify(model).addAttribute(eq("exception"), any(EntityNotFoundException.class));
      assertEquals("exceptions/entity_not_found", viewName);
   }
}