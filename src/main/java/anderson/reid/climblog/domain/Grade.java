package anderson.reid.climblog.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "grades")
public abstract class Grade {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   protected String prefix;
   protected String suffix;

   @Override
   public String toString() {
      return this.prefix + this.suffix;
   }

   public abstract void increment();
   public abstract void decrement();
}
