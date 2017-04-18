package pma.main;


import pma.bean.Square;
import pma.command.*;
import pma.invoker.SquareManipulationSystem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Application {

    private static Map<Integer, Square> squares = new HashMap<>();

    public static void main(String[] args) {
        SquareManipulationSystem system = new SquareManipulationSystem();

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
                        command = new CreateCommand(squares, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                        break;
                    case MoveCommand.SHORTCUT:
                        command = new MoveCommand(squares, Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                        break;
                    case ScaleCommand.SHORTCUT:
                        command = new ScaleCommand(squares, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                        break;
                    case ICommand.PRINT_SHORTCUT:
                        squares.forEach((number, square) ->
                                System.out.format("Square %s: [%s, %s] - side length %s \n", number, square.getX(), square.getY(), square.getLength()));
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
