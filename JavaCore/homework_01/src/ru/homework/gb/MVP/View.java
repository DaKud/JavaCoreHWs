package ru.homework.gb.MVP;

import ru.homework.gb.Base.Validation;

import java.util.Scanner;

public class View extends Validation {

    private Scanner consoleInput;

    public View(){
        consoleInput = new Scanner(System.in);
    }

    public int menu(){
        System.out.println("1. Addition");
        System.out.println("2. subtraction");
        System.out.println("3. multiplication");
        System.out.println("4. division");
        System.out.println("5. Results of the latest calculations");
        System.out.print("Select an item: ");
        String menuPoint = consoleInput.next();
        int choise =0;
        if(checkInt(menuPoint))
            choise = Integer.parseInt(menuPoint);
        return choise;
    }

    public double getDoubleNumber(String str){
        System.out.print("Insert " + str + " number: ");
        String number = consoleInput.next();
        double result = result = Double.parseDouble(number);
        return result;
    }
}
