package board;

import figure.FigureAbstract;
import figure.types.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private FigureAbstract[][] board = new FigureAbstract[8][8];

    private List<FigureAbstract> whiteFigures = new ArrayList<>();

    private List<FigureAbstract> blackFigures = new ArrayList<>();


    public Board() {
        initWhiteTeam();
        initBlackTeam();
    }

    public void put(FigureAbstract figureAbstract) {
        if (figureAbstract.isWhite()) {
            whiteFigures.add(figureAbstract);
        } else {
            blackFigures.add(figureAbstract);
        }
        Cell cell = figureAbstract.getPosition();
        int x = cell.getX();
        int y = cell.getY();
        board[x][y] = figureAbstract;
    }

    public void del(FigureAbstract figureAbstract) {
        if (figureAbstract.isWhite()) {
            whiteFigures.remove(figureAbstract);
        } else {
            blackFigures.remove(figureAbstract);
        }

        Cell cell = figureAbstract.getPosition();
        int x = cell.getX();
        int y = cell.getY();
        board[x][y] = null;
    }

    public  boolean cellIsEmpty(Cell cell) {
        for (FigureAbstract[] line : board) {
            for (FigureAbstract f : line) {
                if (f != null && f.getPosition().equals(cell)) {
                    return false;
                }
            }
        }
        return true;
    }

    public  FigureAbstract findEnemyOnCell(FigureAbstract figureAbstract, Cell cell) {

        for (FigureAbstract[] line : board) {
            for (FigureAbstract f : line) {
                if (f != null && f.isWhite() != figureAbstract.isWhite() && f.getPosition().equals(cell)) {
                    return f;
                }
            }
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < 8; j++) {
                FigureAbstract f = board[j][i];
                StringBuilder str = new StringBuilder("--------------- ");
                if (f != null) {
                    int len = f.getName().length() + f.getColor().length() + 1;
                    int probs = 16 - len;
                    str = new StringBuilder(f.getName() + " " + f.getColor());

                    for (int k = 0; k < probs; k++) {
                        str.append(" ");
                    }

                }

                System.out.print(str);

            }
            System.out.println();
            System.out.println();

        }

        System.out.println("      A               B                C               D                E               F               G               H");
        System.out.println("*******************************************************************************************************************************");


    }

    public FigureAbstract[][] getBoard() {
        return board;
    }

    public List<FigureAbstract> getWhiteFigures() {
        return whiteFigures;
    }


    public List<FigureAbstract> getBlackFigures() {
        return blackFigures;
    }

    private void initWhiteTeam() {
        for (int i = 0; i < 8; i++) {
            whiteFigures.add(new Pawn(Cell.findBy(i, 6), true));
        }

        whiteFigures.add(new Knight(Cell.B1, true));
        whiteFigures.add(new Knight(Cell.G1, true));

        whiteFigures.add(new Rook(Cell.A1, true));
        whiteFigures.add(new Rook(Cell.H1, true));

        whiteFigures.add(new Bishop(Cell.C1, true));
        whiteFigures.add(new Bishop(Cell.F1, true));

        whiteFigures.add(new King(Cell.E1, true));

        whiteFigures.add(new Queen(Cell.D1, true));

        placeFiguresOnBoard(whiteFigures);
    }

    private void initBlackTeam() {
        for (int i = 0; i < 8; i++) {
            blackFigures.add(new Pawn(Cell.findBy(i, 1), false));
        }

        blackFigures.add(new Knight(Cell.B8, false));
        blackFigures.add(new Knight(Cell.G8, false));

        blackFigures.add(new Rook(Cell.A8, false));
        blackFigures.add(new Rook(Cell.H8, false));

        blackFigures.add(new Bishop(Cell.C8, false));
        blackFigures.add(new Bishop(Cell.F8, false));

        blackFigures.add(new King(Cell.E8, false));

        blackFigures.add(new Queen(Cell.D8, false));

        placeFiguresOnBoard(blackFigures);

    }

    private void placeFiguresOnBoard(List<FigureAbstract> figureAbstracts) {

        for (FigureAbstract figureAbstract : figureAbstracts) {
            Cell cell = figureAbstract.getPosition();
            int x = cell.getX();
            int y = cell.getY();
            board[x][y] = figureAbstract;
        }

    }
}
