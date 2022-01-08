package anderson.reid.climblog.domain.climb;

import anderson.reid.climblog.domain.grade.YDSGrade;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "routes")
public class Route extends Climb {

   @Column(name = "length")
   private Integer length;

   @Builder
   public Route(Long id, String name, String sector, String area, YDSGrade grade, char status, Integer length) {
      super(id, name, sector, area, grade, status);
      this.length = length;
   }

   @Override
   public boolean equals(Object o) {
      Route rhs;

      if(!(o instanceof Route)) {
         return false;
      } else {
         rhs = (Route) o;
      }

      return this.length.equals(rhs.length) && super.equals(rhs);
   }
}
