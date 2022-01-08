package anderson.reid.climblog.domain.sessionclimb;

import anderson.reid.climblog.domain.climb.Boulder;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "boulder_sessions")
public class BoulderSession extends SessionClimb<Boulder> {

   @Column(name = "attempts")
   private Integer attempts;

   @Column(name = "spotters")
   private String spotters;

   @Builder
   public BoulderSession(Long id, Boulder climb, LocalDate date, char type, String notes, Integer attempts, String spotters) {
      super(id, climb, date, type, notes);
      this.attempts = attempts;
      this.spotters = spotters;
   }

   @Override
   public boolean equals(Object o) {
      BoulderSession rhs;

      if(!(o instanceof BoulderSession)) {
         return false;
      } else {
         rhs = (BoulderSession) o;
      }

      return this.attempts.equals(rhs.attempts) &&
            this.spotters.equals(rhs.spotters) &&
            super.equals(rhs);
   }
}
