package anderson.reid.climblog.domain;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "routes")
public class Route extends Climb {

   @Column(name = "length")
   private Integer length;

   @Builder
   public Route(Long id, String name, String sector, String area, Grade grade, char status, Integer length) {
      super(id, name, sector, area, grade, status);
      this.length = length;
   }
}
