package anderson.reid.climblog.controllers;

import anderson.reid.climblog.exceptions.EmptyListException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

   @ExceptionHandler(EmptyListException.class)
   public String handleEmptyList(Model model, Exception exception) {
      model.addAttribute("exception", exception);
      return "exceptions/emptylist";
   }
}
