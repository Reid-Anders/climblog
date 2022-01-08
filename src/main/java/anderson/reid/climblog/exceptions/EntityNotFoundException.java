package anderson.reid.climblog.exceptions;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

   private String entityName;
   private String entityId;

   public EntityNotFoundException() {
      super("Entity not found");
   }

   public EntityNotFoundException(String entityName) {
      super(entityName + " not found");
      this.entityName = entityName;
   }

   public EntityNotFoundException(String entityName, String id) {
      super(entityName + " with id " + id + " not found");
      this.entityName = entityName;
      this.entityId = id;
   }
}
