package org.goit.players;

import org.goit.mainlogic.TicTacToe;

import java.util.logging.Logger;

public class HumanPlayer implements TicTacPoePlayeable {
    private TicTacToe ticTacToe;
    Logger logger = Logger.getLogger(getClass().getName());

    public HumanPlayer(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }


    @Override
    public void playerMove() {
        while (true) {
            byte input = ticTacToe.getScan().nextByte();
            if (input > 0 && input < 10) {
                if (ticTacToe.getBox()[input - 1] == 'X' || ticTacToe.getBox()[input - 1] == 'O')
                    logger.info("That one is already in use. Enter another.");
                else {
                    ticTacToe.getBox()[input - 1] = 'X';
                    break;
                }
            } else
                logger.info("Invalid input. Enter again.");
        }
    }
}
