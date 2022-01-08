package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.climb.Route;
import anderson.reid.climblog.exceptions.EmptyListException;
import anderson.reid.climblog.repositories.RouteRepository;
import anderson.reid.climblog.services.ClimbService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JPARouteService implements ClimbService<Route> {

   private final RouteRepository routeRepository;

   public JPARouteService(RouteRepository routeRepository) {
      this.routeRepository = routeRepository;
   }

   @Override
   public List<Route> getClimbs() {
      List<Route> routes = new ArrayList<>();
      routeRepository.findAll().iterator().forEachRemaining(routes::add);

      if(routes.isEmpty()) {
         throw new EmptyListException("-- No routes found! --", "Routes", "/climbs/route");
      }

      Collections.sort(routes);
      return routes;
   }

   @Override
   public Route findClimbById(Long id) {
      Optional<Route> optionalRoute = routeRepository.findById(id);
      return optionalRoute.orElse(null);
   }

   @Override
   public Route save(Route climb) {
      return routeRepository.save(climb);
   }
}
