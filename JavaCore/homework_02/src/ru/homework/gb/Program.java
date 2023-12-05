package ru.homework.gb;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';

    private static final int WIN_COUNT = 4;

    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static char[][] field; // Игровое поле

    private static int fieldSizeX;
    private static int fieldSizeY;


    public static void main(String[] args) {
        while (true) {
            initField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "You win!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Mr. Computer wins!"))
                    break;
            }
            System.out.print("Wanna try again? (Y - yep): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * initialization of the play ground
     */
    private static void initField() {
        fieldSizeX = 5;
        fieldSizeY = 5;

        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Print the play ground
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i));
        }
        System.out.println("-");

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print((y) + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Human's turn
     */
    private static void humanTurn() {
        int x, y;

        do {
            System.out.print("Insert the coordinates X and Y\n(from 1 to 3) with a SPACE >>> ");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;

    }

    /**
     * Computer's turn
     * antiWin keeps the results of the next move, if it's possible for the player to win
     *
     * warming keeps 1 st move, which can lose the game, if there's no win combination
     * in the next move
     */
    private static void aiTurn() {
        int x, y;
        int[] antiWin = checkHumansMoves(DOT_HUMAN);
        int[] warning = checkPrevention(DOT_HUMAN);
        if(antiWin[0] != -1 && antiWin[1] != -1){
            y = antiWin[0];
            x = antiWin[1];
        } else if (warning[0] != -1 && warning[1] != -1) {
            y = warning[0];
            x = warning[1];
        } else {
            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            }
            while (!isCellEmpty(x, y));
        }
        field[y][x] = DOT_AI;


    }

    /**
     * Checkup, if the cell of the playground is empty
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Checkup of the correctness of the move coordinates
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Checkup method  od the game status
     *
     * @param dot    the player's chip
     * @param winStr winning motto
     * @return game finish indicator (true)
     */
    private static boolean gameCheck(char dot, String winStr) {
        if (isWin(dot)) {
            System.out.println(winStr);
            return true;
        }

        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }

        return false; // Игра продолжается
    }

    /**
     *  Draw checkup (all the cells of the playground are filled)
     *
     * @return
     */
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * Universal method of winning combinations checkup.
     *
     * @param dot
     * @return
     */
    private static boolean isWin(char dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (firsDiagonal(y, x, dot) || secondDiagonal(y, x, dot)
                        || horizontal(y, x, dot) || vertical(y, x, dot))
                    return true;
            }
        }
        return false;
    }

    /**
     *
     * Search for the player's pre-winning combinations. The first available one will be selected
     * @param dot
     * @return
     */
    private static boolean findWinPlayersCombination(char dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (firsDiagonalForBot(y, x, dot) || secondDiagonalForBot(y, x, dot)
                        || horizontalForBot(y, x, dot) || verticalForBot(y, x, dot))
                    return true;
            }
        }
        return false;
    }

    /**
     *
     * A method for the bot that allows you to make a move taking into account the possible victory of the user on the next move
     * @param dot
     * @return an array with the coordinates of the best move
     */
    private static int[] checkPrevention(char dot) {
        int[] answer = {-1, -1};
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(isCellEmpty(x,y)) {
                    field[y][x] = dot;
                    if (findWinPlayersCombination(dot)) {
                        answer[0] = y;
                        answer[1] = x;
                    }
                    field[y][x] = DOT_EMPTY;
                }
            }
        }
        return answer;
    }

    private static int[] checkHumansMoves(char dot) {
        int[] answer = {-1, -1};
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(isCellEmpty(x,y)) {
                    field[y][x] = dot;
                    if (isWin(dot)) {
                        answer[0] = y;
                        answer[1] = x;
                    }
                    field[y][x] = DOT_EMPTY;
                }
            }
        }
        return answer;
    }

    /**
     * The method of checking the winning combination on the first diagonal
     *
     * @param y   coordinate X
     * @param x   coordinate Y
     * @param dot Player's emblem
     * @return True/False
     */
    private static boolean firsDiagonal(int y, int x, char dot) {
        try {
            if (field[y][x] == dot
                    && field[y + (WIN_COUNT - 3)][x + (WIN_COUNT - 3)] == dot
                    && field[y + (WIN_COUNT - 2)][x + (WIN_COUNT - 2)] == dot
                    && field[y + (WIN_COUNT - 1)][x + (WIN_COUNT - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }


    /**
     * The method of checking the winning combination along the first diagonal to find a pre-winning combination
     *
     * @param y   coordinate X
     * @param x   coordinate Y
     * @param dot Player's emblem
     * @return True/False
     */
    private static boolean firsDiagonalForBot(int y, int x, char dot) {
        int newWinCount = WIN_COUNT - 1;
        try {
            if (field[y][x] == dot
                    && field[y + (newWinCount - 2)][x + (newWinCount - 2)] == dot
                    && field[y + (newWinCount - 1)][x + (newWinCount - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * The method of checking the winning combination on the second diagonal
     *
     * @param y   coordinate X
     * @param x   coordinate Y
     * @param dot Player's emblem
     * @return True/False
     */
    private static boolean secondDiagonal(int y, int x, char dot) {
        try {
            if (field[y][x] == dot
                    && field[y + (WIN_COUNT - 3)][x - (WIN_COUNT - 3)] == dot
                    && field[y + (WIN_COUNT - 2)][x - (WIN_COUNT - 2)] == dot
                    && field[y + (WIN_COUNT - 1)][x - (WIN_COUNT - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     *
     * The method of checking the winning combination on the second diagonal to find a pre-winning combination
     *
     * @param y   coordinate X
     * @param x   coordinate Y
     * @param dot Player's emblem
     * @return True/False
     */
    private static boolean secondDiagonalForBot(int y, int x, char dot) {
        int newWinCount = WIN_COUNT - 1;
        try {
            if (field[y][x] == dot
                    && field[y + (newWinCount - 2)][x - (newWinCount - 2)] == dot
                    && field[y + (newWinCount - 1)][x - (newWinCount - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * The method of checking the winning combination horizontally
     *
     * @param y   coordinate X
     * @param x   coordinate Y
     * @param dot Player's emblem
     * @return True/False
     */
    private static boolean horizontal(int y, int x, char dot) {
        try {
            if (field[y][x] == dot
                    && field[y][x + (WIN_COUNT - 3)] == dot
                    && field[y][x + (WIN_COUNT - 2)] == dot
                    && field[y][x + (WIN_COUNT - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * The method of checking the winning combination horizontally to find a pre-winning combination
     *
     * @param y   coordinate X
     * @param x   coordinate Y
     * @param dot Player's emblem
     * @return True/False
     */
    private static boolean horizontalForBot(int y, int x, char dot) {
        int newWinCount = WIN_COUNT - 1;
        try {
            if (field[y][x] == dot
                    && field[y][x + (newWinCount - 2)] == dot
                    && field[y][x + (newWinCount - 1)] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * The method of checking the winning combination vertically
     *
     * @param y   coordinate X
     * @param x   coordinate Y
     * @param dot Player's emblem
     * @return True/False
     */
    private static boolean vertical(int y, int x, char dot) {
        try {
            if (field[y][x] == dot
                    && field[y + (WIN_COUNT - 3)][x] == dot
                    && field[y + (WIN_COUNT - 2)][x] == dot
                    && field[y + (WIN_COUNT - 1)][x] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    /**
     * The method of checking the winning combination vertically to find a pre-winning combination
     *
     * @param y   coordinate X
     * @param x   coordinate Y
     * @param dot Player's emblem
     * @return True/False
     */
    private static boolean verticalForBot(int y, int x, char dot) {
        int newWinCount = WIN_COUNT - 1;
        try {
            if (field[y][x] == dot
                    && field[y + (newWinCount - 2)][x] == dot
                    && field[y + (newWinCount - 1)][x] == dot)
                return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }


}
