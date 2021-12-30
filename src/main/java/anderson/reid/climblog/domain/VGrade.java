package anderson.reid.climblog.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public class VGrade extends Grade {

   private int n;

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
}
