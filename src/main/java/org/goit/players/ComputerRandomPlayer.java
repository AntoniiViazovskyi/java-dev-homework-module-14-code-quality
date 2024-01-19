package org.goit.players;

import org.goit.mainlogic.TicTacToe;

public class ComputerRandomPlayer implements TicTacPoePlayeable {
    TicTacToe ticTacToe;

    public ComputerRandomPlayer(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    @Override
    public void playerMove() {
        while (true) {
            byte random = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (ticTacToe.getBox()[random - 1] != 'X' && ticTacToe.getBox()[random - 1] != 'O') {
                ticTacToe.getBox()[random - 1] = 'O';
                break;
            }
        }
    }
}
