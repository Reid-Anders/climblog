package anderson.reid.climblog.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "boulder_sessions")
public class BoulderSession extends SessionClimb {

   @ManyToOne
   @JoinColumn(name = "boulder_id")
   private Boulder boulder;

   @Column(name = "attempts")
   private Integer attempts;

   @Column(name = "spotters")
   private String spotters;

   @Builder
   public BoulderSession(Long id, LocalDate date, char type, String notes, Boulder boulder, Integer attempts, String spotters) {
      super(id, date, type, notes);
      this.boulder = boulder;
      this.attempts = attempts;
      this.spotters = spotters;
   }
}
