package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.Pitch;
import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.services.ClimbService;
import anderson.reid.climblog.services.PitchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@RequestMapping("/log/pitches")
@Controller
public class PitchController {

   private final PitchService pitchService;
   private final ClimbService<Route> routeService;

   public PitchController(PitchService pitchService, ClimbService<Route> routeService) {
      this.pitchService = pitchService;
      this.routeService = routeService;
   }

   @RequestMapping({"", "/"})
   public String listPitches(Model model) {
      model.addAttribute("pitches", pitchService.getPitches());
      return "log/pitches";
   }

   @GetMapping("/create")
   public String createPitch(Model model) {
      model.addAttribute("routes", routeService.getClimbs());
      model.addAttribute("pitch", new Pitch());
      return "create/create_pitch";
   }

   //todo: write tests for this before committal
   @PostMapping("/new_pitch")
   public String saveOrUpdatePitch(@ModelAttribute Pitch pitch) {
      pitchService.save(pitch);
      return "redirect:/log/pitches";
   }
}
