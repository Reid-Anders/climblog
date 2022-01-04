package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Boulder;
import anderson.reid.climblog.repositories.BoulderRepository;
import anderson.reid.climblog.services.ClimbService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JPABoulderService implements ClimbService<Boulder> {

   private final BoulderRepository boulderRepository;

   public JPABoulderService(BoulderRepository boulderRepository) {
      this.boulderRepository = boulderRepository;
   }

   @Override
   public List<Boulder> getClimbs() {
      List<Boulder> boulders = new ArrayList<>();
      boulderRepository.findAll().iterator().forEachRemaining(boulders::add);
      Collections.sort(boulders);
      return boulders;
   }

   @Override
   public Boulder findClimbById(Long id) {
      Optional<Boulder> optionalBoulder = boulderRepository.findById(id);
      return optionalBoulder.orElse(null);
   }

   @Override
   public Boulder save(Boulder climb) {
      return boulderRepository.save(climb);
   }
}
