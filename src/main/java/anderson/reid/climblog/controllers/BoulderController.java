package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.Boulder;
import anderson.reid.climblog.services.ClimbService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/climbs/boulders")
@Controller
public class BoulderController {

   private final ClimbService<Boulder> boulderService;

   public BoulderController(ClimbService<Boulder> boulderService) {
      this.boulderService = boulderService;
   }

   @RequestMapping({"", "/"})
   public String listBoulders(Model model) {
      model.addAttribute("boulders", boulderService.getClimbs());
      return "boulders";
   }
}
