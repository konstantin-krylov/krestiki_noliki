package com.epam.gamedev;

public class GameField {
    public static final int ROWS = 3, COLS = ROWS; // number of rows and columns

    private char[][] field;
    int currentRow, currentCol;  // the current row and column
    private int moveCount;

    public GameField() {
        field = new char[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                field[i][j] = '-';
            }
        }
        printField();
    }

    public char[][] getField() {
        return field;
    }

    public void addMoveCount() {
        this.moveCount++;
    }

    void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    void updateField(boolean isCurrentX) {
        if (isCurrentX) {
            field[currentRow][currentCol] = 'X';
        } else {
            field[currentRow][currentCol] = 'O';
        }

    }

    boolean checkForWinner(boolean isCurrentX) {
        if (moveCount >= 5) {
            for (int i = 0; i < ROWS; i++) {
                // checking horizontal / vertical
                if (((field[i][0] == field[i][1] && field[i][0] == field[i][2]) ||
                        (field[0][i] == field[1][i] && field[0][i] == field[2][i])) && field[i][i] != '-') {
                    System.out.println("Player " + (isCurrentX ? "'X'" : "'O'") + " won!");
                    return false;
                }
            }
            // checking diagonals
            if (((field[0][0] == field[1][1] && field[0][0] == field[2][2]) && field[0][0] != '-' ||
                    (field[0][2] == field[1][1] && field[0][2] == field[2][0])) && field[0][2] != '-') {
                System.out.println("Player " + (isCurrentX ? "'X'" : "'O'") + " won!");
                return false;
            }

//            if (currentCol == currentRow) { // возможно реализовать более интересную реализацию проверки диагоналей
//                //we're on a diagonal
//                for (int i = 0; i < ROWS; i++) {
//                    if (field[i][i] == '-') {
//                        break;
//                    }
//                    if (field[i][i] == field[i + 1][i + 1] && field[i][i] == field[i + 2][i + 2]) {
//                        System.out.println("Player " + (isCurrentX ? "'X'" : "'O'") + " won!");
//                        return false;
//                    }
//                }
//            }
        }
        return true;
    }
}


