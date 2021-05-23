package net.mirwaldt.aoc.year2015.day25;

import java.util.function.LongUnaryOperator;

public interface DiagonalCodeGenerator {
    long generateCode(int row, int col, long startValue, LongUnaryOperator operator);
}
