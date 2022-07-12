package network.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetInfoCommand implements Command{

    BufferedReader reader;
    String filePath = System.getProperty("user.dir") + "\\data\\data.upskill";
    public GetInfoCommand() throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    @Override
    public String execute() {
        String inputLine = null;
        try {
            inputLine = reader.readLine();
            if (inputLine != null);
                return inputLine;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "not good";
    }
}
