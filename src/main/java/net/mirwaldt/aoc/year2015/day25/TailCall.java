package net.mirwaldt.aoc.year2015.day25;

import java.util.stream.Stream;

@FunctionalInterface
interface TailCall<T> {
    TailCall<T> apply();
    default boolean isComplete() { return false; }
    default T result() { throw new Error(); }
    default T invoke() {
        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::isComplete)
                .findFirst().get().result();
    }
}
