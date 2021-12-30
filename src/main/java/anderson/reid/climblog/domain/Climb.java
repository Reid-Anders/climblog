package anderson.reid.climblog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Climb {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected Long id;

   @Column(name = "name")
   protected String name;

   @Column(name = "sector")
   protected String sector;

   @Column(name = "area")
   protected String area;

   @ManyToOne
   @JoinColumn(name = "grade_id")
   protected Grade grade;

   @Column(name = "status")
   protected char status;

}
