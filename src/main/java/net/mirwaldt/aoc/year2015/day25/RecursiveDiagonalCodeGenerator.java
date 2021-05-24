package net.mirwaldt.aoc.year2015.day25;

import java.util.function.LongUnaryOperator;

/**
 * Doesn't work for large tables with many recursion calls.
 * It dies after about 4660 recursive calls by a stack overflow.
 * However, @{@link TailCallRecursionDiagonalCodeGenerator} uses the same algorithm but works
 */
public class RecursiveDiagonalCodeGenerator implements DiagonalCodeGenerator {
    @Override
    public long generateCode(int row, int col, long startValue, LongUnaryOperator operator) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("Row and col must be at least 1 and not row=" + row + ", col=" + col);
        } else {
            return recursiveGenerateCode2(row, col, 1, 1, startValue, operator);
        }
    }

    private long recursiveGenerateCode(int row, int col, long startValue, LongUnaryOperator operator) {
        if (row == 1 && col == 1) {
            return startValue;
        } else if (col == 1) {
            return operator.applyAsLong(recursiveGenerateCode(1, row - 1, startValue, operator));
        } else {
            return operator.applyAsLong(recursiveGenerateCode(row + 1, col - 1, startValue, operator));
        }
    }

    private long recursiveGenerateCode2(
            int row, int col, int curRow, int curCol, long startValue, LongUnaryOperator operator) {
        if (row == curRow && col == curCol) {
            return startValue;
        } else if (curRow == 1) {
            return operator.applyAsLong(recursiveGenerateCode2(
                    row, col, curCol + 1, 1, startValue, operator));
        } else {
            return operator.applyAsLong(recursiveGenerateCode2(
                    row, col, curRow - 1, curCol + 1, startValue, operator));
        }
    }
}
