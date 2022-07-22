package move;

import board.Board;
import board.Cell;
import figure.FigureAbstract;

public abstract class MoveAction {
    protected Cell from;
    protected Cell to;
    protected FigureAbstract figureAbstract;
    protected FigureAbstract enemy;

    protected Board board;

    public MoveAction(Cell from, Cell to, FigureAbstract figureAbstract, Board board) {
        this.from = from;
        this.to = to;
        this.figureAbstract = figureAbstract;
        this.board = board;
    }

    public MoveAction(Cell from, Cell to, FigureAbstract figureAbstract, FigureAbstract enemy, Board board) {
        this.from = from;
        this.to = to;
        this.figureAbstract = figureAbstract;
        this.enemy = enemy;
        this.board = board;
    }

    public void execute(){
        System.out.println("---------------");
        System.out.println(this);
        System.out.println("---------------");

        board.del(figureAbstract);
        figureAbstract.move(to);
        board.put(figureAbstract);
    }

    public FigureAbstract getFigure() {
        return figureAbstract;
    }

}
