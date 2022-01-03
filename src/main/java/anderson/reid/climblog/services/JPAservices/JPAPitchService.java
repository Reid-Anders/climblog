package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Pitch;
import anderson.reid.climblog.repositories.PitchRepository;
import anderson.reid.climblog.services.SessionClimbService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JPAPitchService implements SessionClimbService<Pitch> {

   private final PitchRepository pitchRepository;

   public JPAPitchService(PitchRepository pitchRepository) {
      this.pitchRepository = pitchRepository;
   }

   @Override
   public List<Pitch> getSessionClimbs() {
      List<Pitch> pitches = new ArrayList<>();
      pitchRepository.findAll().iterator().forEachRemaining(pitches::add);
      return pitches;
   }

   @Override
   public Pitch save(Pitch sessionClimb) {
      return pitchRepository.save(sessionClimb);
   }
}
