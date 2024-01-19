package org.goit.mainlogic;

import org.goit.players.ComputerRandomPlayer;
import org.goit.players.HumanPlayer;
import org.goit.players.TicTacPoePlayeable;

public class App {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        TicTacPoePlayeable human = new HumanPlayer(game);
        TicTacPoePlayeable computer = new ComputerRandomPlayer(game);

        while (true) {
            game.showGameField();
            game.hideFieldNumbers();
            if (game.findWinner()) {
                break;
            }
            human.playerMove();
            if (game.checkStrikeForWin('X')) {
                game.setWinner(1);
                continue;
            }
            game.searchEmptyFields();

            if (!game.isBoxAvailable()) {
                game.setWinner(3);
                continue;
            }
            computer.playerMove();
            if (game.checkStrikeForWin('O')) {
                game.setWinner(2);
            }
        }
    }
}
