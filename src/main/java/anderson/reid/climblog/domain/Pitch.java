package anderson.reid.climblog.domain;

import lombok.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.thymeleaf.util.StringUtils;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
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
}
