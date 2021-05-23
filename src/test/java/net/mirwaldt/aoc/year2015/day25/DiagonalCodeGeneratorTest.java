package net.mirwaldt.aoc.year2015.day25;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.LongUnaryOperator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagonalCodeGeneratorTest {
    @SuppressWarnings("unused")
    private static Stream<Arguments> diagonalCodeGenerator() {
        return Stream.of(
                Arguments.of(new RecursiveDiagonalCodeGenerator()),
                Arguments.of(new LoopingDiagonalCodeGenerator())
        );
    }

    @ParameterizedTest
    @MethodSource("diagonalCodeGenerator")
    void test_simple(DiagonalCodeGenerator diagonalCodeGenerator) {
        assertEquals(1, diagonalCodeGenerator.generateCode(1, 1, 1, (sum) -> sum + 1));
        assertEquals(12, diagonalCodeGenerator.generateCode(4, 2, 1, (sum) -> sum + 1));
        assertEquals(15, diagonalCodeGenerator.generateCode(1, 5, 1, (sum) -> sum + 1));
    }

    @ParameterizedTest
    @MethodSource("diagonalCodeGenerator")
    void test_complicated(DiagonalCodeGenerator diagonalCodeGenerator) {
        final long startValue = 20151125L;
        LongUnaryOperator operator = (val) -> (val * 252533L) % 33554393;

        assertEquals(startValue, diagonalCodeGenerator.generateCode(1, 1, startValue, operator));
        assertEquals(31916031L, diagonalCodeGenerator.generateCode(2, 1, startValue, operator));
        assertEquals(16080970L, diagonalCodeGenerator.generateCode(3, 1, startValue, operator));
        assertEquals(24592653L, diagonalCodeGenerator.generateCode(4, 1, startValue, operator));
        assertEquals(77061L, diagonalCodeGenerator.generateCode(5, 1, startValue, operator));
        assertEquals(33071741L, diagonalCodeGenerator.generateCode(6, 1, startValue, operator));

        assertEquals(18749137L, diagonalCodeGenerator.generateCode(1, 2, startValue, operator));
        assertEquals(21629792L, diagonalCodeGenerator.generateCode(2, 2, startValue, operator));
        assertEquals(8057251L, diagonalCodeGenerator.generateCode(3, 2, startValue, operator));
        assertEquals(32451966L, diagonalCodeGenerator.generateCode(4, 2, startValue, operator));
        assertEquals(17552253L, diagonalCodeGenerator.generateCode(5, 2, startValue, operator));
        assertEquals(6796745L, diagonalCodeGenerator.generateCode(6, 2, startValue, operator));

        assertEquals(17289845L, diagonalCodeGenerator.generateCode(1, 3, startValue, operator));
        assertEquals(16929656L, diagonalCodeGenerator.generateCode(2, 3, startValue, operator));
        assertEquals(1601130L, diagonalCodeGenerator.generateCode(3, 3, startValue, operator));
        assertEquals(21345942L, diagonalCodeGenerator.generateCode(4, 3, startValue, operator));
        assertEquals(28094349L, diagonalCodeGenerator.generateCode(5, 3, startValue, operator));
        assertEquals(25397450L, diagonalCodeGenerator.generateCode(6, 3, startValue, operator));

        assertEquals(30943339L, diagonalCodeGenerator.generateCode(1, 4, startValue, operator));
        assertEquals(7726640L, diagonalCodeGenerator.generateCode(2, 4, startValue, operator));
        assertEquals(7981243L, diagonalCodeGenerator.generateCode(3, 4, startValue, operator));
        assertEquals(9380097L, diagonalCodeGenerator.generateCode(4, 4, startValue, operator));
        assertEquals(6899651L, diagonalCodeGenerator.generateCode(5, 4, startValue, operator));
        assertEquals(24659492L, diagonalCodeGenerator.generateCode(6, 4, startValue, operator));

        assertEquals(10071777L, diagonalCodeGenerator.generateCode(1, 5, startValue, operator));
        assertEquals(15514188L, diagonalCodeGenerator.generateCode(2, 5, startValue, operator));
        assertEquals(11661866L, diagonalCodeGenerator.generateCode(3, 5, startValue, operator));
        assertEquals(10600672L, diagonalCodeGenerator.generateCode(4, 5, startValue, operator));
        assertEquals(9250759L, diagonalCodeGenerator.generateCode(5, 5, startValue, operator));
        assertEquals(1534922L, diagonalCodeGenerator.generateCode(6, 5, startValue, operator));

        assertEquals(33511524L, diagonalCodeGenerator.generateCode(1, 6, startValue, operator));
        assertEquals(4041754L, diagonalCodeGenerator.generateCode(2, 6, startValue, operator));
        assertEquals(16474243L, diagonalCodeGenerator.generateCode(3, 6, startValue, operator));
        assertEquals(31527494L, diagonalCodeGenerator.generateCode(4, 6, startValue, operator));
        assertEquals(31663883L, diagonalCodeGenerator.generateCode(5, 6, startValue, operator));
        assertEquals(27995004L, diagonalCodeGenerator.generateCode(6, 6, startValue, operator));
    }
}
