package figure.types;

import board.Board;
import board.Cell;
import figure.FigureAbstract;
import move.KillingMoveAction;
import move.MoveAction;
import move.SimpleMoveAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public class Pawn extends FigureAbstract {

    public Pawn(Cell cell, boolean isWhite) {
        super(cell, isWhite, 1);
    }

    @Override
    public List<MoveAction> getAllPossibleMoves(Board board) {

        List<MoveAction> allPossibleMoves = new ArrayList<>();

        allPossibleMoves.addAll(getSimpleMoves(board));
        allPossibleMoves.addAll(getKillingMoves(board));
        return allPossibleMoves;
    }


    private List<MoveAction> getSimpleMoves(Board board){
        List<MoveAction> possibleSimpleMoves = new ArrayList<>();

        List<Cell> possibleCellsToMoveOn = new ArrayList<>();

        possibleCellsToMoveOn.add(isWhite?
                Cell.goForward(1, position):
                Cell.goBackward(1, position));

        if (isWhite() && position.getY() == 6) {
            possibleCellsToMoveOn.add(Cell.goForward(2, position));
        } else if (!isWhite() && position.getY() == 1) {
            possibleCellsToMoveOn.add(Cell.goBackward(2, position));
        }

        possibleCellsToMoveOn.removeIf(Objects::isNull);

        for (Cell newPosition : possibleCellsToMoveOn) {
            boolean newCellIsEmpty = board.cellIsEmpty(newPosition);
            if (newCellIsEmpty && newPosition != null) {
                possibleSimpleMoves.add(new SimpleMoveAction(position, newPosition, this, board));
            }
        }

        return possibleSimpleMoves;
    }

    private List<MoveAction> getKillingMoves(Board board){
        List<MoveAction> possibleKillingMoves = new ArrayList<>();

        if (isWhite()) {
            possibleKillingMoves.add(createKillingMove(board, Cell::goUpperLeftDiagonal));
            possibleKillingMoves.add(createKillingMove(board, Cell::goUpperRightDiagonal));
        } else {
            possibleKillingMoves.add(createKillingMove(board, Cell::goDownLeftDiagonal));
            possibleKillingMoves.add(createKillingMove(board, Cell::goDownRightDiagonal));
        }

        possibleKillingMoves.removeIf(Objects::isNull);

        return possibleKillingMoves;
    }

    private KillingMoveAction createKillingMove(Board board,
                                                       BiFunction<Integer, Cell, Cell> directionToKill) {

        Cell enemyCell = directionToKill.apply(1, position);

        FigureAbstract enemy = board.findEnemyOnCell(this, enemyCell);

        if (enemy != null) {
            return new KillingMoveAction(position, enemyCell, this, enemy, board);
        }

        return null;

    }

}
