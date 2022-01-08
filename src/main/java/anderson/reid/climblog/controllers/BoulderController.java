package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.climb.Boulder;
import anderson.reid.climblog.domain.grade.VGrade;
import anderson.reid.climblog.services.ClimbService;
import anderson.reid.climblog.services.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/climbs/boulder")
@Controller
public class BoulderController {

   private final ClimbService<Boulder> boulderService;
   private final GradeService<VGrade> gradeService;

   public BoulderController(ClimbService<Boulder> boulderService, GradeService<VGrade> gradeService) {
      this.boulderService = boulderService;
      this.gradeService = gradeService;
   }

   @RequestMapping({"", "/"})
   public String listBoulders(Model model) {
      model.addAttribute("boulders", boulderService.getClimbs());
      return "climbs/boulders";
   }

   @GetMapping("/create")
   public String createBoulder(Model model) {
      model.addAttribute("grades", gradeService.getGrades());
      model.addAttribute("boulder", new Boulder());
      return "create/create_boulder";
   }

   @PostMapping("/new_boulder")
   public String saveOrUpdateBoulder(@ModelAttribute Boulder boulder) {
      boulderService.save(boulder);
      return "redirect:/climbs/boulder";
   }
}
