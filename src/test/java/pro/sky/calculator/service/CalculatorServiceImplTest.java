package pro.sky.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    CalculatorService underTest = new CalculatorServiceImpl();

    @Test
    void calculator__returnCalculatorString() {
        String result = underTest.calculator();
        assertEquals("Welcome to calculator", result);
    }

    @Test
    void plus_num1PlusNum2ResultWithPlus_resultWithPlus() {
        var result = underTest.plus(4, 2);
        assertEquals(6, result);
    }

    @Test
    void plus_num1PlusNum2ResultWithMinus_resultWithMinus() {
        var result = underTest.plus(-100, 40);
        assertEquals(-60, result);
    }

    @Test
    void plus_num1PlusNum2MaxValue_integer() {
        var result = underTest.plus(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(-2, result);
    }

    @Test
    void plus_num1PlusNum2MinValue_integer() {
        var result = underTest.plus(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("dataForPlus")
    void plus__returnIntegerPlusOrMinus(int num1, int num2, int expectedResult) {
        var result = underTest.plus(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForPlus() {
        return Stream.of(
                Arguments.of(4, 2, 6),
                Arguments.of(-100, 40, -60),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, -2)
        );
    }

    @Test
    void minus_num1MinusNum2SignPlus_resultWithSignPlus() {
        var result = underTest.minus(30, 9);
        assertEquals(21, result);
    }

    @Test
    void minus_num1MinusNum2SighMinus_resultWithMinus() {
        var result = underTest.minus(28, 29);
        assertEquals(-1, result);
    }

    @ParameterizedTest
    @MethodSource("dataForMinus")
    void minus__returnIntegerPlusOrMinus(int num1, int num2, int expectedResult) {
        var result = underTest.minus(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMinus() {
        return Stream.of(
                Arguments.of(30, 9, 21),
                Arguments.of(28, 29, -1)
        );
    }

    @Test
    void multiply_num1MultiplyNum2SignPlus_resultWithPlus() {
        var result = underTest.multiply(2, 4);
        assertEquals(8, result);
    }

    @Test
    void multiply_num1MultiplyNum2SignMinus_resultWithMinus() {
        var result = underTest.multiply(-2, 4);
        assertEquals(-8, result);
    }

    @Test
    void multiply_num1MultiplyNum2MaxValue_integer() {
        var result = underTest.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(1, result);
    }

    @Test
    void multiply_num1MultiplyNum2MinValue_integer() {
        var result = underTest.multiply(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("dataForMultiply")
    void multiply__resultIntegerPlusOrMinus(int num1, int num2, int expectedResult) {
        var result = underTest.multiply(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMultiply() {
        return Stream.of(
                Arguments.of(2, 4, 8),
                Arguments.of(-2, 4, -8),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE, 0)
        );
    }

    @Test
    void divide_num1DividedNum2WithoutFraction_resultWithoutFraction() {
        var result = underTest.divide(10, 5);
        assertEquals(2, result);
    }

    @Test
    void divide_num1DividedNum2WithFraction_resultWithFraction() {
        var result = underTest.divide(9, 2);
        assertEquals(4.5, result);
    }

    @Test
    void divide_num2Is0_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> underTest.divide(3, 0));
    }

    @ParameterizedTest
    @MethodSource("dataForDivide")
    void divide__returnDouble(int num1, int num2, double expectedResult) {
        var result = underTest.divide(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForDivide() {
        return Stream.of(
                Arguments.of(10, 5, 2),
                Arguments.of(9, 2, 4.5)
        );
    }
}