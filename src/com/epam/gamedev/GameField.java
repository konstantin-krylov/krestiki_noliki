package com.epam.gamedev;

public class GameField {
    private char[][] field;
    int currentRow, currentCol;  // the current seed's row and column

    public GameField() {
        field = new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        printField();
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

    boolean checkForWinner(char[][] field, boolean isCurrentX) {
        for (int i = 0; i < 3; i++) {
            // горизонталь / вертикаль
            if (((field[i][0] == field[i][1] && field[i][0] == field[i][2]) ||
                    (field[0][i] == field[1][i] && field[0][i] == field[2][i])) && field[i][i] != '-') {
                if (isCurrentX) {
                    System.out.println("'X' won!");
                    return false;
                } else {
                    System.out.println("'O' won!");
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getField() {
        return field;
    }
//    //check diag
//    boolean checkDiagonal(char[][]field,boolean isCurrent) {
//        if (x == y) {
//            //we're on a diagonal
//            for (int i = 0; i < 3; i++) {
//                if (field[i][i] == '-')
//                    break;
//                if (i == 3 - 1) {
//                    //report win for s
//                }
//            }
//        }
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
