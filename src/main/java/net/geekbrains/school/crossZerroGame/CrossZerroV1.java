package net.geekbrains.crossZerroGame;

import java.util.Random;
import java.util.Scanner;

/* Крестики-нолики в процедурном стиле
1. Реализовать проверку победы, чтобы она не была набором условий, а, например, с использованием циклов.
2. Реализовать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Желательно не делать это
   просто набором условий для каждой из возможных ситуаций;
3. Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

public class CrossZerroV1 {

    static Scanner scanner = new Scanner(System.in);
    static final Random rand = new Random();

    //1. Создаем переменные с возможностью для пользователя их задавать .

    static int SIZE_X = enterXY();
    static int SIZE_Y = SIZE_X;
    static int DOTS_TO_WIN = enterDots();

    // 2. Создаем двумерный массив
    static char[][] field = new char[SIZE_Y][SIZE_X];

    // 3. Обозначаем кто будет ходить какими фишками
    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = '0';
    static final char EMPTY_DOT = '.';

    // 4. Дадим пользователю возможность самому выбрать размеры поля и выигрышную серию.

    private static int enterXY () {
        System.out.println("Введите размеры поля для игры:");
        return scanner.nextInt();
    }

    private static int enterDots () {
        System.out.printf("Введите количество выигрышных фишек в диапазоне от 3 до %d:", SIZE_X);
        return scanner.nextInt();
    }

    public static void main(String[] args) {

        // 13 иницируем и выводим на печать
        initField();
        printField();

        // 14 Основной ход программы

        while (true) {
            playerStep();
            printField();
            if(checkWin(PLAYER_DOT)) {
                System.out.println("Player WIN!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW");
                break;
            }

            aiStep();
            printField();
            if(checkWin(AI_DOT)) {
                System.out.println("Win SkyNet!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW!");
                break;
            }
        }
    }

    // 5. Заполняем наш массив точками (это свободные ячейки)
    private static void initField() {
        for(int i = 0; i < SIZE_Y; i++) {
            for(int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    // 6. Выводим наш массив на печать
    private static void printField() {
        System.out.println("-------");
        for(int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for(int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    // 7. Метод который устанавливает символ на игровом поле.
    private static void setSym(int y, int x, char sym){
        field[y][x] = sym;
    }

    // 8. Ход игрока с проверкой.
    private static void playerStep() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X Y (1-3)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y,x));
        setSym(y, x, PLAYER_DOT);

    }

    /* 9. Ход ПК с проверкой. Первый ход рандомный. Далее следующий алгоритм: в двойном цикле проверяются все ячейки,
     и компьютер в каждую незанятую ячейку ставит метку игрока. Далее с помощью метода "checkWin()" проверяется
      является ли данный ход выигрышным, если да, то эти координаты запоминаются, и компьютер ставит на них свою метку.
       После каждого анализа ячейка обнуляется. */
    private static void aiStep() {
        int x = -1;
        int y = -1;
        boolean win = false;


        if (!checkWin(PLAYER_DOT)) {
            for (int k = 0; k < SIZE_Y; k++) {
                for (int d = 0; d < SIZE_X; d++) {
                    if (isCellValid(k,d)) {
                        field[k][d] = PLAYER_DOT;
                        if (checkWin(PLAYER_DOT)) {
                            while (isCellValid(k, d));
                            x = d;
                            y = k;
                            win = true;
                        }
                        field[k][d] = EMPTY_DOT; break;

                    }

                }
            }
        }

        if (!win) {
            do {
                x = rand.nextInt(SIZE_X);
                y = rand.nextInt(SIZE_Y);
            }

            while (!isCellValid(y, x));
            setSym(y, x, AI_DOT);
        }
        else {
            setSym(y, x, AI_DOT);
        }
    }


    /* 10. Проверка победы. Для проверки победы организуем три метода. Алгоритм будет следующий:  после введения
     игроком размера поля (SIZE_X; SIZE_Y) и количества выигрышных фишек (DOTS_TO_WIN) проверка выигрыша сводится
      к нахожнению квадрата со стороной (DOTS_TO_WIN) на игровом поле, проверка его по диагоналям (метод checkDiagonal),
       по линиям и столбцам (метод checkLanes) и проверка всех возможных вариантов размещения такого квадрата и игровом
       поле */

    private static boolean checkWin(char symb) {
        for (int col=0; col<((SIZE_Y-DOTS_TO_WIN)+1); col++) {
            for (int row = 0; row < ((SIZE_X - DOTS_TO_WIN) + 1); row++) {
                if (checkDiagonal(symb, col, row) || checkLanes(symb, col, row)) return true;
            }
        }
        return false;

    }

    private static boolean checkLanes(char symb, int setX, int setY) {
        boolean cols, rows;
        for (int col=setX; col<DOTS_TO_WIN+setX; col++) {
            cols = true;
            rows = true;
            for (int row=setY; row<DOTS_TO_WIN+setY; row++) {
                cols &= (field[col][row] == symb);
                rows &= (field[row][col] == symb);
            }

            if (cols || rows) return true;
        }

        return false;
    }

    private static boolean checkDiagonal(char symb, int setX, int setY) {
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i=0; i<DOTS_TO_WIN; i++) {
            toright &= (field[i+setX][i+setY] == symb);
            toleft &= (field[DOTS_TO_WIN-i-1+setX][i+setY] == symb);
        }

        if (toright || toleft) return true;

        return false;
    }

    // 11. Проверка полное ли поле? возможно ли ходить?
    private static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for(int j = 0; j < SIZE_X; j++) {
                if(field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    // 12. Проверяем возможен ли ход
    private static boolean isCellValid(int y, int x) {
        // если вываливаемся за пределы возвращаем false
        if(x < 0 || y < 0 || x > SIZE_X -1 || y > SIZE_Y - 1) {
            return false;
        }
        // если не путое поле тоже false
        return (field[y][x] == EMPTY_DOT);
    }
}


