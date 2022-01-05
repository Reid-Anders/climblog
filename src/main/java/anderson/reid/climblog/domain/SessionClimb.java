package anderson.reid.climblog.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class SessionClimb<T extends Climb> extends BaseEntity implements Comparable<SessionClimb<T>> {

   @ManyToOne
   @JoinColumn(name = "climb_id")
   protected T climb;

   @Column(name = "date")
   protected LocalDate date;

   @Column(name = "type")
   protected char type;

   @Lob
   @Column(name = "notes")
   protected String notes;

   public SessionClimb(Long id, T climb, LocalDate date, char type, String notes) {
      super(id);
      this.climb = climb;
      this.date = date;
      this.type = type;
      this.notes = notes;
   }

   @Override
   public int compareTo(SessionClimb<T> sessionClimb) {
      return this.date.compareTo(sessionClimb.date) * -1;
   }

   @Override
   public String toString() {
      return this.climb + " on " + this.date;
   }
}
