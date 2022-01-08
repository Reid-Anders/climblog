package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.sessionclimb.Pitch;
import anderson.reid.climblog.domain.climb.Route;
import anderson.reid.climblog.services.ClimbService;
import anderson.reid.climblog.services.SessionClimbService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("log/pitch")
@Controller
public class PitchController {

   private final SessionClimbService<Pitch> pitchService;
   private final ClimbService<Route> routeService;

   public PitchController(SessionClimbService<Pitch> pitchService, ClimbService<Route> routeService) {
      this.pitchService = pitchService;
      this.routeService = routeService;
   }

   @RequestMapping({"", "/"})
   public String listPitches(Model model) {
      model.addAttribute("pitches", pitchService.getSessionClimbs());
      return "log/pitches";
   }

   @GetMapping("/create")
   public String createPitch(Model model) {
      model.addAttribute("routes", routeService.getClimbs());
      model.addAttribute("pitch", new Pitch());
      return "create/create_pitch";
   }

   @PostMapping("/new_pitch")
   public String saveOrUpdatePitch(@ModelAttribute Pitch pitch) {
      pitchService.save(pitch);
      return "redirect:/log/pitch";
   }
}
