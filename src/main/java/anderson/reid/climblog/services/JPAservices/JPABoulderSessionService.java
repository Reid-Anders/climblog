package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.BoulderSession;
import anderson.reid.climblog.exceptions.EmptyListException;
import anderson.reid.climblog.repositories.BoulderSessionRepository;
import anderson.reid.climblog.services.SessionClimbService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class JPABoulderSessionService implements SessionClimbService<BoulderSession> {

   private final BoulderSessionRepository boulderSessionRepository;

   public JPABoulderSessionService(BoulderSessionRepository boulderSessionRepository) {
      this.boulderSessionRepository = boulderSessionRepository;
   }

   @Override
   public List<BoulderSession> getSessionClimbs() {
      List<BoulderSession> boulderSessions = new ArrayList<>();
      boulderSessionRepository.findAll().iterator().forEachRemaining(boulderSessions::add);

      if(boulderSessions.isEmpty()) {
         throw new EmptyListException("-- No boulder sessions found! --", "Boulder Sessions", "/log/bouldersession");
      }

      Collections.sort(boulderSessions);

      return boulderSessions;
   }

   @Override
   public BoulderSession save(BoulderSession sessionClimb) {
      return boulderSessionRepository.save(sessionClimb);
   }
}
