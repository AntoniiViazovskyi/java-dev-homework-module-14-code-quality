package org.goit.mainlogic;

import java.util.Scanner;

public class TicTacToe {

    private final Scanner scan = new Scanner(System.in);
    private int winner;
    boolean boxAvailable = false;
    boolean boxEmpty = false;
    public void setWinner(int winner) {this.winner = winner;}
    public boolean isBoxAvailable() {return boxAvailable;}
    public Scanner getScan() {return scan;}
    public char[] getBox() {return box;}

    private final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

     boolean checkStrikeForWin(char c) {
        return (box[0] == c && box[1] == c && box[2] == c)
                || (box[3] == c && box[4] == c && box[5] == c)
                || (box[6] == c && box[7] == c && box[8] == c)
                || (box[0] == c && box[3] == c && box[6] == c)
                || (box[1] == c && box[4] == c && box[7] == c)
                || (box[2] == c && box[5] == c && box[8] == c)
                || (box[0] == c && box[4] == c && box[8] == c)
                || (box[2] == c && box[4] == c && box[6] == c);
    }

    void showGameField() {
        System.out.printf("%n%n %s | %s | %s%n", box[0], box[1], box[2]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s %n", box[3], box[4], box[5]);
        System.out.println("-----------");
        System.out.printf(" %s | %s | %s %n%n", box[6], box[7], box[8]);
    }

    void hideFieldNumbers() {
        if (!boxEmpty) {
            for (int i = 0; i < 9; i++)
                box[i] = ' ';
            boxEmpty = true;
        }
    }

    void searchEmptyFields() {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
    }

    boolean findWinner() {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }
}
