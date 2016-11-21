package net.evenh.util.ddd;

/**
 * Contains boilerplate functionality for immutable value objects.
 */
public abstract class AbstractValueObject implements ValueObject {
  @Override
  public int hashCode() {
    return getValues().hashCode();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null || !this.getClass().equals(that.getClass())) {
      return false;
    }

    return this.getValues().equals(((ValueObject) that).getValues());
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + '[' + getValues() + ']';
  }


}
