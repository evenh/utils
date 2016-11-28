package net.evenh.util.ddd.objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableMap;

import net.evenh.util.ddd.AbstractValueObject;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Represents a valid email address.
 */
public final class EmailAddress extends AbstractValueObject {
  private final Pattern emailPattern = Pattern.compile("[a-zæøåA-ZÆØÅ0-9+._%\\-]{1,256}@"
      + "[a-zæøåA-ZÆØÅ0-9][a-zæøåA-ZÆØÅ0-9\\-]{0,64}(\\.[a-zæøåA-ZÆØÅ0-9][a-zæøåA-ZÆØÅ0-9\\-]"
      + "{1,25})");

  /**
   * The raw, validated email address.
   */
  public final String email;

  /**
   * Construct and validate a new <code>EmailAddress</code> object. Validation will be performed
   * upon creation.
   */
  public EmailAddress(final String email) {
    checkNotNull(email, "The supplied email address cannot be null");
    checkArgument(emailPattern.matcher(email).matches(), "Not a valid email address: %s", email);

    this.email = email;
  }

  @Override
  public Map<String, ?> getValues() {
    return ImmutableMap.of("email", email);
  }

  /**
   * Static factory method to construct an <code>EmailAddress</code> object.
   */
  public static EmailAddress of(final String email) {
    return new EmailAddress(email);
  }
}
