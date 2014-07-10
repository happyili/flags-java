package external.common.flags;

import static org.junit.Assert.*;

import org.junit.Test;

import external.common.flags.Flag;
import external.common.flags.FlagException;
import external.common.flags.FlagInfo;
import external.common.flags.Flags;
import external.common.flags.UnsupportedFlagTypeException;

/**
 * Tests for {@link UnsupportedFlagTypeException}
 *
 * @author kennyyu (Kenny Yu)
 */
public class UnsupportedFlagTypeExceptionTest {

  @SuppressWarnings("unused")
  @FlagInfo(help = "unsupported parameter type", environment = "parameter")
  private static Flag<Object> flagBad = Flags.valueOf(new Object());

  @Test
  public void testUnsupportedFlagTypeException() {
    String[] args = {"--flagBad=5"};
    try {
      Flags.parseWithExceptions(args, "parameter");
      fail("did not throw exception");
    } catch (UnsupportedFlagTypeException e) {
      assertTrue(true);
    } catch (FlagException e) {
      fail("threw unexpected exception: " + e);
    }
  }

}
