package anderson.reid.climblog.domain;

import lombok.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.thymeleaf.util.StringUtils;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "pitches")
public class Pitch extends SessionClimb {

   @ManyToOne
   @JoinColumn(name = "route_id")
   private Route route;

   @Column(name = "partner")
   private String partner;

   @Builder
   public Pitch(Long id, LocalDate date, char type, String notes, Route route, String partner) {
      super(id, date, type, notes);
      this.route = route;
      this.partner = partner;
   }
}
