package net.evenh.util.ddd;

import java.util.Map;

/**
 * <p>A value object is a small object that represents a simple entity whose equality is not based
 * on identity: i.e. two value objects are equal when they have the same value, not necessarily
 * being the same object.</p>
 *
 * <p>Small objects, such as points, monies, or ranges, are good examples of value objects. But
 * larger structures can often be programmed as value objects if they don't have any conceptual
 * identity or don't need share references around a program.</p>
 */
public interface ValueObject {
  /**
   * Returns the object's values.
   */
  Map<String, ?> getValues();
}
