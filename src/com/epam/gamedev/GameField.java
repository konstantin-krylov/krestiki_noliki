package com.epam.gamedev;

public class GameField {
    char[][] field;

    public GameField() {
        field = new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
    }

    void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    void updateField(int x, int y, boolean isCurrentX) {
        if (isCurrentX) {
            field[x-1][y-1] = 'X';
        } else {
            field[x-1][y-1] = 'O';
        }

    }

}
