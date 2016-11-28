package net.evenh.util.streams;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.stream.Collector;

/**
 * Various collectors to collect a stream to Google's immutable variants.
 */
public final class ImmutableCollectors {
  private ImmutableCollectors() {
    /* No operation, not to be instantiated */
  }

  /**
   * Collect a stream of elements into an {@link ImmutableList}.
   */
  public static <T> Collector<T, ImmutableList.Builder<T>, ImmutableList<T>> toImmutableList() {
    return Collector.of(
        ImmutableList.Builder<T>::new,
        ImmutableList.Builder<T>::add,
        (l, r) -> l.addAll(r.build()),
        ImmutableList.Builder<T>::build);
  }

  /**
   * Collect a stream of elements into an {@link ImmutableSet}.
   */
  public static <T> Collector<T, ImmutableSet.Builder<T>, ImmutableSet<T>> toImmutableSet() {
    return Collector.of(
        ImmutableSet.Builder<T>::new,
        ImmutableSet.Builder<T>::add,
        (l, r) -> l.addAll(r.build()),
        ImmutableSet.Builder<T>::build);
  }
}
