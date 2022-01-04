package anderson.reid.climblog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
