package external.common.flags;

import static org.junit.Assert.*;

import org.junit.Test;

import external.common.flags.DuplicateFlagNameException;
import external.common.flags.Flag;
import external.common.flags.FlagException;
import external.common.flags.FlagInfo;
import external.common.flags.Flags;

/**
 * Tests for {@link DuplicateFlagNameException}
 *
 * @author kennyyu (Kenny Yu)
 */
public class DuplicateFlagNameExceptionTest {

  @SuppressWarnings("unused")
  @FlagInfo(
      help = "duplicate exception",
      altName = "dup",
      environment = "duplicate")
  private static Flag<String> duplicate = Flags.valueOf("");

  @SuppressWarnings("unused")
  @FlagInfo(
      help = "duplicate exception",
      altName = "duplicate",
      environment = "duplicate")
  private static Flag<String> dup = Flags.valueOf("");

  @Test
  public void testDuplicateFlagnameException() {
    String[] args = {"--duplicate=foo"};
    try {
      Flags.parseWithExceptions(args, "duplicate");
    } catch (DuplicateFlagNameException e) {
      assertTrue(true);
    } catch (FlagException e) {
      fail("threw unexpected exception: " + e);
    }
  }

}
