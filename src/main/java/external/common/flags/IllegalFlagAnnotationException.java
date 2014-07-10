package external.common.flags;

import java.lang.reflect.Field;

/**
 * Exception thrown when a non-{@link Flag} object is annotated with
 * {@link FlagInfo}.
 *
 * @author kennyyu (Kenny Yu)
 */
public class IllegalFlagAnnotationException extends FlagException {

  private static final long serialVersionUID = -7902185201659579193L;

  public IllegalFlagAnnotationException(Field field) {
    super("field: " + field.toGenericString()
        + " from " + field.getDeclaringClass() + " cannot be annotated with "
        + FlagInfo.class);
  }

}
