package ru.homework.gb.MVP;

import ru.homework.gb.Base.Calculator;

import java.util.List;

public class Presenter {
    private Model calculator;
    private View view;

    public Presenter(){
        this.calculator = new Model();
        this.view = new View();
    }

    public void start(){
        switch (view.menu()){
            case 1:
                double first = view.getDoubleNumber("1st");
                double second = view.getDoubleNumber("2nd");
                System.out.println(calculator.addition(first, second));
                break;
            case 2:
                first = view.getDoubleNumber("1st");
                second = view.getDoubleNumber("2nd");
                System.out.println(calculator.subtraction(first, second));
                break;
            case 3:
                first = view.getDoubleNumber("1st");
                second = view.getDoubleNumber("2nd");
                System.out.println(calculator.multiplication(first, second));
                break;
            case 4:
                first = view.getDoubleNumber("1st");
                second = view.getDoubleNumber("2nd");
                System.out.println(calculator.division(first, second));
                break;
            case 5:
                List<Double> lastResult = calculator.getLastResult();
                for (Double result: lastResult) {
                    System.out.printf("%d, ",result);
                }
                break;
            default:
                System.out.println("There is no such an item in the menu");
                break;
        }
    }
}
