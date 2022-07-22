package figure.types;

import board.Board;
import board.Cell;
import figure.LineMovingFigure;
import move.MoveAction;

import java.util.ArrayList;
import java.util.List;

public class Queen extends LineMovingFigure {
    public Queen(Cell position, boolean isWhite) {
        super(position, isWhite, 8);
    }

    @Override
    public List<MoveAction> getAllPossibleMoves(Board board) {
        List<MoveAction> allMoves = new ArrayList<>();
        allMoves.addAll(getStraightLineMoves(board));
        allMoves.addAll(getDiagonalLineMoves(board));

        return allMoves;
    }
}
