package ru.homework.gb.Base;

import java.util.List;

public abstract class Calculator {

    public double addition(double first, double second){
        double result = first + second;
        return result;
    }

    public double subtraction(double first, double second){
        double result = first - second;
        return result;
    }
    public double multiplication(double first, double second){
        double result = first * second;
        return result;
    }

    public double division(double first, double second){
        if(second == 0.0)
            throw new ArithmeticException("Деление на ноль!");
        double result = first/second;
        return result;
    }

}
