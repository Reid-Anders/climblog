package anderson.reid.climblog.domain.grade;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;

@NoArgsConstructor
@Entity
public class YDSGrade extends Grade {

   @Transient
   private int n;

   @Transient
   private char c;

   public YDSGrade(int n) {
      assignPrefix();
      this.n = n <= 15 && n >= 0 ? n : n > 15 ? 15 : 0;
      this.c = 'a';
      this.suffix = Integer.toString(n);
   }

   public YDSGrade(int n, char c) {
      assignPrefix();
      this.n = n <= 15 && n >= 0 ? n : n > 15 ? 15 : 0;
      this.c = c <= 'd' && c >= 'a' ? c : c >= 'd' ? 'd' : 'a';
      this.suffix = n > 9 ? Integer.toString(n) + c : Integer.toString(n);
   }

   public YDSGrade(String g) {
      assignPrefix();
      this.n = g.length() == 3 ? Integer.parseInt(g.substring(2)) : Integer.parseInt(g.substring(2, 4));
      this.c = g.length() == 3 ? 'a' : g.charAt(4);
      this.suffix = n > 9 ? Integer.toString(n) + c : Integer.toString(n);
   }

   public void increment() {
      this.c++;
      boolean changed = false;

      if (this.c > 'd') {
         this.c = 'a';
         changed = true;
      }

      if(changed || n < 10)
         this.n++;

      if(this.n > 15) {
         this.n = 15;
         this.c = 'd';
      }

      assignSuffix();
   }

   public void decrement() {
      this.c--;
      boolean changed = false;

      if(this.c < 'a') {
         this.c = 'd';
         changed = true;
      }

      if(changed || n < 10)
         this.n--;

      if(this.n < 0) {
         this.n = 0;
         this.c = 'a';
      }

      assignSuffix();
      System.out.println("decrementing grade");
   }

   private void assignSuffix() {
      this.suffix = n > 9 ? Integer.toString(this.n) + this.c : Integer.toString(n);
   }

   private void assignPrefix() {
      this.prefix = "5.";
   }

   @Override
   public int compareTo(Grade o) {
      YDSGrade ydsGrade = (YDSGrade) o;

      return this.n == ydsGrade.n ? Character.compare(this.c, ydsGrade.c) : Integer.compare(this.n, ydsGrade.n);
   }
}
