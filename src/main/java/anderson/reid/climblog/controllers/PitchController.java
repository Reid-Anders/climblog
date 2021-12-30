package anderson.reid.climblog.controllers;

import anderson.reid.climblog.services.PitchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO: write test for pitchcontroller
@RequestMapping("/pitches")
@Controller
public class PitchController {

   private final PitchService pitchService;

   public PitchController(PitchService pitchService) {
      this.pitchService = pitchService;
   }

   @RequestMapping({"", "/"})
   public String listPitches(Model model) {
      model.addAttribute("pitches", pitchService.getPitches());
      return "pitches";
   }
}
