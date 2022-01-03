package anderson.reid.climblog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "grades")
public abstract class Grade implements Comparable<Grade> {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected Long id;

   protected String prefix;
   protected String suffix;

   @Override
   public String toString() {
      return this.prefix + this.suffix;
   }

   public abstract void increment();
   public abstract void decrement();
}
