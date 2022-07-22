
import board.Board;
import player.Player;

import java.util.Scanner;

public class Game2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Board board = new Board();

        Player whitePlayer = new Player(board, true);
        Player blackPlayer = new Player(board, false);

        System.out.println("Game started.");

        boolean run = true;
        int movesCounter = 0;

        board.display();

        while (run) {
            //String command = in.nextLine(); // dell so as to stop before each player's move
            movesCounter++;
            if (movesCounter % 2 == 1) {
                run = whitePlayer.move();
            } else {
                run = blackPlayer.move();
            }
            // board.display(); // dell so as to track all possible figure's moves

        }

        board.display();

        System.out.println("Это была игра из Game2");
    }


}
