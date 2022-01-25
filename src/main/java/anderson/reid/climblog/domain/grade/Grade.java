package anderson.reid.climblog.domain.grade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "grades")
public abstract class Grade implements Comparable<Grade> {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected Long id;
   
   @Column(name = "prefix")
   protected String prefix;

   @Column(name = "suffix")
   protected String suffix;

   @Transient
   protected int n;

   @Override
   public String toString() {
      return this.prefix + this.suffix;
   }

   @Override
   public boolean equals(Object o) {
      Grade rhs;

      if(!(o instanceof Grade)) {
         return false;
      } else {
         rhs = (Grade) o;
      }

      return this.toString().equals(rhs.toString());
   }

   public abstract void increment();
   public abstract void decrement();
}
