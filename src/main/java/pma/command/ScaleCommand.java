package pma.command;

import pma.bean.Square;

import java.util.Map;

public class ScaleCommand implements ICommand {

    public static final String SHORTCUT = "S";

    private Map<Integer, Square> squares;

    private int number;

    private int factor;

    public ScaleCommand(Map<Integer, Square> squares, int number, int factor) {
        this.squares = squares;
        this.number = number;
        this.factor = factor;
    }

    @Override
    public void execute() {
        if (squares != null && squares.containsKey(number)) {
            Square square = squares.get(number);
            square.setLength(square.getLength() * factor);
        }
    }

    @Override
    public void undo() {
        if (squares != null && squares.containsKey(number)) {
            Square square = squares.get(number);
            square.setLength(square.getLength() / factor);
        }
    }
}
