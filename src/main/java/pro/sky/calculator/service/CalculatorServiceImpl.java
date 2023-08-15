package pro.sky.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calculator() {
        return "Welcome to calculator";
    }

    @Override
    public long plus(long num1, long num2) {
        return num1 + num2;
    }

    @Override
    public long minus(long num1, long num2) {
        return num1 - num2;
    }

    @Override
    public long multiply(long num1, long num2) {
        return num1 * num2;
    }

    @Override
    public double divide(long num1, long num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return (double) num1 / num2;
    }
}

