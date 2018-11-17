package com.epam.gamedev;

import java.util.Scanner;

public class Game {

    public static final int ROWS = 3, COLS = 3; // number of rows and columns

    private GameField field;
    private boolean isCurrentX = true;
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        field = new GameField();
        boolean gameNotFinish = true;
        while (gameNotFinish) {

            playerMove();

            field.updateField(isCurrentX);
            field.printField();

            gameNotFinish = field.checkForWinner(field.getField(), isCurrentX);
            isCurrentX = !isCurrentX;
        }
    }


    void playerMove() {
        boolean validInput = false;  // for input validation
        do {
            if (isCurrentX) {
                System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
            } else {
                System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
            }
            int row = scanner.nextInt() - 1;  // array index starts at 0 instead of 1
            int col = scanner.nextInt() - 1;
            if (row >= 0 && row < ROWS && col >= 0 && col < COLS && field.getField()[row][col] == '-') {
                field.currentRow = row;
                field.currentCol = col;
                validInput = true;  // input okay, exit loop
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                        + ") is not valid. Try again...");
            }
        } while (!validInput);  // repeat until input is valid
    }
}


