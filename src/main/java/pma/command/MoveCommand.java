package pma.command;

import pma.bean.Square;

import java.util.Map;

public class MoveCommand implements ICommand {

    public static final String SHORTCUT = "M";

    private Map<Integer, Square> squares;

    private int number;

    private int x;

    private int y;

    public MoveCommand(Map<Integer, Square> squares, int number, int x, int y) {
        this.squares = squares;
        this.number = number;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        if (squares != null && squares.containsKey(number)) {
            Square square = squares.get(number);
            square.setX(square.getX() + x);
            square.setY(square.getY() - y);
        }
    }

    @Override
    public void undo() {
        if (squares != null && squares.containsKey(number)) {
            Square square = squares.get(number);
            square.setX(square.getX() - x);
            square.setY(square.getY() + y);
        }
    }
}
