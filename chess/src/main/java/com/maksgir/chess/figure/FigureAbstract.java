package figure;

import board.Board;
import board.Cell;
import move.KillingMoveAction;
import move.MoveAction;
import move.SimpleMoveAction;

import java.util.ArrayList;
import java.util.List;

public abstract class FigureAbstract {

    protected Cell position;
    protected boolean isWhite;
    protected int step;

    public FigureAbstract(Cell position, boolean isWhite, int step) {
        this.position = position;
        this.isWhite = isWhite;
        this.step =step;
    }

    public abstract List<MoveAction> getAllPossibleMoves(Board board);

    protected List<MoveAction> createMoves(List<Cell> possibleCells, Board board){
        List<MoveAction> moveActions = new ArrayList<>();
        for (Cell c : possibleCells) {
            FigureAbstract enemy = board.findEnemyOnCell(this, c);
            if (enemy != null) {
                moveActions.add(new KillingMoveAction(position, c, this, enemy, board));
            } else {
                if (board.cellIsEmpty(c)) {
                    moveActions.add(new SimpleMoveAction(position, c, this, board));
                }
            }

        }
        return moveActions;
    }


    public String getColor() {
        return isWhite ? "White" : "Black";
    }


    public void move(Cell newCell) {
        position = newCell;
    }

    public Cell getPosition() {
        return position;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public String getName(){
        return getClass().getSimpleName();
    }


    public String toString() {
        return getColor() + " " + getName() + " on " + position;
    }
}
