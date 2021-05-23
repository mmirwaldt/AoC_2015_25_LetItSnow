package net.mirwaldt.aoc.year2015.day25;

import java.util.function.LongUnaryOperator;

public class LoopingDiagonalCodeGenerator implements DiagonalCodeGenerator {
    @Override
    public long generateCode(int row, int col, long startValue, LongUnaryOperator operator) {
        if(row < 1 || col < 1) {
            throw new IllegalArgumentException("Row and col must be at least 1 and not row=" + row + ", col=" + col);
        } else {
            int currentRow = 1;
            int currentCol = 1;
            long result = startValue;
            while(!(row == currentRow && col == currentCol)) {
                result = operator.applyAsLong(result);
                currentRow--;
                currentCol++;
                if(currentRow == 0) {
                    currentRow = currentCol;
                    currentCol = 1;
                }
            }
            return result;
        }
    }
}
