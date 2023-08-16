package pro.sky.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calculator() {
        return "Welcome to calculator";
    }

    @Override
    public long plus(int num1, int num2) {
        return (long) num1 + num2;
    }

    @Override
    public long minus(int num1, int num2) {
        return (long)num1 - num2;
    }

    @Override
    public long multiply(int num1, int num2) {
        return (long)num1 * num2;
    }

    @Override
    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return (double) num1 / num2;
    }
}

