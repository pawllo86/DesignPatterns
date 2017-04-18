package pma.main;


import pma.command.CreateCommand;
import pma.command.ICommand;
import pma.command.MoveCommand;
import pma.command.ScaleCommand;
import pma.invoker.SquareManipulationSystem;
import pma.receiver.SquareReceiver;

import java.io.*;

public class Application {

    public static void main(String[] args) {
        SquareManipulationSystem system = new SquareManipulationSystem();
        SquareReceiver receiver = new SquareReceiver();

        try {
            Reader reader = new InputStreamReader(System.in, "UTF-8");
            BufferedReader in = new BufferedReader(reader);

            while (true) {
                String[] input = in.readLine().split("\\s");
                String commandText = input[0];

                if (commandText.toLowerCase().equals("exit")) {
                    return;
                }
                ICommand command = null;

                switch (commandText) {
                    case CreateCommand.SHORTCUT:
                        command = new CreateCommand(receiver, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                        break;
                    case MoveCommand.SHORTCUT:
                        command = new MoveCommand(receiver, Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                        break;
                    case ScaleCommand.SHORTCUT:
                        command = new ScaleCommand(receiver, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                        break;
                    case ICommand.PRINT_SHORTCUT:
                        receiver.printSquares();
                        continue;
                    case ICommand.UNDO_SHORTCUT:
                        system.executeUndo();
                        continue;
                    case ICommand.REDO_SHORTCUT:
                        system.executeRedo();
                        continue;
                    default:
                        System.out.println("Command not exists!");
                }

                if (command != null) {
                    system.setCommand(command);
                    system.executeCommand();
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
