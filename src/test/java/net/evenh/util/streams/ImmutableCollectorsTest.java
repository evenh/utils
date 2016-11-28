package net.evenh.util.streams;

import static net.evenh.util.streams.ImmutableCollectors.toImmutableList;
import static net.evenh.util.streams.ImmutableCollectors.toImmutableSet;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import net.evenh.util.UnitTest;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ImmutableCollectorsTest extends UnitTest {
  @Test
  public void it_should_return_a_immutable_list() {
    final List<Integer> immutableList = Stream.of(1, 2, 3)
        .map(x -> x * 2)
        .collect(toImmutableList());

    assertThat(immutableList, instanceOf(ImmutableList.class));
    assertThat(immutableList, hasItems(2, 4, 6));

    exception.expect(UnsupportedOperationException.class);
    immutableList.add(4);
  }

  @Test
  public void it_should_return_a_immutable_set() {
    final Set<Integer> immutableSet = Stream.of(1, 2, 3)
        .map(x -> x * 2)
        .collect(toImmutableSet());

    assertThat(immutableSet, instanceOf(ImmutableSet.class));
    assertThat(immutableSet, hasItems(2, 4, 6));

    exception.expect(UnsupportedOperationException.class);
    immutableSet.add(4);
  }
}
