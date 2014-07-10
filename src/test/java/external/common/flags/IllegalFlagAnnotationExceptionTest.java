package external.common.flags;

import static org.junit.Assert.*;

import org.junit.Test;

import external.common.flags.FlagException;
import external.common.flags.FlagInfo;
import external.common.flags.Flags;
import external.common.flags.IllegalFlagAnnotationException;

/**
 * Tests for {@link IllegalFlagAnnotationException}
 *
 * @author kennyyu (Kenny Yu)
 */
public class IllegalFlagAnnotationExceptionTest {

  @SuppressWarnings("unused")
  @FlagInfo(help = "illegal flag annotation", environment = "annotation")
  private static Object object = null;

  @Test
  public void testIllegalFlagAnnotationException() {
    String[] args = {"--object=null"};
    try {
      Flags.parseWithExceptions(args, "annotation");
      fail("did not throw IllegalFlagAnnotationException");
    } catch (IllegalFlagAnnotationException e) {
      assertTrue(true);
    } catch (FlagException e) {
      fail("threw unexpected exception: " + e);
    }
  }

}
