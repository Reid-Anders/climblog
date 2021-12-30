package anderson.reid.climblog.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "routes")
public class Route extends Climb {

   @Builder
   public Route(Long id, String name, String sector, String area, Grade grade, char status) {
      super(id, name, sector, area, grade, status);
   }
}
