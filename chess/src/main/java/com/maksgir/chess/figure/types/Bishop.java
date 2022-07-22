package figure.types;

import board.Board;
import board.Cell;
import figure.LineMovingFigure;
import move.MoveAction;

import java.util.List;

public class Bishop extends LineMovingFigure {

    public Bishop(Cell position, boolean isWhite) {
        super(position, isWhite, 8);
    }

    @Override
    public List<MoveAction> getAllPossibleMoves(Board board) {
        return getDiagonalLineMoves(board);
    }
}
