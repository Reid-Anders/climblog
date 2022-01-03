package anderson.reid.climblog.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
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
