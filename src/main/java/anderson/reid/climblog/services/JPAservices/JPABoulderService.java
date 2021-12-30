package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Boulder;
import anderson.reid.climblog.repositories.BoulderRepository;
import anderson.reid.climblog.services.ClimbService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JPABoulderService implements ClimbService<Boulder> {

   private final BoulderRepository boulderRepository;

   public JPABoulderService(BoulderRepository boulderRepository) {
      this.boulderRepository = boulderRepository;
   }

   @Override
   public Set<Boulder> getClimbs() {
      Set<Boulder> boulders = new HashSet<>();
      boulderRepository.findAll().iterator().forEachRemaining(boulders::add);
      return boulders;
   }

   @Override
   public Boulder findClimbById(Long id) {
      Optional<Boulder> optionalBoulder = boulderRepository.findById(id);
      return optionalBoulder.orElse(null);
   }
}
