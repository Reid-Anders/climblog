package anderson.reid.climblog.domain.climb;

import anderson.reid.climblog.domain.grade.VGrade;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "boulders")
public class Boulder extends Climb {

   @Builder
   public Boulder(Long id, String name, String sector, String area, VGrade grade, char status) {
      super(id, name, sector, area, grade, status);
   }
}
