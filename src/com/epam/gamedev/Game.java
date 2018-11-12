package com.epam.gamedev;

import java.util.Scanner;

public class Game {


    boolean checkForWinner(char [][] f, boolean isCurrentX) {
        for (int i = 0; i < 3; i++) {
            // горизонталь / вертикаль
            if (((f[i][0] == f[i][1] && f[i][0] == f[i][2]) || (f[0][i] == f[1][i] && f[0][i] == f[2][i])) && f[i][i] != '-') {
                if (isCurrentX) {
                    System.out.println("Победили крестики");
                } else System.out.println("Победили нолики");
                return false;
            }
        }
        return true;
    }


    int getUserInputX() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            if (x > 0 && x < 4) {
                return x;
            } else System.out.println("Не валидное значение координаты x");
        }
    }

    int getUserInputY() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int y = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            if (y > 0 && y < 4) {
                return y;
            } else System.out.println("Не валидное значение координаты y");
        }
    }

}
