package com.epam.gamedev;

import java.util.Scanner;

public class Game {


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

            gameNotFinish = field.checkForWinner(isCurrentX);
            isCurrentX = !isCurrentX;
        }
        boolean oneMoreTime = restart();
        if (oneMoreTime) {
            new Game();
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
            if (row >= 0 && row < GameField.ROWS && col >= 0 && col < GameField.COLS && field.getField()[row][col] == '-') {
                field.currentRow = row;
                field.currentCol = col;
                validInput = true;  // input okay, exit loop
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                        + ") is not valid. Try again...");
            }
        } while (!validInput);  // repeat until input is valid
    }

    boolean restart() {
        System.out.println("One more time? If 'YES' enter 1, if 'NO' enter 2");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                System.out.println("Lets Go");
                return true;
            case 2:
                System.out.println("Bye!");
                return false;
            default:
                System.out.println("Enter 1 or 2");
                return false;
        }
    }
}


