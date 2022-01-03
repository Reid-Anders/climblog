package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Pitch;
import anderson.reid.climblog.repositories.PitchRepository;
import anderson.reid.climblog.services.PitchService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JPAPitchService implements PitchService {

   private final PitchRepository pitchRepository;

   public JPAPitchService(PitchRepository pitchRepository) {
      this.pitchRepository = pitchRepository;
   }

   @Override
   public Set<Pitch> getPitches() {
      Set<Pitch> pitches = new HashSet<>();
      pitchRepository.findAll().iterator().forEachRemaining(pitches::add);
      return pitches;
   }

   @Override
   public Pitch save(Pitch pitch) {
      return pitchRepository.save(pitch);
   }
}
