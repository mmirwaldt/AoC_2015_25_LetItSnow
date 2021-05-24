package net.mirwaldt.aoc.year2015.day25;

import java.util.function.LongUnaryOperator;

public class TailCallRecursionDiagonalCodeGenerator implements DiagonalCodeGenerator {
//    long counter = 1;

    @Override
    public long generateCode(int row, int col, long startValue, LongUnaryOperator operator) {
//        counter = 1;
        return recursiveGenerateCode(row, col, startValue, operator).invoke();
    }

    private TailCall<Long> recursiveGenerateCode(int row, int col, long value, LongUnaryOperator operator) {
//        System.out.println(counter++);
        if (row == 1 && col == 1) {
            return TailCalls.done(value);
        } else {
            return () -> {
                if (col == 1) {
                    return recursiveGenerateCode(1, row - 1, operator.applyAsLong(value), operator);
                } else {
                    return recursiveGenerateCode(row + 1, col - 1, operator.applyAsLong(value), operator);
                }
            };
        }
    }
}
