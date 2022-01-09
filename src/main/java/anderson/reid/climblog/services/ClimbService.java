package anderson.reid.climblog.services;

import anderson.reid.climblog.domain.climb.Climb;

import java.util.List;

public interface ClimbService<T extends Climb> {

   List<T> getClimbs();
   T findClimbById(Long id);
   T save(T climb);
   void deleteById(Long id);
}
