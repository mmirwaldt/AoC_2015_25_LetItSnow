package net.mirwaldt.aoc.year2015.day25;

import java.util.function.LongUnaryOperator;

public class TailCallRecursionDiagonalCodeGenerator implements DiagonalCodeGenerator {
    @Override
    public long generateCode(int row, int col, long startValue, LongUnaryOperator operator) {
        return recursiveGenerateCode2(row, col, 1, 1, startValue, operator).invoke();
    }

    /*
     * The tail call optimization makes row and col count down to 1,1
     * but starts from the start value to calculate the result.
     * Therefore don't confuse the values of row and cols on the one side and the result on the side:
     * recursiveGenerateCode(x, y, result, ...) doesn't imply
     * that the result is the value for cell with row x and col y in the table anymore.
     * This changed with tail call optimization.
     */
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

    /*
     * This method also uses tail call optimization but it ensures that
     * the result always corresponds to curRow and curCol.
     */
    private TailCall<Long> recursiveGenerateCode2(
            int row, int col, int curRow, int curCol, long result, LongUnaryOperator operator) {
        if (row == curRow && col == curCol) {
            return TailCalls.done(result);
        } else {
            return () -> {
                if (curRow == 1) {
                    return recursiveGenerateCode2(
                            row, col, curCol + 1, 1, operator.applyAsLong(result), operator);
                } else {
                    return recursiveGenerateCode2(
                            row, col, curRow - 1, curCol + 1, operator.applyAsLong(result), operator);
                }
            };
        }
    }
}
