package anderson.reid.climblog.domain.sessionclimb;

import anderson.reid.climblog.domain.climb.Route;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pitches")
public class Pitch extends SessionClimb<Route> {

   @Column(name = "partner")
   private String partner;

   @Builder
   public Pitch(Long id, Route climb, LocalDate date, char type, String notes, String partner) {
      super(id, climb, date, type, notes);
      this.partner = partner;
   }

   @Override
   public boolean equals(Object o) {
      Pitch rhs;

      if(!(o instanceof Pitch)) {
         return false;
      } else {
         rhs = (Pitch) o;
      }

      return this.partner.equals(rhs.partner) && super.equals(rhs);
   }
}
