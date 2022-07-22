package move;

import board.Board;
import board.Cell;
import figure.FigureAbstract;

public class SimpleMoveAction extends MoveAction {

    public SimpleMoveAction(Cell from, Cell to, FigureAbstract figureAbstract, Board board) {
        super(from, to, figureAbstract, board);
    }

    @Override
    public String toString() {
        return figureAbstract + " goes to " + to;
    }
}
