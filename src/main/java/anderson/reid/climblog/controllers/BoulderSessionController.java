package anderson.reid.climblog.controllers;

import anderson.reid.climblog.domain.climb.Boulder;
import anderson.reid.climblog.domain.sessionclimb.BoulderSession;
import anderson.reid.climblog.exceptions.EntityNotFoundException;
import anderson.reid.climblog.services.ClimbService;
import anderson.reid.climblog.services.SessionClimbService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/log/bouldersession")
@Controller
public class BoulderSessionController {

   private final SessionClimbService<BoulderSession> boulderSessionService;
   private final ClimbService<Boulder> boulderService;

   public BoulderSessionController(SessionClimbService<BoulderSession> boulderSessionService, ClimbService<Boulder> boulderService) {
      this.boulderSessionService = boulderSessionService;
      this.boulderService = boulderService;
   }

   @GetMapping({"", "/"})
   public String listBoulderSessions(Model model) {
      model.addAttribute("boulderSessions", boulderSessionService.getSessionClimbs());
      return "log/bouldersessions";
   }

   @GetMapping("/create")
   public String createBoulderSession(Model model) {
      model.addAttribute("boulders", boulderService.getClimbs());
      model.addAttribute("boulderSession", new BoulderSession());
      return "create/create_bouldersession";
   }

   @PostMapping("/new_bouldersession")
   public String saveOrUpdateBoulderSession(@ModelAttribute BoulderSession boulderSession) {
      boulderSessionService.save(boulderSession);
      return "redirect:/log/bouldersession";
   }

   @GetMapping("/{id}/edit")
   public String editBoulderSession(@PathVariable String id, Model model) {
      BoulderSession bs = boulderSessionService.findClimbSessionById(Long.parseLong(id));

      if(bs == null) {
         throw new EntityNotFoundException("Boulder Session", id);
      }

      model.addAttribute("boulderSession", bs);
      model.addAttribute("boulders", boulderService.getClimbs());
      return "create/create_bouldersession";
   }

   @GetMapping("/{id}/delete")
   public String deleteBoulderSession(@PathVariable String id) {
      boulderSessionService.deleteById(Long.parseLong(id));
      return "redirect:/log/bouldersession";
   }
}
