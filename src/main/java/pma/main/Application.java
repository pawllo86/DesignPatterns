package pma.main;


import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Application {

    private static final Map<String, Integer> commands = new HashMap<>();

    static {
        commands.put("C", 2);
        commands.put("M", 3);
        commands.put("S", 2);
        commands.put("U", 0);
        commands.put("R", 0);
        commands.put("p", 0);
    }

    public static void main(String[] args) {

        try {
            Reader reader = new InputStreamReader(System.in, "UTF-8");
            BufferedReader in = new BufferedReader(reader);

            String[] input = in.readLine().split("\\s");
            String command = input[0];

            if (command != null && !command.trim().isEmpty() && commands.containsKey(command)) {
                int syntax = commands.get(command);
                if (syntax == (input.length - 1)) {

                }
            } else {
                System.out.println("No command: " + command);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
