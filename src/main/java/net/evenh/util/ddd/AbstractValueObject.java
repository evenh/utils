package net.evenh.util.ddd;

/**
 * Contains boilerplate methods for immutable value objects.
 */
public abstract class AbstractValueObject implements ValueObject {
  /**
   * Create a <code>hashCode</code> based on the values of the object.
   *
   * @return A hash code value for this object.
   */
  @Override
  public int hashCode() {
    return getValues().hashCode();
  }

  /**
   * Compares this instance to another object by checking whether the other object is a
   * {@link ValueObject} and contains the same values.
   *
   * @return True if the other object contains the same values as this object.
   */
  @Override
  public boolean equals(Object that) {
    if (that == null || !this.getClass().equals(that.getClass())) {
      return false;
    }

    return this.getValues().equals(((ValueObject) that).getValues());
  }

  /**
   * Prints a string containing this class's name and values.
   *
   * @return A formatted string containing information about this object.
   */
  @Override
  public String toString() {
    return getClass().getSimpleName() + '[' + getValues() + ']';
  }
}
