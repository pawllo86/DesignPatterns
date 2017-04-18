package pma.command;

import pma.receiver.SquareReceiver;

public class MoveCommand implements ICommand {

    public static final String SHORTCUT = "M";

    private SquareReceiver receiver;

    private int number;

    private int x;

    private int y;

    public MoveCommand(SquareReceiver receiver, int number, int x, int y) {
        this.receiver = receiver;
        this.number = number;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        receiver.moveSquare(number, x, y);
    }

    @Override
    public void undo() {
        receiver.moveSquare(number, -x, -y);
    }
}
