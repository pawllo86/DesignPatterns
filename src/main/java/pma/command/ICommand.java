package pma.command;

public interface ICommand {

    String PRINT_SHORTCUT = "P";

    String UNDO_SHORTCUT = "U";

    String REDO_SHORTCUT = "R";

    void execute();

    void undo();

}
