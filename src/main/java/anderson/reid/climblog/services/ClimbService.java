package anderson.reid.climblog.services;

import anderson.reid.climblog.domain.Climb;

import java.util.Set;

public interface ClimbService<T> {

   Set<T> getClimbs();
   T findClimbById(Long id);
}
