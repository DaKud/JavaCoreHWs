package ru.homework.gb;

import ru.homework.gb.MVP.Presenter;

public class Main {
    public static void main(String[] args) {
        Presenter calculator = new Presenter();
        calculator.start();
    }
}