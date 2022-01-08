package anderson.reid.climblog.services;

import anderson.reid.climblog.domain.sessionclimb.SessionClimb;

import java.util.List;

public interface SessionClimbService<T extends SessionClimb> {

   List<T> getSessionClimbs();
   T save(T sessionClimb);
}
