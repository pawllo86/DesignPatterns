package pma.command;

import pma.bean.Square;

import java.util.HashMap;
import java.util.Map;

public class CreateCommand implements ICommand {

    public static final String SHORTCUT = "C";

    private Map<Integer, Square> squares;

    private int number;

    private int length;

    public CreateCommand(Map<Integer, Square> squares, int number, int length) {
        this.squares = squares;
        this.number = number;
        this.length = length;
    }

    @Override
    public void execute() {
        if (squares == null) {
            squares = new HashMap<>();
        }
        squares.put(number, new Square(number, length));
    }

    @Override
    public void undo() {
        if (squares != null) {
            squares.remove(number);
        }
    }
}
