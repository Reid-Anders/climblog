package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.BoulderSession;
import anderson.reid.climblog.repositories.BoulderSessionRepository;
import anderson.reid.climblog.services.SessionClimbService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/log/bouldersessions")
@Controller
public class BoulderSessionController {

   private final SessionClimbService<BoulderSession> boulderSessionService;

   public BoulderSessionController(SessionClimbService<BoulderSession> boulderSessionService) {
      this.boulderSessionService = boulderSessionService;
   }

   @GetMapping({"", "/"})
   public String listBoulderSessions(Model model) {
      model.addAttribute("boulderSessions", boulderSessionService.getSessionClimbs());
      return "log/bouldersessions";
   }
}
