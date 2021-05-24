package net.mirwaldt.aoc.year2015.day25;

class TailCalls {
    static <T> TailCall<T> done(final T value) {
        return new TailCall<T>() {
            public boolean isComplete() { return true; }
            public T result() { return value; }
            public TailCall<T> apply() { throw new Error(); }
        };
    }
}
