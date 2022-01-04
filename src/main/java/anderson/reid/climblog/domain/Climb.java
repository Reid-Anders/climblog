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
public abstract class Climb implements Comparable<Climb> {

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
