package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.services.ClimbService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/climbs/routes")
@Controller
public class RouteController {

   private final ClimbService<Route> routeService;

   public RouteController(ClimbService<Route> routeService) {
      this.routeService = routeService;
   }

   @RequestMapping({"", "/"})
   public String listRoutes(Model model) {
      model.addAttribute("routes", routeService.getClimbs());
      return "routes";
   }
}
