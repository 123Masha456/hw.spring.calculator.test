package pro.sky.calculator.service;

public interface CalculatorService {
    String calculator();

    long plus(int num1, int num2);

    long minus(int num1, int num2);

    long multiply(int num1, int num2);

    double divide(int num1, int num2);

}
