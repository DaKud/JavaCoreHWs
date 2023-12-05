package ru.homework.gb.MVP;

import ru.homework.gb.Base.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Model extends Calculator {

    private List<Double> lastResult;

    public Model(){
        lastResult = new ArrayList<>();
    }

    public List<Double> getLastResult() {
        return lastResult;
    }

    @Override
    public double addition(double first, double second) {
       double result = super.addition(first, second);
       lastResult.add(result);
       return result;
    }

    @Override
    public double subtraction(double first, double second) {
        double result =  super.subtraction(first, second);
        lastResult.add(result);
        return result;
    }

    @Override
    public double multiplication(double first, double second) {
        double result =  super.multiplication(first, second);
        lastResult.add(result);
        return result;
    }

    @Override
    public double division(double first, double second) {
        double result =  super.division(first, second);
        lastResult.add(result);
        return result;
    }
}
