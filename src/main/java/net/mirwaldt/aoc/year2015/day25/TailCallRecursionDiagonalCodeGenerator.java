package net.mirwaldt.aoc.year2015.day25;

import java.util.function.LongUnaryOperator;

public class TailCallRecursionDiagonalCodeGenerator implements DiagonalCodeGenerator {
    @Override
    public long generateCode(int row, int col, long startValue, LongUnaryOperator operator) {
        return recursiveGenerateCode(row, col, startValue, operator).invoke();
    }

    private TailCall<Long> recursiveGenerateCode(int row, int col, long result, LongUnaryOperator operator) {
        if (row == 1 && col == 1) {
            return TailCalls.done(result);
        } else {
            return () -> {
                if (col == 1) {
                    return recursiveGenerateCode(1, row - 1, operator.applyAsLong(result), operator);
                } else {
                    return recursiveGenerateCode(row + 1, col - 1, operator.applyAsLong(result), operator);
                }
            };
        }
    }
}
