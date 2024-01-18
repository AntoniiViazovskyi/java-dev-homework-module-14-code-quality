package org.goit.mainlogic;

import java.util.Scanner;

public class TicTacToe implements Game{

    private final Scanner scan = new Scanner(System.in);
    private byte winner = 0;
    private final char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public void playGame() {

        boolean boxEmpty = false;
        while (true) {
            System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

            if(!boxEmpty){
                for(int i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            if(winner == 1){
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if(winner == 2){
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if(winner == 3){
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            while (true) {
                byte input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                }
                else
                    System.out.println("Invalid input. Enter again.");
            }

            if(checkFields('X')){
                winner = 1;
                continue;
            }

            boolean boxAvailable = false;
            for(int i=0; i<9; i++){
                if(box[i] != 'X' && box[i] != 'O'){
                    boxAvailable = true;
                    break;
                }
            }

            if(!boxAvailable){
                winner = 3;
                continue;
            }

            while (true) {
                byte random = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[random - 1] != 'X' && box[random - 1] != 'O') {
                    box[random - 1] = 'O';
                    break;
                }
            }

            if(checkFields('O')) {
                winner = 2;
            }
        }
    }

    private boolean checkFields(char c){
        return (box[0] == c && box[1] == c && box[2] == c) || (box[3] == c && box[4] == c && box[5] == c) || (box[6] == c && box[7] == c && box[8] == c) ||
                (box[0] == c && box[3] == c && box[6] == c) || (box[1] == c && box[4] == c && box[7] == c) || (box[2] == c && box[5] == c && box[8] == c) ||
                (box[0] == c && box[4] == c && box[8] == c) || (box[2] == c && box[4] == c && box[6] == c);
    }
}
