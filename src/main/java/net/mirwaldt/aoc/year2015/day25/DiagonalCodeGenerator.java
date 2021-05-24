package net.mirwaldt.aoc.year2015.day25;

import java.util.function.LongUnaryOperator;

import static java.lang.Math.max;

public interface DiagonalCodeGenerator {
    long generateCode(int row, int col, long startValue, LongUnaryOperator operator);

    static long calcNumberOfSells(int row, int col) {
        final long gaussN;
        if(1 < row && row == col) {
            gaussN = col;
        } else {
            gaussN = max(row, col) - 1;
        }
        long gaussSum = gaussN * (gaussN + 1) / 2;
        return gaussSum + col;
    }
}
