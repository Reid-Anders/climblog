package anderson.reid.climblog.domain;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class Climb extends BaseEntity implements Comparable<Climb> {

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

   public Climb(Long id, String name, String sector, String area, Grade grade, char status) {
      super(id);
      this.name = name;
      this.sector = sector;
      this.area = area;
      this.grade = grade;
      this.status = status;
   }

   @Override
   public String toString() {
      return this.name + ", " + this.grade;
   }

   @Override
   public int compareTo(Climb o) {
      return this.grade.equals(o.grade) ? this.name.compareTo(o.name) : this.grade.compareTo(o.grade);
   }

   public void updateStatus(char type) {
      switch (this.status) {
         case 'G':
            if(type == 'C' || type == 'R' || type == 'F' || type == 'O') {
               this.status = type;
            }
            break;
         case 'C':
            if(type == 'R') {
               this.status = type;
            }
      }
   }
}
