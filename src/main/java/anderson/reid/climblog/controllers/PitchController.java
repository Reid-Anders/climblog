package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.sessionclimb.Pitch;
import anderson.reid.climblog.domain.climb.Route;
import anderson.reid.climblog.exceptions.EntityNotFoundException;
import anderson.reid.climblog.services.ClimbService;
import anderson.reid.climblog.services.SessionClimbService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

   @GetMapping("/{id}/edit")
   public String editPitch(@PathVariable String id, Model model) {
      Pitch pitch = pitchService.findClimbSessionById(Long.parseLong(id));

      if(pitch == null) {
         throw new EntityNotFoundException("Pitch", id);
      }

      model.addAttribute("pitch", pitch);
      model.addAttribute("routes", routeService.getClimbs());
      return "create/create_pitch";
   }

   @GetMapping("/{id}/delete")
   public String deletePitch(@PathVariable String id) {
      pitchService.deleteById(Long.parseLong(id));
      return "redirect:/log/pitch";
   }
}
