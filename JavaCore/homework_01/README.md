## Урок 1. Компиляция и интерпретация кода
Создать проект из трёх классов (основной с точкой входа и два класса в другом пакете),
которые вместе должны составлять одну программу, позволяющую
производить четыре основных математических действия и осуществлять форматированный
вывод результатов пользователю (ИЛИ ЛЮБОЕ ДРУГОЕ ПРИЛОЖЕНИЕ НА ВАШ ВЫБОР, которое просто 
демонстрирует работу некоторого механизма).

Создать Dockerfile, позволяющий откопировать исходный код вашего 
приложения в образ для демонстрации работы вашего приложения при 
создании соответствующего контейнера.

- create an image

        docker build -t target_java .

- The container must be launched in interactive mode, otherwise input from the console will not work.

        docker run -it target_java

- If you don't do this, an exception will be thrown.

        Exception in thread "main" java.util.NoSuchElementException
        at java.base/java.util.Scanner.throwFor(Scanner.java:945)
        at java.base/java.util.Scanner.next(Scanner.java:1486)
        at ru.homework.gb.MVP.View.menu(View.java:22)
        at ru.homework.gb.MVP.Presenter.start(Presenter.java:17)
        at ru.homework.gb.Main.main(Main.java:8)
