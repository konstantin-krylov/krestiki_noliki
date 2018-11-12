package com.epam.gamedev;

public class Launcher {
    public static void main(String[] args) {
        boolean gameNotFinish = true;
        GameField field = new GameField();
        Game game = new Game();
        boolean isCurrentX = true;
        field.printField();
        while (gameNotFinish) {
            System.out.println("Введите координаты " + (isCurrentX ? "крестика" : "нолика"));

            int x = game.getUserInputX();
            int y = game.getUserInputY();

            field.updateField(x,y, isCurrentX);
            field.printField();

            gameNotFinish = game.checkForWinner(field.field,isCurrentX);
            isCurrentX = !isCurrentX;
        }



    }
}
