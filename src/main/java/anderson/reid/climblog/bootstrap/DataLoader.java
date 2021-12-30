package anderson.reid.climblog.bootstrap;

import anderson.reid.climblog.domain.*;
import anderson.reid.climblog.repositories.BoulderRepository;
import anderson.reid.climblog.repositories.PitchRepository;
import anderson.reid.climblog.repositories.RouteRepository;
import anderson.reid.climblog.repositories.GradeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

   private final RouteRepository routeRepository;
   private final BoulderRepository boulderRepository;
   private final PitchRepository pitchRepository;
   private final GradeRepository gradeRepository;

   public DataLoader(RouteRepository routeRepository, BoulderRepository boulderRepository, PitchRepository pitchRepository, GradeRepository gradeRepository) {
      this.routeRepository = routeRepository;
      this.boulderRepository = boulderRepository;
      this.pitchRepository = pitchRepository;
      this.gradeRepository = gradeRepository;
   }

   @Override
   public void run(String... args) throws Exception {
      YDSGrade g1 = new YDSGrade("5.13a");
      YDSGrade g2 = new YDSGrade("5.12a");
      YDSGrade g3 = new YDSGrade("5.13c");

      gradeRepository.save(g1);
      gradeRepository.save(g2);
      gradeRepository.save(g3);

      VGrade v7 = new VGrade("V7");
      VGrade v6 = new VGrade("V6");

      gradeRepository.save(v7);
      gradeRepository.save(v6);

      Route r1 = Route.builder()
            .name("Air Test")
            .sector("Doctor's Wall")
            .area("Skaha Bluffs")
            .grade(g1)
            .status('R')
            .build();

      Route r2 = Route.builder()
            .name("State of Love and Trust")
            .sector("Lonely Boy")
            .area("Lonely Crags")
            .grade(g2)
            .status('R')
            .build();

      Route r3 = Route.builder()
            .name("Pressure Test")
            .sector("Great White")
            .area("Skaha Bluffs")
            .grade(g3)
            .status('C')
            .build();

      routeRepository.save(r1);
      routeRepository.save(r2);
      routeRepository.save(r3);

      Boulder b1 = Boulder.builder()
            .name("Baby Cthulhu")
            .sector("Burning Man")
            .area("Boulderfields")
            .grade(v7)
            .status('R')
            .build();

      Boulder b2 = Boulder.builder()
            .name("Dangleberries")
            .sector("Dominator")
            .area("Boulderfields")
            .grade(v6)
            .status('R')
            .build();

      boulderRepository.save(b1);
      boulderRepository.save(b2);

      Pitch p1 = Pitch.builder()
            .route(r1)
            .date(LocalDate.now())
            .partner("Landon Orr")
            .type('R')
            .notes("Great effort")
            .build();

      Pitch p2 = Pitch.builder()
            .route(r2)
            .date(LocalDate.now())
            .partner("Val Day")
            .type('C')
            .notes("Fell dumbly")
            .build();

      Pitch p3 = Pitch.builder()
            .route(r3)
            .date(LocalDate.now())
            .partner("Dan Ek")
            .type('F')
            .notes("Almost fell at the top")
            .build();

      pitchRepository.save(p1);
      pitchRepository.save(p2);
      pitchRepository.save(p3);
   }
}
