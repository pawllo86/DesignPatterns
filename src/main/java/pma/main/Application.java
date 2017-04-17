package pma.main;


import java.io.*;

public class Application {

    public static void main(String[] args) {
        try {
            Reader reader = new InputStreamReader(System.in, "UTF-8");
            BufferedReader in = new BufferedReader(reader);

            String command = in.readLine();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
