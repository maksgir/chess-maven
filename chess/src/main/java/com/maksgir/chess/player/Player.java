package player;

import board.Board;
import figure.FigureAbstract;
import move.MoveAction;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Board board;
    private boolean isWhite;

    public Player(Board board, boolean isWhite) {
        this.board = board;
        this.isWhite = isWhite;
    }


    public boolean move() {
        List<MoveAction> allMoveActions = getAllMoves();

        if (allMoveActions.isEmpty()) {
            loose();
            return false;
        }

        MoveAction moveAction = chooseMove(allMoveActions);

        moveAction.execute();

        return true;

    }

    private List<MoveAction> getAllMoves() {
        List<MoveAction> allMoveActions = new ArrayList<>();
        for (FigureAbstract f : getFigures()) {
//            System.out.println("Figure " + f+" has such moves:");
//            System.out.println(f.getAllPossibleMoves(board));
            allMoveActions.addAll(f.getAllPossibleMoves(board));
        }

        return allMoveActions;
    }


    private MoveAction chooseMove(List<MoveAction> moveActions) {
        RandomDataGenerator generator = new RandomDataGenerator();

        return moveActions.get(generator.nextInt(0, moveActions.size()-1));
    }


    private List<FigureAbstract> getFigures() {
        return isWhite ? board.getWhiteFigures() : board.getBlackFigures();
    }

    private void loose() {
        System.out.println("Player of team - " + (isWhite ? "white" : "black") + " losses");
    }
}
