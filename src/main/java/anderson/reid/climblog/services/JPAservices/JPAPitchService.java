package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Pitch;
import anderson.reid.climblog.exceptions.EmptyListException;
import anderson.reid.climblog.repositories.PitchRepository;
import anderson.reid.climblog.repositories.RouteRepository;
import anderson.reid.climblog.services.SessionClimbService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JPAPitchService implements SessionClimbService<Pitch> {

   private final PitchRepository pitchRepository;
   private final RouteRepository routeRepository;

   public JPAPitchService(PitchRepository pitchRepository, RouteRepository routeRepository) {
      this.pitchRepository = pitchRepository;
      this.routeRepository = routeRepository;
   }

   @Override
   public List<Pitch> getSessionClimbs() {
      List<Pitch> pitches = new ArrayList<>();
      pitchRepository.findAll().iterator().forEachRemaining(pitches::add);

      if(pitches.isEmpty()) {
         throw new EmptyListException("-- No pitches found! --", "Pitches", "/log/pitch");
      }

      return pitches;
   }

   @Override
   public Pitch save(Pitch sessionClimb) {
      sessionClimb.getRoute().updateStatus(sessionClimb.getType());
      routeRepository.save(sessionClimb.getRoute());
      return pitchRepository.save(sessionClimb);
   }
}
