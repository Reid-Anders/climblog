package anderson.reid.climblog.bootstrap;

import anderson.reid.climblog.domain.*;
import anderson.reid.climblog.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

   private final RouteRepository routeRepository;
   private final BoulderRepository boulderRepository;
   private final PitchRepository pitchRepository;
   private final BoulderSessionRepository boulderSessionRepository;
   private final GradeRepository gradeRepository;

   public DataLoader(RouteRepository routeRepository, BoulderRepository boulderRepository, PitchRepository pitchRepository, BoulderSessionRepository boulderSessionRepository, GradeRepository gradeRepository) {
      this.routeRepository = routeRepository;
      this.boulderRepository = boulderRepository;
      this.pitchRepository = pitchRepository;
      this.boulderSessionRepository = boulderSessionRepository;
      this.gradeRepository = gradeRepository;
   }

   @Override
   public void run(String... args) throws Exception {
      YDSGrade seven = new YDSGrade("5.7");
      YDSGrade eight = new YDSGrade("5.8");
      YDSGrade nine = new YDSGrade("5.9");
      YDSGrade tenA = new YDSGrade("5.10a");
      YDSGrade tenB = new YDSGrade("5.10b");
      YDSGrade tenC = new YDSGrade("5.10c");
      YDSGrade tenD = new YDSGrade("5.10d");
      YDSGrade elevenA = new YDSGrade("5.11a");
      YDSGrade elevenB = new YDSGrade("5.11b");
      YDSGrade elevenC = new YDSGrade("5.11c");
      YDSGrade elevenD = new YDSGrade("5.11d");
      YDSGrade twelveA = new YDSGrade("5.12a");
      YDSGrade twelveB = new YDSGrade("5.12b");
      YDSGrade twelveC = new YDSGrade("5.12c");
      YDSGrade twelveD = new YDSGrade("5.12d");
      YDSGrade thirteenA = new YDSGrade("5.13a");
      YDSGrade thirteenB = new YDSGrade("5.13b");
      YDSGrade thirteenC = new YDSGrade("5.13c");
      YDSGrade thirteenD = new YDSGrade("5.13d");
      YDSGrade fourteenA = new YDSGrade("5.14a");
      YDSGrade fourteenB = new YDSGrade("5.14b");
      YDSGrade fourteenC = new YDSGrade("5.14c");
      YDSGrade fourteenD = new YDSGrade("5.14d");
      YDSGrade fifteenA = new YDSGrade("5.15a");
      YDSGrade fifteenB = new YDSGrade("5.15b");
      YDSGrade fifteenC = new YDSGrade("5.15c");
      YDSGrade fifteenD = new YDSGrade("5.15d");

      gradeRepository.save(seven);
      gradeRepository.save(eight);
      gradeRepository.save(nine);
      gradeRepository.save(tenA);
      gradeRepository.save(tenB);
      gradeRepository.save(tenC);
      gradeRepository.save(tenD);
      gradeRepository.save(elevenA);
      gradeRepository.save(elevenB);
      gradeRepository.save(elevenC);
      gradeRepository.save(elevenD);
      gradeRepository.save(twelveA);
      gradeRepository.save(twelveB);
      gradeRepository.save(twelveC);
      gradeRepository.save(twelveD);
      gradeRepository.save(thirteenA);
      gradeRepository.save(thirteenB);
      gradeRepository.save(thirteenC);
      gradeRepository.save(thirteenD);
      gradeRepository.save(fourteenA);
      gradeRepository.save(fourteenB);
      gradeRepository.save(fourteenC);
      gradeRepository.save(fourteenD);
      gradeRepository.save(fifteenA);
      gradeRepository.save(fifteenB);
      gradeRepository.save(fifteenC);
      gradeRepository.save(fifteenD);

      VGrade v0 = new VGrade("V0");
      VGrade v1 = new VGrade("V1");
      VGrade v2 = new VGrade("V2");
      VGrade v3 = new VGrade("V3");
      VGrade v4 = new VGrade("V4");
      VGrade v5 = new VGrade("V5");
      VGrade v6 = new VGrade("V6");
      VGrade v7 = new VGrade("V7");
      VGrade v8 = new VGrade("V8");
      VGrade v9 = new VGrade("V9");
      VGrade v10 = new VGrade("V10");
      VGrade v11 = new VGrade("V11");
      VGrade v12 = new VGrade("V12");
      VGrade v13 = new VGrade("V13");
      VGrade v14 = new VGrade("V14");
      VGrade v15 = new VGrade("v15");

      gradeRepository.save(v0);
      gradeRepository.save(v1);
      gradeRepository.save(v2);
      gradeRepository.save(v3);
      gradeRepository.save(v4);
      gradeRepository.save(v5);
      gradeRepository.save(v6);
      gradeRepository.save(v7);
      gradeRepository.save(v8);
      gradeRepository.save(v9);
      gradeRepository.save(v10);
      gradeRepository.save(v11);
      gradeRepository.save(v12);
      gradeRepository.save(v13);
      gradeRepository.save(v14);
      gradeRepository.save(v15);

/*      Route r1 = Route.builder()
            .name("Air Test")
            .sector("Doctor's Wall")
            .area("Skaha Bluffs")
            .grade(thirteenA)
            .status('R')
            .length(40)
            .build();

      Route r2 = Route.builder()
            .name("State of Love and Trust")
            .sector("Lonely Boy")
            .area("Lonely Crags")
            .grade(twelveA)
            .status('R')
            .length(15)
            .build();

      Route r3 = Route.builder()
            .name("Pressure Test")
            .sector("Great White")
            .area("Skaha Bluffs")
            .grade(thirteenC)
            .status('C')
            .length(38)
            .build();

      routeRepository.save(r1);
      routeRepository.save(r2);
      routeRepository.save(r3);*/

      /*Boulder b1 = Boulder.builder()
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
      boulderRepository.save(b2);*/

/*
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
*/

      /*BoulderSession bs1 = BoulderSession.builder()
            .boulder(b1)
            .date(LocalDate.now())
            .attempts(15)
            .type('R')
            .spotters("")
            .notes("One of the best climbs I've ever done")
            .build();

      BoulderSession bs2 = BoulderSession.builder()
            .boulder(b2)
            .date(LocalDate.now())
            .attempts(11)
            .type('C')
            .spotters("Val Day")
            .notes("Really good tries today")
            .build();

      boulderSessionRepository.save(bs1);
      boulderSessionRepository.save(bs2);*/
   }
}
