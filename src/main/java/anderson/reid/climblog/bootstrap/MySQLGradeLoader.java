package anderson.reid.climblog.bootstrap;

import anderson.reid.climblog.domain.grade.VGrade;
import anderson.reid.climblog.domain.grade.YDSGrade;
import anderson.reid.climblog.repositories.GradeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class MySQLGradeLoader implements CommandLineRunner {

   private final GradeRepository gradeRepository;

   public MySQLGradeLoader(GradeRepository gradeRepository) {
      this.gradeRepository = gradeRepository;
   }

   @Override
   public void run(String... args) throws Exception {
      if(gradeRepository.count() == 0) {
         loadGrades();
      }
   }

   private void loadGrades() {
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
      VGrade v16 = new VGrade("V16");
      VGrade v17 = new VGrade("V17");

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
      gradeRepository.save(v16);
      gradeRepository.save(v17);
   }
}
