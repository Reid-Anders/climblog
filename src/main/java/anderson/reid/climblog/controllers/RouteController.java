package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.domain.YDSGrade;
import anderson.reid.climblog.services.ClimbService;
import anderson.reid.climblog.services.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/climbs/route")
@Controller
public class RouteController {

   private final ClimbService<Route> routeService;
   private final GradeService<YDSGrade> gradeService;

   public RouteController(ClimbService<Route> routeService, GradeService<YDSGrade> gradeService) {
      this.routeService = routeService;
      this.gradeService = gradeService;
   }

   @RequestMapping({"", "/"})
   public String listRoutes(Model model) {
      model.addAttribute("routes", routeService.getClimbs());
      return "climbs/routes";
   }

   @RequestMapping("/create")
   public String createRoute(Model model) {
      model.addAttribute("grades", gradeService.getGrades());
      model.addAttribute("route", new Route());
      return "create/create_route";
   }

   @PostMapping("/new_route")
   public String saveOrUpdateRoute(@ModelAttribute Route route) {
      routeService.save(route);
      return "redirect:/climbs/route";
   }
}
