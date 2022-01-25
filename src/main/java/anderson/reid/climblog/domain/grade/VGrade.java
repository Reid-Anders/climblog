package anderson.reid.climblog.domain.grade;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;

@NoArgsConstructor
@Entity
public class VGrade extends Grade {

   public VGrade(int n) {
      this.prefix = "V";
      this.n = n <= 17 && n >= 0 ? n : n > 17 ? 17 : 0;
      this.suffix = Integer.toString(n);
   }

   public VGrade(String g) {
      this.prefix = "V";
      this.n = Integer.parseInt(g.substring(1));
      this.suffix = Integer.toString(n);
   }

   public void increment() {
      n++;

      if(n > 17)
         n = 17;

      this.suffix = Integer.toString(n);
   }

   public void decrement() {
      n--;

      if(n < 0)
         n = 0;

      this.suffix = Integer.toString(n);
   }

   //todo: implement test for sorting
   @Override
   public int compareTo(Grade o) {
      VGrade vGrade = (VGrade) o;
      return Integer.compare(n, vGrade.n);
   }
}
