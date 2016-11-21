package net.evenh.util;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Common functionality for running unit tests.
 */
@RunWith(JUnit4.class)
public abstract class UnitTest {
  @Rule
  public ExpectedException exception = ExpectedException.none();
}
