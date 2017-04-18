package pma.invoker;

import pma.command.ICommand;

import java.util.ArrayList;
import java.util.List;

public class SquareManipulationSystem {

    private List<ICommand> commands = new ArrayList<>();

    private int currentCommand;

    public void setCommand(ICommand command) {
        commands.add(command);
    }

    public void executeCommand() {
        commands.get(currentCommand++).execute();
    }

    public void executeUndo() {
        if (currentCommand > 0) {
            commands.get(--currentCommand).undo();
        }
    }

    public void executeRedo() {
        if (currentCommand < commands.size()) {
            commands.get(currentCommand++).execute();
        }
    }

}