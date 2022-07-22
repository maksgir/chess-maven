package move;

import board.Board;
import board.Cell;
import figure.FigureAbstract;

public class KillingMoveAction extends MoveAction {


    public KillingMoveAction(Cell from, Cell to, FigureAbstract figureAbstract, FigureAbstract enemy, Board board) {
        super(from, to, figureAbstract, enemy, board);
    }

    @Override
    public void execute() {
        board.del(enemy);
        super.execute();

    }

    @Override
    public String toString() {
        return figureAbstract + " eats " + enemy;
    }
}
