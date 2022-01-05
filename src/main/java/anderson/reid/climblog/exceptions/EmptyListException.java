package anderson.reid.climblog.exceptions;

import lombok.Getter;

@Getter
public class EmptyListException extends RuntimeException {

   private String pathName;
   private String typeName;

   public EmptyListException() {
      super("Empty list");
   }

   public EmptyListException(String message) {
      super(message);
   }

   public EmptyListException(String message, String typeName) {
      super(message);
      this.typeName = typeName;
   }

   public EmptyListException(String message, String typeName, String pathName) {
      super(message);
      this.typeName = typeName;
      this.pathName = pathName;
   }
}
