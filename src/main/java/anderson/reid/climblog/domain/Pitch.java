package anderson.reid.climblog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pitches")
public class Pitch {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "route_id")
   private Route route;

   @Column(name = "date")
   private LocalDate date;

   @Column(name = "partner")
   private String partner;

   @Column(name = "type")
   private char type;

   @Lob
   @Column(name = "notes")
   private String notes;
}
