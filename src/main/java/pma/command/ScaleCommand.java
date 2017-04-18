package pma.command;

import pma.receiver.SquareReceiver;

public class ScaleCommand implements ICommand {

    public static final String SHORTCUT = "S";

    private SquareReceiver receiver;

    private int number;

    private int factor;

    public ScaleCommand(SquareReceiver receiver, int number, int factor) {
        this.receiver = receiver;
        this.number = number;
        this.factor = factor;
    }

    @Override
    public void execute() {
        receiver.scaleSquare(number, factor);
    }

    @Override
    public void undo() {
        receiver.scaleSquare(number, 1/factor);
    }
}
