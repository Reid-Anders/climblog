package anderson.reid.climblog.services.JPAservices;

import anderson.reid.climblog.domain.Boulder;
import anderson.reid.climblog.domain.Route;
import anderson.reid.climblog.repositories.RouteRepository;
import anderson.reid.climblog.services.ClimbService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JPARouteService implements ClimbService<Route> {

   private final RouteRepository routeRepository;

   public JPARouteService(RouteRepository routeRepository) {
      this.routeRepository = routeRepository;
   }

   @Override
   public Set<Route> getClimbs() {
      Set<Route> routes = new HashSet<>();
      routeRepository.findAll().iterator().forEachRemaining(routes::add);
      return routes;
   }

   @Override
   public Route findClimbById(Long id) {
      Optional<Route> optionalRoute = routeRepository.findById(id);
      return optionalRoute.orElse(null);
   }
}
