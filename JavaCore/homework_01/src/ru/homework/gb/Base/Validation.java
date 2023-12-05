package ru.homework.gb.Base;

public class Validation {

    public boolean checkInt(String number){
        try{
            int result = Integer.parseInt(number);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean validationDubleNumbers(String number){
        try{
            double result = Double.parseDouble(number);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
