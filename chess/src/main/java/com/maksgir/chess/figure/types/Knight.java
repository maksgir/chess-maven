package figure.types;

import board.Board;
import board.Cell;
import figure.FigureAbstract;
import move.MoveAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Knight extends FigureAbstract {
    public Knight(Cell position, boolean isWhite) {
        super(position, isWhite, 3);
    }

    @Override
    public List<MoveAction> getAllPossibleMoves(Board board) {
        return createMoves(getPossibleCellsToMove(), board);
    }

    private List<Cell> getPossibleCellsToMove() {
        List<Cell> cells = new ArrayList<>();

        cells.add(Cell.findBy(position.getX() - 1, position.getY() + 2));
        cells.add(Cell.findBy(position.getX() + 1, position.getY() + 2));
        cells.add(Cell.findBy(position.getX() - 1, position.getY() - 2));
        cells.add(Cell.findBy(position.getX() + 1, position.getY() - 2));
        cells.add(Cell.findBy(position.getX() - 2, position.getY() + 1));
        cells.add(Cell.findBy(position.getX() + 2, position.getY() + 1));
        cells.add(Cell.findBy(position.getX() - 2, position.getY() - 1));
        cells.add(Cell.findBy(position.getX() + 2, position.getY() - 1));

        cells.removeIf(Objects::isNull);
        return cells;
    }
}
