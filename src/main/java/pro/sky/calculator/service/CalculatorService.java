package pro.sky.calculator.service;

public interface CalculatorService {
    String calculator();

    long plus(long num1, long num2);

    long minus(long num1, long num2);

    long multiply(long num1, long num2);

    double divide(long num1, long num2);

}
