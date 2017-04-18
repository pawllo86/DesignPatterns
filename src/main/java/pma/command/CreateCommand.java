package pma.command;

import pma.receiver.SquareReceiver;

public class CreateCommand implements ICommand {

    public static final String SHORTCUT = "C";

    private SquareReceiver receiver;

    private int number;

    private int length;

    public CreateCommand(SquareReceiver receiver, int number, int length) {
        this.receiver = receiver;
        this.number = number;
        this.length = length;
    }

    @Override
    public void execute() {
        receiver.addSquare(number, length);
    }

    @Override
    public void undo() {
        receiver.removeSquare(number);
    }
}
