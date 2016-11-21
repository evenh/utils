package net.evenh.util.ddd.objects;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.rules.ExpectedException.none;

import net.evenh.util.UnitTest;
import org.junit.Test;

import java.util.List;

public class EmailAddressTest extends UnitTest {
  @Test
  public void it_should_not_accept_null_value_as_input() {
    exception.expect(NullPointerException.class);
    exception.expectMessage("The supplied email address cannot be null");

    EmailAddress.of(null);
  }

  @Test
  public void it_should_reject_addresses_without_tld() {
    final List<String> invalidAddresses = newArrayList("foo@bar", "g@oogle", "john.doe@company");

    for (final String address : invalidAddresses) {
      exception.expect(IllegalArgumentException.class);
      exception.expectMessage("Not a valid email address: " + address);

      EmailAddress.of(address);
    }
  }

  @Test
  public void it_should_reject_addresses_without_subject() {
    final List<String> invalidAddresses = newArrayList("@bar.com", "@noogle.se", "@company.dep.co");

    for (final String address : invalidAddresses) {
      exception.expect(IllegalArgumentException.class);
      exception.expectMessage("Not a valid email address: " + address);

      EmailAddress.of(address);
    }
  }

  @Test
  public void it_should_reject_addresses_without_domain() {
    final List<String> invalidAddresses = newArrayList("hey@.com", "evenh@.net", "@.blog");

    for (final String address : invalidAddresses) {
      exception.expect(IllegalArgumentException.class);
      exception.expectMessage("Not a valid email address: " + address);

      EmailAddress.of(address);
    }
  }

  @Test
  public void it_should_accept_addresses_without_domain() {
    final List<String> goodAddresses = newArrayList("webmaster@evenh.net", "sjobs@apple.com",
        "bar@baz.com", "spiseskje@blåbærsyltetøy.no", "konvertert@xn--blbrsyltety-y8ao3x.no",
        "common.firstname@my-special-workplace.waffles");

    for (final String address : goodAddresses) {
      exception = none();

      final EmailAddress object = EmailAddress.of(address);

      assertThat(object.getValues().get("email"), is(object.email));
      assertThat(object.email, is(address));
    }
  }
}
