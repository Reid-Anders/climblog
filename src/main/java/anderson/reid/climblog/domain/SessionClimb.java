package anderson.reid.climblog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public abstract class SessionClimb {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected Long id;

   @Column(name = "date")
   protected LocalDate date;

   @Column(name = "type")
   protected char type;

   @Lob
   @Column(name = "notes")
   protected String notes;

   public String dateString() {
      return this.date.getMonth().toString().substring(0, 3) + " " + this.date.getDayOfMonth() + ", " + this.date.getYear();
   }

}
