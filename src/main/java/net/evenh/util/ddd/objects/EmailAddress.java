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
final class EmailAddress extends AbstractValueObject {
  private final Pattern emailPattern = Pattern.compile("[a-zæøåA-ZÆØÅ0-9+._%\\-+]{1,256}@"
      + "[a-zæøåA-ZÆØÅ0-9][a-zæøåA-ZÆØÅ0-9\\-]{0,64}(\\.[a-zæøåA-ZÆØÅ0-9][a-zæøåA-ZÆØÅ0-9\\-]"
      + "{1,25})");

  /**
   * The raw, validated email address.
   */
  public final String email;

  public EmailAddress(String email) {
    checkNotNull(email, "The supplied email address cannot be null");
    checkArgument(emailPattern.matcher(email).matches(), "Not a valid email address: %s", email);

    this.email = email;
  }

  @Override
  public Map<String, ?> getValues() {
    return ImmutableMap.of("email", email);
  }

  public static EmailAddress of(String email) {
    return new EmailAddress(email);
  }
}
