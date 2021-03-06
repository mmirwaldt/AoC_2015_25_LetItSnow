package net.mirwaldt.aoc.year2015.day25;

import java.util.function.LongUnaryOperator;

public class Main {
    public static void main(String[] args) {
        final DiagonalCodeGenerator diagonalCodeGenerator = new TailCallRecursionDiagonalCodeGenerator();
        final LongUnaryOperator operator = (val) -> (val * 252533L) % 33554393;

        // result: 9132360
        System.out.println(diagonalCodeGenerator.generateCode(2981, 3075, 20151125L, operator));

//        System.out.println(DiagonalCodeGenerator.calcNumberOfSells(2981, 3075)); // 4729350 recursive calls
    }
}
