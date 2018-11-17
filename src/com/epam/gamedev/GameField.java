package com.epam.gamedev;

public class GameField {
    public static final int ROWS = 3, COLS = ROWS; // number of rows and columns

    private char[][] field;
    int currentRow, currentCol;  // the current row and column

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
        for (int i = 0; i < ROWS; i++) {
            // checking horizontal / vertical
            if (((field[i][0] == field[i][1] && field[i][0] == field[i][2]) ||
                    (field[0][i] == field[1][i] && field[0][i] == field[2][i])) && field[i][i] != '-') {
                System.out.println("Player " + (isCurrentX ? "'X'" : "'O'") + " won!");
                return false;
            }
        }
//        if (((field[0][0] == field[1][1] && field[0][0] == field[2][2]) && field[0][0] != '-' ||
//                (field[0][2] == field[1][1] && field[0][2] == field[2][0])) && field[0][2] != '-') {
//            System.out.println("Player " + (isCurrentX ? "'X'" : "'O'") + " won!");
//            return false;
//        }

        if (currentCol == currentRow) {
            //we're on a diagonal
            for (int i = 0; i < ROWS; i++) {
                if (field[i][i] == '-') {
                    break;
                }

            }
        }
        return true;
    }

    //check diag
//    boolean checkDiagonal(boolean isCurrentX) {
//        if (currentCol == currentRow) {
//            //we're on a diagonal
//            for (int i = 0; i < 3; i++) {
//                if (field[i][i] == '-') {
//                    break;
//                }
//                else {
//                    System.out.println("Player " + (isCurrentX ? "'X'" : "'O'") + " won!");
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    //check anti diag (thanks rampion)
//        if(x + y == n - 1){
//        for(int i = 0; i < n; i++){
//            if(field[i][(n-1)-i] != s)
//                break;
//            if(i == n-1){
//                //report win for s
//            }
//        }
//    }
//
//    //check draw
//        if(moveCount == (Math.pow(n, 2) - 1)){
//        //report draw
//    }


}
