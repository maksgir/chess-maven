package figure.types;

import board.Board;
import board.Cell;
import figure.LineMovingFigure;
import move.MoveAction;

import java.util.List;

public class Rook extends LineMovingFigure {
    public Rook(Cell position, boolean isWhite) {
        super(position, isWhite,8);
    }

    @Override
    public List<MoveAction> getAllPossibleMoves(Board board) {
        return getStraightLineMoves(board);
    }
}
