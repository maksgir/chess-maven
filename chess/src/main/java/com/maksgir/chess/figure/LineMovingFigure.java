package figure;

import board.Board;
import board.Cell;
import move.MoveAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public abstract class LineMovingFigure extends FigureAbstract {


    public LineMovingFigure(Cell position, boolean isWhite, int step) {
        super(position, isWhite, step);
    }

    protected List<MoveAction> getStraightLineMoves(Board board) {
        List<Cell> cells = new ArrayList<>();

        cells.addAll(directionLineMoves(board, Cell::goLeft));
        cells.addAll(directionLineMoves(board, Cell::goRight));
        cells.addAll(directionLineMoves(board, Cell::goForward));
        cells.addAll(directionLineMoves(board, Cell::goBackward));

        cells.removeIf(Objects::isNull);

        return createMoves(cells, board);
    }

    protected List<MoveAction> getDiagonalLineMoves(Board board) {
        List<Cell> cells = new ArrayList<>();

        cells.addAll(directionLineMoves(board, Cell::goUpperLeftDiagonal));
        cells.addAll(directionLineMoves(board, Cell::goUpperRightDiagonal));
        cells.addAll(directionLineMoves(board, Cell::goDownLeftDiagonal));
        cells.addAll(directionLineMoves(board, Cell::goDownRightDiagonal));

        cells.removeIf(Objects::isNull);

        return createMoves(cells, board);
    }

    private List<Cell> directionLineMoves(Board board,
                                          BiFunction<Integer,
                                                  Cell, Cell> function) {
        List<Cell> cells = new ArrayList<>();

        for (int i = 1; i <= step; i++) {
            Cell newCell = function.apply(i, position);
            if (board.cellIsEmpty(newCell)) {
                cells.add(newCell);
            } else if (board.findEnemyOnCell(this, newCell) != null) {
                cells.add(newCell);
                break;
            } else {
                break;
            }
        }
        return cells;
    }
}
